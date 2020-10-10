package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Test {

	static String testString = "My String is for 1234.";

	public static void main(String[] args) {
		/*
		 * Parent parent = new Parent(); parent.display();
		 */

		try {
			String fileName = "target\\EncodedFile.txt";
			System.out.println("String to be encoded: " + testString);

			byte[] encodedData = getEncodedData(testString);

			System.out.println("Encoded string: " + new String(encodedData));

			writeContentToFile(encodedData, fileName);

			String data = readFileContent(fileName);

			byte[] decodedData = getDecodedData(data);

			System.out.println("Decoded data: " + new String(decodedData));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeContentToFile(byte[] encodedData, String fileName) throws IOException {
		System.out.println("Writing encoded data into file: "+fileName);
		FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
		fileOutputStream.write(encodedData);
		System.out.println("Write operation of encoded data in file is completed.");
		fileOutputStream.close();
		
	}

	private static String readFileContent(String fileName) throws IOException {
		System.out.println("Reading data from file: "+fileName);
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		StringBuilder data = new StringBuilder("");
		int read = fileInputStream.read();
		while (read != -1) {
			data.append((char) read);
			read = fileInputStream.read();
		}
		System.out.println("Read operation is done from encoded file.");
		fileInputStream.close();
		return data.toString();
	}

	private static byte[] getDecodedData(String data) {
		return Base64.getDecoder().decode(data.toString().getBytes());
	}

	private static byte[] getEncodedData(String teString) {
		return Base64.getEncoder().encode(teString.getBytes());
	}

}
