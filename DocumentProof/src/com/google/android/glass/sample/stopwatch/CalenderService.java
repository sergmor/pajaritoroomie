package com.google.android.glass.sample.stopwatch;

import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;


public class CalenderService {
	public static void putEvent(String picturePath, String email,long timestamp){
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType("vnd.android.cursor.item/event");
		
		//intent.setData(CalendarContract.Events.CONTENT_URI);
		
		intent.putExtra(Events.TITLE,"Work done by "+email);
		intent.putExtra(Events.EVENT_LOCATION,"Home");
		intent.putExtra(Events.DESCRIPTION,"Photo is named "+picturePath);
			
	}
}
