package Practice;

import java.util.*;

public class CircleIntersection {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int x1 = in.nextInt();
        int y1 = in.nextInt();
        int r1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int r2 = in.nextInt();
      
        int c=(int)(Math.sqrt(((x1-x2)*(x1-x2))+(y1-y2)*(y1-y2)));
		if(c==r1+r2) {
    		System.out.println("Tangential");
		}
		else if(c>r1+r2) {
    		System.out.println("Do not overlap");
		}
		else {
    		System.out.println("Overlap");
		}
      	in.close();

	}

}
