package Practice;

import java.util.*;

public class datatypes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        in.nextLine();
        List<String> number = new ArrayList<>();
        for (int i=0;i<a;i++){
            String input = in.nextLine();
            number.add(input);
        }
        for(String num : number){
        	try {
            if(Long.parseLong(num)>=(-128) && Long.parseLong(num)<=127){
            	System.out.println(num+" can be fitted in:");
                System.out.println("* byte");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }
            else if(Long.parseLong(num)>=(-32768) && Long.parseLong(num)<=32767){
            	System.out.println(num+" can be fitted in:");
                System.out.println("* short");
                System.out.println("* int");
                System.out.println("* long");
            }
            else if(Long.parseLong(num)>=(-2147483648) && Long.parseLong(num)<=2147483647){
            	System.out.println(num+" can be fitted in:");
                System.out.println("* int");
                System.out.println("* long");
            }
            else if(Long.parseLong(num)>=(-9223372036854775808L) && Long.parseLong(num)<=9223372036854775807L){
            	System.out.println(num+" can be fitted in:");
                System.out.println("* long");
            }
        	}
        	catch(Exception e) {
        		System.out.println(num+" can't be fitted anywhere.");
        		
        	}
        }
        in.close();

	}

}
