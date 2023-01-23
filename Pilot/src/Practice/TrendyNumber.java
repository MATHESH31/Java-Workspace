package Practice;

import java.util.*;

public class TrendyNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int number = in.nextInt();
      	String check = Integer.toString(number);
      
      	if(check.length() == 3){
        	if(check.charAt(1) % 3 == 0){
            	System.out.println("Trendy Number");
            }
          	else{
            	System.out.println("Not a Trendy Number");
            }
        }
      else{
      	System.out.println("Not a Trendy Number");
      }
      in.close();

	}

}
