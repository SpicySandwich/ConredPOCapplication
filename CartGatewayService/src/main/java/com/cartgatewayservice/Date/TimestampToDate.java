package com.cartgatewayservice.Date;

import java.util.Date;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;

public class TimestampToDate {
	
 static final long MILLIS_PER_SECOND = 1000 ;
	 
	 public  static Date timestampToDate (Timestamp timestamp)  {
         return  new Date(timestamp.getSeconds() * MILLIS_PER_SECOND);
    }
	 
	 public  static Timestamp dateTotimestamp (Date date)  {
         return Timestamps.fromMillis(date.getTime());
    }

}
