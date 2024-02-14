import java.util.Arrays;

class valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char schars[] = s.toCharArray();
        char tchars[] = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }

        return true;

        //sort the elements in both
        //compare if the characters are the same 
    }

 
    
}