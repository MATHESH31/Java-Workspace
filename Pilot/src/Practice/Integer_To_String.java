package Practice;

import java.util.*;

public class Integer_To_String {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n>=(-100) && n <= 100){
            String a = Integer.toString(n);
            if((a.getClass().getSimpleName()).equals("String")){
                System.out.println("Good job");
            }
            else {
            	System.out.println("Wrong answer");
            }
        }
        in.close();
	}

}

