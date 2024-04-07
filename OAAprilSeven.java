public class OAAprilSeven {
    /*
     * One way bridge that can carry at most 2 cars at the same time
     * Bridge can carray a max weight of U units
     * 
     * weight[k] = the weights of the k-th car, weight[0] is the first car that enters the bridge
     *
     * To prevent a situation when all cars on the bridge exceed U some drivers have to turn back (removed from the queue
     * If a driver is removed from the queue al ldrivers behind them move one position closer on the bride (linked list queue?)
     * The driver who turns back is removed from the line and will not try to cross the bridge again
     * 
     * Your task is to find the minimum number of drivers that must turn back so that the bridge will not be Overloaded
     * (ensure all cars get across the bridge, only turn back the a number of cars that minimizes how many people have to turn around
     * 
     * 
     * 
     * My solution:
     * Have two pointers to keep track of the cars on the bridge
     * left pointer points to the first car in the queue
     * right pointer points to the second car in the queue
     * If the sum of the weights of the cars on the bridge is greater than U, then we must turn back a driver
     * In each specific case, we move the points so that the left pointer points to the car that is still on the bridge, and the right pointer points to the next car in the queue
     * 
     * Runtime: O(n) iterate through the array once
     * Space: O(1) no extra space used
     */

     public static void main(String[] args) {
        OAAprilSeven test = new OAAprilSeven();
         int[] weight = {7,6,5,2,7,4,5,4};
         int U = 7;
         System.out.println(test.solution(1, new int[]{2,2,2}));
         System.out.println(test.solution(1, new int[]{2,2,2,2}));
        System.out.println(test.solution(9, new int[]{5,3,8,1,8,7,7,6}));
         System.out.println(test.solution(U, weight));
         System.out.println(test.solution(7,new int[]{3,4,3,1}));
     }

     public int solution(int U, int[] weight) {
        int turnBack = 0; //initialize the number of drivers that must turn back

        int left = 0; //left pointer, points to first car in queue
        int right = 1; //right pointer, points to second car in queue

        while(left < weight.length && right < weight.length) { //iterate through the array

            //if the sum of the weights of the cars on the bridge is greater than U
            if(weight[left] + weight[right] > U) { 
                turnBack++; 

                //tell left to move back, move the pointers
                if (weight[left] > weight[right]) { 
                    left = right; //set the left pointer to keep track of the right car
                    right++; //point to the next car in the queue
                } else { //weight[left] < weight[right], right car turns back
                    //move right pointer foward, test next car coming into the bridge
                    //keep left pointer the same, since that car is still on the bridge
                    right++;
                    
                }
            }
            //weight of the two cars are valid
            else{
                left = right; //move the left pointer to the right pointer
                right++; //move the right pointer to the next car in the queue
            }
        }
        //this is the case when all cars are heavier than U
        //in this case the left pointer never moves, so if the first and last car are greater than U, then we must turn back the last car
        //since the left pointer is still pointing to the first car
        if(weight[left] >U && weight[right-1] > U) { //if the last car on the bridge is greater than U
            turnBack++; //turn back the last car
        }


        return turnBack;
    }
}
