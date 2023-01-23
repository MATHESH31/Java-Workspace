package Practice;

import java.util.*;
import java.util.regex.*;

public class RegexDup {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        List<String> store = new ArrayList<>();
        Pattern p = Pattern.compile("(\\b\\w+\\b)(\\s+\\1\\b)+",Pattern.CASE_INSENSITIVE);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0;i<n;i++){
            String input = in.nextLine();
            store.add(input);
        }
        for(String check : store){
            Matcher m = p.matcher(check);
            while(m.find()){
                check = check.replaceAll(m.group(),m.group(1));
            }
            System.out.println(check);
        }
        in.close();
	}

}


