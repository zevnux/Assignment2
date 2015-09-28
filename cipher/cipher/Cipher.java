package cipher;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cipher {
	
	List<String> alphabet = new ArrayList<String>();
	String cipherText = "PAMQTPABGRPRMVCBHHQRPRVPGTMCBHHQWRKKMGEAMPAMGPARVDQVPUTMVPRBXEQVQHM"
			+ "GMUTMVPRBXQXWXBPQGRWWDMQCCBGWRXZPBPAMVPGRCPGTDMVBKPAMZQHMFTPQDDQZGMMPAQPCBHHQQKPMGQCCMIP"
			+ "RXZRPQXWPGLRXZPBZTMVVPAMQXVEMGCBHHQZBDDTHEQVFBTXWFLARVIGBHRVMWBPQXWFRDFBIGMVVMWARHPBYM"
			+ "MIARVEBGWKBGPAMPABTZAPCQHMPBARHPAQPPARVVDRHLCGMQPTGMHRZAPIGBSMKQDVMCBHHQMSMXPABTZAVTCA"
			+ "IGBHRVMVEMGMAMDWVQCGMWCBHHQQXWBKBDWQDDFTPPAMERCYMWMVPPARXZVKMQGMWPBFGMQYPAMHWBPFTPQKPMGQ"
			+ "ZMVQDBXMRXPAMWQGYZBDDTHVAMQGPEQVFDQCYCBHHQQXWPGMQCAMGLEQVRXRP";
	String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	PrintWriter writer;
	
	String freq = "ETAOSRIHMDCNLUGFBWPKYQV";
	String curr = "MPQBVGRAHWCXDTZKFEIYLUS";
	
	HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
	HashMap<Character, Character> keyMap = new HashMap<Character, Character>();
	
	String plainText = "";
	
	public void execute(){
		
		System.out.println("Starting statstical analysis...");
		
		

		try {
			writer = new PrintWriter("decipher.txt","UTF-8");
		} catch (FileNotFoundException e) {
			return;
		} catch (UnsupportedEncodingException e) {
			return;
		}
		
		// Get letters into string array
		
		for (char c : letters.toCharArray()){
			alphabet.add(String.valueOf(c));
		}
		
		for (int i = 0; i < freq.length(); ++i){
			keyMap.put(curr.charAt(i), freq.charAt(i));
		}
		
		for (int i = 0; i < cipherText.length(); ++i){
			char c = keyMap.get(cipherText.charAt(i));
			plainText += c;
		}
		
		writer.println(plainText);
		
//		for (int i = 0; i < cipherText.length(); i++){
//			char c = cipherText.charAt(i);
//			if (!letterCount.containsKey(c)){
//				letterCount.put(c, 1);
//			} else {
//				letterCount.put(c, letterCount.get(c) + 1);
//			}
//		}
//		
//		for (Character key : letterCount.keySet()){
//			writer.println(key + "," + letterCount.get(key));
//		}
		
		System.out.println("Completed.");
		
		writer.close();
		
		return;
		
	}
}
	