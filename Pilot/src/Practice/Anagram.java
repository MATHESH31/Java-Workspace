package Practice;

import java.util.*;

public class Anagram {
	static boolean isAnagram(String a, String b) {
		List<Character>A = new ArrayList<>();
        List<Character>B = new ArrayList<>();
        for(char c : a.toCharArray()) {
        	A.add(Character.toLowerCase(c));
        }
        for(char d : b.toCharArray()) {
        	B.add(Character.toLowerCase(d));
        }
        Collections.sort(A);
        Collections.sort(B);
        Boolean s = A.equals(B);
        return s;
        
    }

	public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
