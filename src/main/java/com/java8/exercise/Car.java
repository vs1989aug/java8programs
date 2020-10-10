package com.java8.exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Car implements IVehicle {
	
	public static void main(String[] args) {
		/*Car c=new Car();
		c.move();// Car is having move method default implementation of IVehicle interface by default.
		IVehicle.display(); // Interface can contain static methods.
*/	
		File f=null;
		FileWriter fw=null;
		try {
		f=new File("C:\\Users\\vivsharm7\\Desktop\\c1.txt");
		fw=new FileWriter(f);
		
		if(f.lastModified() < System.currentTimeMillis())
			System.out.println("File is modified earlier.");
		
		fw.write("This file is created using java program.");
		Thread.sleep(200);
		/*if(f.lastModified() < System.currentTimeMillis())
			System.out.println("File is modified earlier.");*/
		System.out.println("File has been created successfully.");
		
		
		
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(InterruptedException i)
		{
			i.printStackTrace();
		}
finally
{
	try {
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	}

}
