package Practice;

import java.util.*;

public class KaprekarNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int k = in.nextInt();
      	int check = 0;
      
      	int n = k*k;
      	String n1 = Integer.toString(n);
        for(int i = 0;i>n1.length();i++){
        	check += n1.charAt(i);
        }
      	if(k == check){
        	System.out.println("Kaprekar Number");
        }
      	else{
        	System.out.println("Not a Kaprekar Number");
        }
      	in.close();

	}

}
