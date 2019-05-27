package com.scrapPlant.functions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String args[]) throws Exception {
		/*DateFormat df = new SimpleDateFormat("MM_dd_yy HH_mm_ss"); 
		test dateobj = new test(); 
		String dt=df.format(dateobj);
		System.out.println(dt);*/
//		Object d = getMappedObjectValue(reportBeamDataMap, ReportBeamConstant.DAT_STOPDATE);
//		Date stopDate1 = (Date)d;
	/*	Timestamp ts=new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
		SimpleDateFormat dateformate = new SimpleDateFormat("ddmmyyyy_hh:mm");
		String timeString = df.format(ts);
		String dateString = dateformate.format(ts);
		System.out.println("Time is : "+timeString);
	     // Timestamp time=new Timestamp(df.parse(timeString).getDate());  
         // Date date=ts;  
          System.out.println(dateString); */
         
		String s="Rs. 7,37,949";
		s=s.replaceAll("\\W", "");
		String s1=s.replaceAll("\\D","");
		System.out.println("String value is : "+s1);
	}
}
