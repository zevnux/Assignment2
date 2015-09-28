package collision;

import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Collision {

	
	public Checksum cs1 = new CRC32();
	public Checksum cs2 = new CRC32();
	public Random rng = new Random();

	public void execute() {
		
		String input1 = "6F35BFFEBFC9DBEF891DB56E786A34D2";
		Long input2 = rng.nextLong();
		long value1 = 1;
		long value2 = 0;
		byte b1[] = input1.getBytes();
		cs1.update(b1, 0, b1.length);
		value1 = cs1.getValue();
		long counter = 0;
		
		while (value1 != value2){
			input2 = rng.nextLong();
			byte b2[] = input2.toString().getBytes();		
			cs2.update(b2, 0, b2.length);
			value2 = cs2.getValue();
			counter ++;
			if (counter % 100000000 == 0){
				System.out.println("Completed " + counter + " iterations...");
				System.out.println("Value 1 is: " + Long.toHexString(value1) + ". Value 2 is " + Long.toHexString(value2));
				System.out.println("String 1 is: " + input1 + ". String 2 is " + input2);
			}
			cs2.reset();
		}
		
			
		System.out.println("Value 1 is: " + Long.toHexString(value1) + ". Value 2 is " + Long.toHexString(value2));
		System.out.println("String 1 is: " + input1 + ". String 2 is " + input2);
	}	
}