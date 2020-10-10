package com.java.datetime;

import org.junit.Before;
import org.junit.Test;

public class DateTimeAPITest {
	
	DateTimeAPI dateTimeApi;
	
	@Before
	public void setup() {
		dateTimeApi = new DateTimeAPI();
	}
	
	
	@Test
	public void testDateTime() {
		dateTimeApi.testDateTime("2222-50-01");
	}

}
