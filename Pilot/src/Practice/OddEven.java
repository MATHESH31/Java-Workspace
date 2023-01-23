package Practice;

import java.util.*;

public class OddEven {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
      	int n = in.nextInt();
      	int odd = 0;
      	int even = 0;
      	ArrayList<Integer> array = new ArrayList<Integer>();
      
        do{
            array.add(n % 10);
            n /= 10;
        } while  (n > 0);
      
      	for(int i = 0;i<array.size();i++){
        	if(i%2 == 0){
            	even += array.get(i);
            }
          	else{
            	odd += array.get(i);
            }
        }
      	if(odd == even){
        	System.out.println("yes");
        }
      	else{
        	System.out.println("No");
        }
      	in.close();

	}

}
