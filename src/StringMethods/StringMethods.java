package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			s = s.replace(" ", "_");
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String t1 = s1.trim();
		String t2 = s2.trim();
		String t3 = s3.trim();
		if (t1.charAt(t1.indexOf(" ") + 1) > t2.charAt(t2.indexOf(" ") + 1)) {
			if (t2.charAt(t2.indexOf(" ") + 1) < t3.charAt(t3.indexOf(" ") + 1)) {
				return t2;
			} else if (t1.charAt(t1.indexOf(" ") + 1) > t3.charAt(t3.indexOf(" ") + 1)) {
				return t3;
			} else {
				return t1;
			}
		} else if (t2.charAt(t2.indexOf(" ") + 1) > t3.charAt(t3.indexOf(" ") + 1)) {
			if (t1.charAt(t1.indexOf(" ") + 1) > t3.charAt(t3.indexOf(" ") + 1)) {
				return t3;
			} else {
				return t1;
			}
		} else {
			return t2;
		}

	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int temp = Integer.parseInt(String.valueOf(s.charAt(i)));
				sum += temp;
			}
		}
		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int sum = 0;
		int index = 0;
		while (s.indexOf(substring, index)>=0) {
			sum++;
			index = s.indexOf(substring, index);
			index++;
		}
		return sum;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		
		
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte) key);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int sum = 0;
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].endsWith(substring)) {
				sum++;
			}
		}
		return sum;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		String dis = s.substring(s.indexOf(substring)+substring.length(),s.lastIndexOf(substring));
		
		return dis.length();
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String t = s.trim();
		s=s.trim();
		for (int i = 0; i < t.length(); i++) {
			if (!Character.isAlphabetic(t.charAt(i))) {
				s=s.replace((Character.toString(t.charAt(i))), "");
			}
		}
		
		t=s;
		s="";
		for (int i = t.length()-1; i >= 0; i--) {
			s+=t.charAt(i);
		}
		if (s.equalsIgnoreCase(t)) {
			return true;
		}else {
			return false;
		}
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
