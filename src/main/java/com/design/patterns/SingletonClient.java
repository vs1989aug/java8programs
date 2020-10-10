package com.design.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonClient {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		/*ClassLoader cl1=ClassLoader.getSystemClassLoader();
		ClassLoader cl2=ClassLoader.getSystemClassLoader();
		try {
			Singleton sl1=(Singleton)cl1.loadClass("com.design.patterns.Singleton").newInstance();
			Singleton sl2=(Singleton)cl2.loadClass("com.design.patterns.Singleton").newInstance();
			System.out.println(sl1+", "+sl2);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}*/
		
		Runnable task=new Runnable() {
			@Override
			public void run()
			{
				System.out.println(Singleton.getInstance("Singleton"));
			}
		};
		
		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int i=0;i<9;i++)
		{
			service.submit(task);
		}
		service.shutdown();
	}

}
