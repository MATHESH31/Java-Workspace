package Practice;

import java.util.*;

public class RegexToken {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] t = s.split("[\\s@&.!,'_?$+-]+");
        List<String> list = new ArrayList<>(Arrays.asList(t));
        list.remove("");
        System.out.println(list.size());
        for (String blah : list){
            System.out.println(blah);
        }
        in.close();

	}

}
