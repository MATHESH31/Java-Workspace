package Practice;

import java.math.BigInteger;
import java.util.*;

public class BigNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String n = in.nextLine();
		BigInteger bi = new BigInteger(n);
		System.out.println(bi);	
		
		in.close();
	}

}
