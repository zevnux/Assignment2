package cipher2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Playfair {

	public String cipherText = "CYWSXEEFGCODQOESXZEFRTWLHGAOQYGOONHWZLESXZEFUAOBOAYCCOWKFEZRVBHCHAXDNMAHPWBKOYNENRULSHKHVBMARQWCETUAMYEDKDEHOLOPFHGRCSXEEFOKQLHXOSYGRABSSHUALQUGDAZAFENICMXEEFXDNPVBCRRAOSRCOTNOSGKBKRUEVBYMUAACWHEHPWANYMCWKDKAPWODPICBEROCXAVBCHQAYHODDSAOEFNPHXOSYGRAHWNROCSOKYQNXCNOAXCDRKULESXZEFHLNPHCLQBSRQYMPSEUVSVBCOODISEQMHDOPZPLNZYNAODKLTGAOYSDHMWHEOHKPDYMXEEFUALYFHGRHKPWUGNXWGUSSHVBMANLAQYMFECHDOZNCRWPEHEIRHAUULHYENKPDXHWNYLIOHENNPWCNPPZLWPDYHLASXSDBSDEDAAOESLPRIORAQYNCOCSXEEFOCHMQAOKWTYOHXOSYGRABSSHLKNHOANROCOBWLYCCOHSVBYATLQLYOSRANKEYOSHNOODKVEOOYKHEOKHOAWKOAGODLSANPYNHNVSVBYMNHPWHMALKSXEEFKOVBDAEPVBYCEHQYMOGALNHMPGOAGZXLLWLAHSOTSRYKQRDXWPDQSHKOOTOAMHDOHMSBXAKECHEONZAOINEPCSXEEFVBCRXEUAOKQLNPKEAHSTYOUASBOAQRNZYOHXWGYMXEEFOCHMQAOTGOVGOHTEXEEFCYWSXEEFOKQLLKNHOHWCEOHIWLLAOABKIAYOXOSRDGKRUENENRULSHUAQDDAESXZEFOQKERHWTYOHXOSYGRACSXEEFWCARNWPLVBCOAUACXLLKDACKWPVOPRWKUAXUAOOEUASLSDBSAHESOTDLSAPROTOHLQOANWDGSDPKSRVBKHVBCRXEUAEHSQSAGAESXZEFEOOCYGYOKAUHOGHSODSAKHEOAHUGEXAOSDVTKBEDKQDAOSALVBFHCHUFGAEOWEONXLOCWSXEEFOKQLHXOSYGRABSSHAXWHEROCXAEDKQERSDALCTALKSXEEFRCHAGRLRAGOBOACHLANLBVYDETHAWPDYAQHUEYRTSEXEEFKAPWOIYMGAPSCMXEEFHKNYBVKHERCIHACWWSERDOXAZRCSTEAHKVUASQRIHAOQDQSHVBOACROACOEFOLIPLROCXDKMXEHIOEGALWLAHADAULVBCHUHOGSDHKHQRHSYXEEFBAKGEOSQXEUAZRVBHLNPHCSBMOCHTEKENSYOSDBCCOHIXACOXDQHAQHUEYHKNYBVVBYMPROSAOALKZWPETCOUASQRIHASXNOONHDKBYFMLLICOERKCEOEUAOALCWDSZNAMAOKPAZXEKDLAORKVEOOYKHEOKHOAXLLTKHLAVBMAODRASDCSEHQRBCYBQHNEOAMHDOHMSBXAKECOAUHGNENRULSHOCHMQALTOGKOGHOGKOCONIGAMYESXZEFOKQLHXOSYGRACSXEEFZRVBUASHEOWHZRCSERVXNOAXCDRKULESXZEFUASYEHQRBCAMOLOXNIGAHKLWNMNEEYSLSDPKSHESKPGACKWPTERAQAHVNPENULHLOLDNPWPLVBYGNPSXXAZRRFQONPEMPROSAOKGXEEFONWCRCCAHIXACOXDQHAQHUEYZQSHOHPNGVKOLWLAYOOYAMKLORVXBQPDDLDSLWKPEOOUNIGBARHBCHSDCKRIHASXESXZEFOTCOUEWSXEEFYFWCKEMYHVVBCOCHPRMHCOXAVBGRWAALISYOEYUAXYNEWGSDVSVBYOZRULINPLXAVBGHAQYHODDSLWWSXEEFOKCDHIXACOXDQHAQHUEYESXZEFFEDXBSCORQUHOGGWWEFYWCUAMYOTCRDAOSEHHMKDNOXGKHCRWPVENYLICORAESXZEFALSDBYCSXEEFRCAORSXPCOALHDQDONNYEOSBPRWCZGYOSHVBOACRKOALGZWCUFNPCPEOUAEYAHULESKPYGHVNPHXOSYGRACWHXWGYOSHAXWHEOVBRQSBZGYMXEEFETHAWPDYAQHUEYAOHXXPYOHSNUMYLKNHYOSHHCHAWKOAGHDAQRPLAZXEEOAOCYLWKPREOAEHRQSDCWAUHGODSAYOHUSTKHEOWEXEEFUBWPGRGVKOLWHMESXZEFKOOTCHAQAGSXODISEURKMUAREVZGNENRULSHFHUOUFYOFHAHSDVSVBMAONOTXAEIMOGAINEPPWOLDNGZAUHCOYHMQEESIAOAXAVBOADLXESDCSEHQRBCAMOLSGXEEFZRVBHACODAULNPEMAHOTESXZEFLAHSVBCHUHOGHYODKSXEEFRTWGBVAOYVOGOUULEWOHACSLSDCWMHOANOXAVBYOOHVBOHHCWOOGNHVTKENWKPEORQETNRWOSDBSAHESAMOLODKBXAPRXDKPSHEONXDLRASDBSNPAGWEXEEFAULNPNESXZEFOKQLHXOSYGRACWXAPSCMXEEFUASBEOEIOHCWAUACWKUEYOUASXINVBOAYOAZXEPRXLOTDAOSOAXDKPSHEOHLINOTYORSDSSDVSCKDSSHNPGYEXQRFEEHZOQERKDTOGYONPYLSHGSKBETNPEPWLQREPVBUALQAPWLOGKVUASXRCHANPYNULOAPRDTAOKHTEXEEFEOOTDAOSOAYOLHGAPRDTYOARXESDRA";
	public PrintWriter writer;
	public String plainText = "";
	
	String letters = "BDFHILNPQUV";
	
	char remaining[];
	
	// first run trying to use YET for first word did not work,
	// second run attempting YES resulted in interesting text
	char[][] colMain = {{'T','K','W'},{'K','T','W'}};
	//{'W','K','T'},{'K','W','T'}
	
	//deduced first word is YE*, so this is the only pattern that works
	char[][] rowMain = {{'Y','E','G'}};
			
	char[][] key = {{'C','Y','E','G','M'},
					{'T','B','H','P','V'},
					{'K','U','A','N','F'},
					{'W','Q','R','I','Z'},
					{'S','D','O','L','X'}};
	

	
//	{{'B','Z','K','V','D'},
//		{'U','X','S','P','O'},
//		{'G','M','C','Y','E'},
//		{'Q','F','W','L','A'},
//		{'R','I','T','N','H'}};
	
//	   {{'Z','U','G','Y','D'},
//		{'X','S','O','P','R'},
//		{'M','C','E','B','V'},
//		{'F','W','A','L','Q'},
//		{'K','T','I','N','H'}};
	
	public void execute(){
		if(!checkPlayfair(cipherText)){
			System.out.println("Not a playfair, exiting");
			return;	
		}
		
		//remaining = letters.toCharArray();
		// If we get here it must be a playfair
		try {
			writer = new PrintWriter("playfairOutput.txt","UTF-8");
		} catch (FileNotFoundException e) {
			return;
		} catch (UnsupportedEncodingException e) {
			return;
		}
		
		System.out.println("Playfair detected, now deciphering...");
		System.out.println("Running statistcal analysis on digraphs...");
		
		// These two functions are used to find xgraphs.
		//analyzeDigraphs(cipherText);
		//analyzeSixgraphs(cipherText);
		
		// This portion of code will run the key generator, disabled now due to wanting to use manual key
//		int counter = 0;
//		for (int i = 0; i < 5; i++){
//			for (int j = 0; j < 5; j++){
//				// Add these in since we don't have to move C anymore after 2nd run
//				generateKey(0,0);
//				//generateKey(i,j);
//				counter++;
//				System.out.println("Completed key " + counter);
//				
//			}
//		}
		
		// This section simply decodes a given key.
		decode(key,cipherText);
		
//		if (plainText.contains("THE") && plainText.contains("COMXMA")
//				&& plainText.contains("YESCOMMA") && plainText.contains("DEATHEATER")
//				&& plainText.contains("HARXRY") && plainText.contains("VOLDEMORT")){
//			writer.println(plainText);
//			writer.println("\n");
			for (int j = 0; j < key.length; j++){
				writer.println(key[j]);
			}
			writer.println("\n");
			writer.println(plainText);
//		}	
		
		writer.close();
		
		System.out.println("Completed");
		
	}
	
	private void generateKey(int row, int col) {
		// Follow around C
		key[row][col] = 'C';
		// S must always be above C
		key[(row+4)%5][col] = 'S';
		// M must always be behind C
		key[row][(col+4)%5] = 'M';
		
		// Fill in the remaining letters
		fillKnown(row, col);
		
		plainText="";
		permuteKnown(row, col);
			
	}

	private void permuteKnown(int row, int col) {	
		permuteKnownRow(row, col);
			
	
	}
	private void permuteKnownRow(int row, int col) {
		for (int rowCount = 0; rowCount < 1; rowCount++){
			for (int i = 1; i < 4; i++){
				key[row][(col+i)%5] = rowMain[rowCount][i-1];
			}
			permuteKnownCol(row, col);
		}
		
	}

	private void permuteKnownCol(int row, int col) {
		for (int colCount = 0; colCount < 1; colCount++){
			for (int k = 1; k < 4; k++){
				key[(row+k)%5][col] = colMain[colCount][k-1];
			}
			for (int i = 0; i < 10000000; ++i){
				plainText="";
				randomRemaining(row, col);
				decode(key, cipherText);
				
				//System.out.println("Completed decode, writing to file");
				
				//*Note* Found the word DEATHEATER on second run, textfile included for details.
				// Knowing this, adding it to keyword along with other words found.
				if (plainText.contains("COMXMA")
						&& plainText.contains("YESCOMMA") && plainText.contains("VOLDEMORT") ){
					writer.println(plainText);
					//writer.println("\n");
					for (int j = 0; j < key.length; j++){
						writer.println(key[j]);
					}
					writer.println("\n");
				}
				
				if (i % 10000 == 0){
					System.out.println("Finished iterations: " + i);
				}
			}
			System.out.println("Finished some work.");

		}
			
	}
				
	//&& plainText.contains("DEATHEATER")
	//&& plainText.contains("HARXRY") && plainText.contains("VOLDEMORT")


	private void randomRemaining(int row, int col) {
		Random rng = new Random();
		int lengthTracker = letters.length();
		char rl[] = letters.toCharArray();
		for (int i = 0; i < 5; i++){
			if (i == row){
				continue;
			}
			for (int j = 0; j < 5; j++){
				if (j == col){
					continue;
				} else if (key[(i+1)%5][j] == 'E'){
					key[i][j] = 'O';
				} else if (key[(i+1)%5][j] == 'M'){
					key[i][j] = 'X';
				} else if (key[(i+1)%5][j] == 'X'){
					key[i][j] = 'Z';
				} else if (key[(i+1)%5][j] == 'R'){
					key[i][j] = 'A';
				} else if (key[(i+1)%5][j] == 'O'){
					key[i][j] = 'R';
				} else {
					int randomNum = rng.nextInt(lengthTracker);
					key[i][j] = rl[randomNum];
					rl[randomNum] = rl[lengthTracker-1];
					lengthTracker--;
				}
			}
		}
		
	}

	// Initially fill the known values
	private void fillKnown(int row, int col) {
		int colCount = 0;
		int rowCount = 0;
		
		for (int i = 1; i < 4; i++){
			key[row][(col+i)%5] = rowMain[0][rowCount];
			rowCount++;
		}
		for (int i = 1; i < 4; i++){
			key[(row+i)%5][col] = colMain[0][colCount];
			colCount++;
		}
	}

	private void decode(char[][] pfkey, String text) {
		for (int i = 0; i < text.length(); i += 2){
			char a = text.charAt(i);
			char b = text.charAt(i+1);
			
			int row_a = 0;
			int col_a = 0;
			int row_b = 0;
			int col_b = 0;
			
			for (int j = 0; j < pfkey.length; j++){
				char[] row = pfkey[j];
				for (int k = 0; k < row.length; k++){
					if (pfkey[j][k] == a){
						row_a = j;
						col_a = k;
					} else if (pfkey[j][k] == b){
						row_b = j;
						col_b = k;
					}
				}
			}
			
			// If they're in the same row, shift sideways
			if (row_a == row_b){
				col_a = (col_a + 1) % 5;
				col_b = (col_b + 1) % 5;
			// If they're in the same column, shift down
			} else if (col_a == col_b){
				row_a = (row_a + 1) % 5;
				row_b = (row_b + 1) % 5;
			// Otherwise, swap the indexes of the column
			} else{
				int temp_col = col_a;
				col_a = col_b;
				col_b = temp_col;
			}
			
			plainText = plainText + pfkey[row_a][col_a] + pfkey[row_b][col_b];
			
		}
		
	}

	private void analyzeDigraphs(String text) {
		// Pair digraphs into a hashmap
		HashMap<String, Integer> digraphCount = new HashMap<String, Integer>();
		for (int i = 0; i < text.length(); i += 2){
			String digraph = "";
			char first = text.charAt(i);
			char second = text.charAt(i+1);
			digraph = "" + first + second;
			if (digraphCount.containsKey(digraph)){
				digraphCount.put(digraph, digraphCount.get(digraph) + 1);
			} else {
				digraphCount.put(digraph, 1);
			}
		}
		for (String key : digraphCount.keySet()){			
			writer.println(key + "," + digraphCount.get(key));
		}
	}
	
	private void analyzeSixgraphs(String text) {
		HashMap<String, Integer> digraphCount = new HashMap<String, Integer>();
		for (int i = 0; i < text.length(); i += 2){
			String digraph = "";
			try{
				char first = text.charAt(i);
				char second = text.charAt(i+1);
				char third = text.charAt(i+2);
				char fourth = text.charAt(i+3);
				char fifth = text.charAt(i+4);
				char sixth = text.charAt(i+5);
				char seventh = text.charAt(i+6);
				char eigth = text.charAt(i+7);
				digraph = "" + first + second + third + fourth + fifth + sixth + seventh + eigth;
				if (digraphCount.containsKey(digraph)){
					digraphCount.put(digraph, digraphCount.get(digraph) + 1);
				} else {
					digraphCount.put(digraph, 1);
				}
			} catch (Exception e ){
				break;
			}
		}
		for (String key : digraphCount.keySet()){			
			writer.println(key + "," + digraphCount.get(key));
		}
	}

	private boolean checkPlayfair (String text){
		// First determine if the cipher is a playfair by checking the digraphs
		for (int i = 0; i < text.length(); i += 2){
			char first = text.charAt(i);
			char second = text.charAt(i+1);
			if (first == second){
				System.out.println("Found a duplicated digraph: " + first + second + " at index " + i);
				return false;
			}
		}
		
		return true;
	}
	
}
