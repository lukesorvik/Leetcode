
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTacToe implements ActionListener {


    //determine whos turn it is first randomly
    Random random = new Random(); //new random object
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn; //false = player2's turn




    //constructor method
    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50)); //
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        //^ these all set the frame

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);

        textfield.setText("TIC-TAC-TOE");
        textfield.setOpaque(true);

        //title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);//cordinite where we want it to start, 0,0 is top left corner

        //button pannel
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150,150,150));
        //^this just adds a gray pannel

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD ,120 ));
            buttons[i].addActionListener(this); //checks for actions at the current button
        }


        title_panel.add(textfield); //adds the created text to the title panel
        frame.add(title_panel, BorderLayout.NORTH); //adds the title panel to the frame?
        //BorderLayout.NORTH this makes the title stick to the top of program
        frame.add(button_panel); //adds the buttom pannel to the frame


        //at the end of the construct calls the first turn method
        firstTurn();


    }


    //method that runs when a button is clicked
    public void actionPerformed(ActionEvent e) {

        //runs once for each button, checks each of 9 buttons
        for (int i = 0; i < 9; i++) {

            //if the action performed was at current button?
            if(e.getSource() == buttons[i]) {

                if (player1_turn) {
                    //returns true if is players1 turn
                    if(buttons[i].getText() == "") { //text is nothing if empty button
                        buttons[i].setForeground(new Color(255,0,0)); //sets new button color
                        buttons[i].setText("X"); //sets text within button
                        player1_turn = false; //changes to player2's turn
                        textfield.setText("O Turn"); //sets the title text to say that it is o's turn
                        check();//calls to check if someone won
                    }
                }

                //player2 turn
                else {
                    if(buttons[i].getText() == "") { //if statement runs only if current button is empty
                        buttons[i].setForeground(new Color(0,0,255)); //changes the text color for the botton
                        buttons[i].setText("O"); //sets the text displayed at current button
                        player1_turn = true; //changes to player 1's turn
                        textfield.setText("X Turn"); //sets title to say it is x's turn
                        check(); //checks to see if someone won
                    }
                }

            }

        }



    }



    //first turn method
    public void firstTurn() {

        //sets program to sleep for 2000 mili seconds (2 seconds)
        //so the title can be displayed for a bit
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //code to determine who's turn is first
        if (random.nextInt(2) == 0) {
            //if a random number between 0 and 1 is = 0
            player1_turn = true;
            textfield.setText("X Turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O Turn");
        }

    }

    //function to check if someone won
    public void check() {
        //check x win condictions
        if (
            (buttons[0].getText()== "X") &&
            (buttons[1].getText()== "X") &&
            (buttons[2].getText()== "X")
             ) {
                xWins(0, 1, 2); 
             }

        if (
            (buttons[3].getText()== "X") &&
            (buttons[4].getText()== "X") &&
            (buttons[5].getText()== "X")
             ) {
                xWins(3, 4, 5); 
             }
        if (
            (buttons[6].getText()== "X") &&
            (buttons[7].getText()== "X") &&
            (buttons[8].getText()== "X")
             ) {
                xWins(6, 7, 8); 
             }
        //^checks all rows

         //first column
          if (
            (buttons[0].getText()== "X") &&
            (buttons[3].getText()== "X") &&
            (buttons[6].getText()== "X")
             ) {
                xWins(0, 3, 6); 
             }

        //second column
        if (
            (buttons[1].getText()== "X") &&
            (buttons[4].getText()== "X") &&
            (buttons[7].getText()== "X")
             ) {
                xWins(1, 4, 7); 
             }
        //last column
          if (
            (buttons[2].getText()== "X") &&
            (buttons[5].getText()== "X") &&
            (buttons[8].getText()== "X")
             ) {
                xWins(2, 5, 8); 
             }
       
        //check diagonals
         //d1
          if (
            (buttons[0].getText()== "X") &&
            (buttons[4].getText()== "X") &&
            (buttons[8].getText()== "X")
             ) {
                xWins(0, 4, 8); 
             }
            //d2
          if (
            (buttons[2].getText()== "X") &&
            (buttons[4].getText()== "X") &&
            (buttons[6].getText()== "X")
             ) {
                xWins(2, 4, 6); 
             }


    
            //-----------------------------------------------------------------
        //check o win conditions
        if (
            (buttons[0].getText()== "O") &&
            (buttons[1].getText()== "O") &&
            (buttons[2].getText()== "O")
             ) {
                oWins(0, 1, 2); 
             }

        if (
            (buttons[3].getText()== "O") &&
            (buttons[4].getText()== "O") &&
            (buttons[5].getText()== "O")
             ) {
                oWins(3, 4, 5); 
             }
        if (
            (buttons[6].getText()== "O") &&
            (buttons[7].getText()== "O") &&
            (buttons[8].getText()== "O")
             ) {
                oWins(6, 7, 8); 
             }
        //^checks all rows

         //first column
          if (
            (buttons[0].getText()== "O") &&
            (buttons[3].getText()== "O") &&
            (buttons[6].getText()== "O")
             ) {
                oWins(0, 3, 6); 
             }

        //second column
        if (
            (buttons[1].getText()== "O") &&
            (buttons[4].getText()== "O") &&
            (buttons[7].getText()== "O")
             ) {
                oWins(1, 4, 7); 
             }
        //last column
          if (
            (buttons[2].getText()== "O") &&
            (buttons[5].getText()== "O") &&
            (buttons[8].getText()== "O")
             ) {
                oWins(2, 5, 8); 
             }
       
        //check diagonals
         //d1
          if (
            (buttons[0].getText()== "O") &&
            (buttons[4].getText()== "O") &&
            (buttons[8].getText()== "O")
             ) {
                oWins(0, 4, 8); 
             }
            //d2
          if (
            (buttons[2].getText()== "O") &&
            (buttons[4].getText()== "O") &&
            (buttons[6].getText()== "O")
             ) {
                oWins(2, 4, 6); 
             }



    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        //changes all buttons to green

        //makes so you cant use buttons
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        //changes all buttons to green

        //makes so you cant use buttons
        for (int i = 0; i <9 ; i++) {
            buttons[i].setEnabled(false);
        }

        textfield.setText("O wins");

    }


    
}
