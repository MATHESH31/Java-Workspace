package Practice;

import java.util.*;

public class StringFromatting {
	
	public static String capitalize(String check) {

        char firstLetter = check.charAt(0);
        char capitalFirstLetter = Character.toUpperCase(firstLetter);
        return check.replace(check.charAt(0), capitalFirstLetter);
    }

    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        String A=in.next();
        String B=in.next();
        int check = A.compareTo(B);
        
        System.out.println(A.length()+B.length());
        if(check <= 0){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
        System.out.println(capitalize(A)+" "+capitalize(B));
        in.close();
    }
}
