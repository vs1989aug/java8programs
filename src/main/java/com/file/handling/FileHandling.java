package com.file.handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FileHandling {

	public static void main(String[] args) {

		/*String fileToBeRead = "C:\\test\\welcome.txt";
		String fileToBeWritten = "C:\\test\\write_test.txt";

		//String data = readDatafromFile.apply(fileToBeRead);

		//System.out.println("Enter data to write to file. Enter \"STOP\" to stop.");

		//File data copy from file fileToBeRead to file fileToBeWritten
		//writeDataToFile.accept(fileToBeWritten, readDatafromFile.apply(fileToBeRead));
		
		copyDataFromFile.accept(fileToBeRead, fileToBeWritten);
		System.out.println("data copied");
		
		readDatafromFile.apply(fileToBeWritten);*/
		
		String data = readDataFromUser.get();
		System.out.println("User input : "+ data);
		
 	}

	private static Supplier<String> readDataFromUser =
		() -> {
			System.out.println("Reading data from user input.. press stop for stopping input reading from user.");
			Scanner sc = null;
			StringBuilder data = new StringBuilder("");
			while (true) {
				sc = new Scanner(System.in);
				String next = sc.nextLine();
				if (next.equalsIgnoreCase("STOP")) {
					break;
				}
				data.append(next).append(" ");
			}
			sc.close();
			return data.toString();
		};


	private static BiConsumer<String, String> writeDataToFile = (writeFile, data) -> {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	};

	private static Function<String,String> readDatafromFile = (fileName) -> {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			StringBuilder data = new StringBuilder();
			Iterator<String> iterator = br.lines().iterator();
			while(iterator.hasNext()) {
				data.append(iterator.next());
			}
			return data.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	};

	public static BiConsumer<String, String> copyDataFromFile = (sourceFile,destFile)->{
		writeDataToFile.accept(destFile, readDatafromFile.apply(sourceFile));
	};
}
