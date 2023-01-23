package Practice;

import java.util.*;
import java.util.regex.*;

public class IpFinder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        List<String> store = new ArrayList<>();
        String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
        String regex= zeroTo255 + "\\."+ zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        Pattern p = Pattern.compile(regex);
        while(in.hasNextLine()){
            String ip = in.nextLine();
            store.add(ip);
        }
        for(String check : store){
            Matcher m = p.matcher(check);
            boolean result = m.matches();
            System.out.println(result);
        }
        in.close();

	}

}
