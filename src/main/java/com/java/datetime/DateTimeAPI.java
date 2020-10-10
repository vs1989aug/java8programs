package com.java.datetime;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class DateTimeAPI {

		public boolean testDateTime(String date) {
			/*long totalZones = ZoneId.getAvailableZoneIds().stream().count();
			long count = ZoneId.getAvailableZoneIds().stream()
					.filter(zoneId->LocalDate.now(ZoneId.of(zoneId)).isAfter(LocalDate.now())).count();
			System.out.println("Total zones which are ahead of current date : "+count);
			System.out.println("Total count of zones: "+totalZones);*/
			
			/*ZoneId.getAvailableZoneIds().forEach(zoneId->{
				LocalDate date = LocalDate.now(ZoneId.of(zoneId));
				if(date.isAfter(LocalDate.now())) {
					System.out.println("Current date of zone : "+zoneId+" is ahead of Asia date with date as: "+date);
				}
				else {
					
				}
				//System.out.println("Zone ID : "+zoneId+ ", Local date: "+date);
			});*/

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd")
					.withLocale(Locale.getDefault()).withResolverStyle(ResolverStyle.SMART);
			formatter.parse(date);
			return true;

		}
}
