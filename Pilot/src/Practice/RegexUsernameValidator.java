package Practice;

import java.util.*;

class Solution {
    
    public static final String regularExpression = "^[A-Za-z]\\\\w{7,29}$";
}


public class RegexUsernameValidator {
    private static final Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = Integer.parseInt(in.nextLine());
        while (n-- != 0) {
            String userName = in.nextLine();

            if (userName.matches(Solution.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }           
        }
    }
}