package Practice;

import java.util.*;

public class SeceDining {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	String door = in.next();
      	int rail = in.nextInt();
      
      	if((door.equals("front") && rail == 1) || (door.equals("rear") && rail == 2)){
        	System.out.println("Left Handed");
        }
      	else if((door.equals("front") && rail == 2) || (door.equals("rear") && rail == 1)){
        	System.out.println("Right Handed");
        }
      	else{
        	System.out.println("Nothing");
        }
      	in.close();

	}

}
