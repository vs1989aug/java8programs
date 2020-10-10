package com.java8.exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotationAnnotationProcessor {
	
	public static void processAnnotations(Object obj)
	{
		Class<?> t=obj.getClass();
		
		for(Method m: t.getDeclaredMethods())
		{
			try
			{
				/*if(m.isAnnotationPresent(TestAnnotation.class)) {
					m.setAccessible(true);
					m.invoke(t);
				}*/
				for(Annotation a: m.getAnnotations())
				{
					if(a.annotationType()==TestAnnotation.class)
					{
						System.out.println("processing the method : "+m.getName()+" of class : "+t.getCanonicalName());
						m.setAccessible(true);
						m.invoke(t);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
