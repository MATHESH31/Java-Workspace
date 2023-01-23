package Practice;

import java.util.*;

public class TimeSheet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int sunday = in.nextInt();
      	int monday = in.nextInt();
      	int tuesday = in.nextInt();
      	int wednesday = in.nextInt();
      	int thursday = in.nextInt();
      	int friday = in.nextInt();
      	int saturday = in.nextInt();
      
      	if(monday>8 || tuesday>8 || wednesday>8 || thursday>8 || friday>8){
      		if(monday>8) {
      			int total = (int) ((sunday*100)+((sunday*100)*0.5) + ((monday*100)+(monday-8*115)) + (tuesday*100) + (wednesday*100) + (thursday*100) + (friday*100) + ((saturday*100)+((saturday*100)*0.25)));
      			System.out.println(total);
      		}
      		else if(tuesday>8) {
      			int total = (int) ((sunday*100)+((sunday*100)*0.5) + (monday*100) + ((tuesday*100)+(tuesday-8*115)) + (wednesday*100) + (thursday*100) + (friday*100) + ((saturday*100)+((saturday*100)*0.25)));
      			System.out.println(total);
      		}
      		else if(wednesday>8) {
      			int total = (int) ((sunday*100)+((sunday*100)*0.5) + (monday*100) + (tuesday*100) + ((wednesday*100)+(wednesday-8*115)) + (thursday*100) + (friday*100) + ((saturday*100)+((saturday*100)*0.25)));
      			System.out.println(total);
      		}
      		else if(thursday>8) {
      			int total = (int) ((sunday*100)+((sunday*100)*0.5) + (monday*100) + (tuesday*100) + (wednesday*100) + ((thursday*100)+(thursday-8*115)) + (friday*100) + ((saturday*100)+((saturday*100)*0.25)));
      			System.out.println(total);
      		}
      		else if(friday>8) {
      			int total = (int) ((sunday*100)+((sunday*100)*0.5) + (monday*100) + (tuesday*100) + (wednesday*100) + (thursday*100) + ((friday*100)+(friday-8*115)) + ((saturday*100)+((saturday*100)*0.25)));
      			System.out.println(total);
      		}
      	}
      	else if((monday+tuesday+wednesday+thursday+friday)>40) {
      		int total = (int) ((sunday*100)+((sunday*100)*0.5)+(((monday+tuesday+wednesday+thursday+friday)-40)*125)+((saturday*100)+((saturday*100)*0.25)));
      		System.out.println(total);
      	}
      	else {
      		int total = (int) ((sunday*100)+((sunday*100)*0.5) + (monday*100) + (tuesday*100) + (wednesday*100) + (thursday*100) + (friday*100) + ((saturday*100)+((saturday*100)*0.25)));
      		System.out.println(total);
      		}
      	in.close();

	}

}
