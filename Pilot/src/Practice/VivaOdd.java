package Practice;

import java.util.*;

public class VivaOdd {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int n = in.nextInt();
      	boolean flag = true;
      	float point = 0;
      	
      	while(flag){
          	if(n>0 && n%2!=0){
            	point += 1;
            }
          	else if(n>=0 && n%2==0){
            	point -= 0.5;
            }
          	else if(n<0){
            	point -= 1;
              	flag = false;
            }
          	if(flag == true) {
	        	int temp = in.nextInt();
	          	n = temp;
          	}
          	else {
          		break;
          	}
        }
      	System.out.println(point);
      	in.close();
	}

}
