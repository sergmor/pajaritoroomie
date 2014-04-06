/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.glass.sample.stopwatch;

import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.LiveCard.PublishMode;
import com.google.android.glass.timeline.TimelineManager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Service owning the LiveCard living in the timeline.
 */
public class StopwatchService extends Service {

    private static final String TAG = "StopwatchService";
    private static final String LIVE_CARD_TAG = "stopwatch";

   

    private TimelineManager mTimelineManager;
    private static LiveCard mLiveCard;

    @Override
    public void onCreate() {
        super.onCreate();
        mTimelineManager = TimelineManager.from(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mLiveCard == null) {
            Log.d(TAG, "Publishing LiveCard");
            mLiveCard = mTimelineManager.createLiveCard(LIVE_CARD_TAG);

            // Keep track of the callback to remove it before unpublishing.
            RemoteViews remoteviews=new RemoteViews(this.getPackageName(), R.layout.livecard);//left to check
   		 	mLiveCard.setViews(remoteviews);

    		Intent menuintent = new Intent(this, MenuActivity.class);
    		mLiveCard.setAction(PendingIntent.getActivity(this, 0, menuintent, 0));

            mLiveCard.publish(PublishMode.REVEAL);
            Log.d(TAG, "Done publishing LiveCard");
        } else {
            // TODO(alainv): Jump to the LiveCard when API is available.
        }

        return START_STICKY;
    }
    static void updateCard(Context context, String string,String email){
    	Log.d(TAG,"updateCard() called.");
    	if(mLiveCard==null){
    		Log.d("YES", "LIVE CARD EMPTY!");
    		Log.d("NO",email);
    	}
    	else{
    		RemoteViews remoteviews = new RemoteViews(context.getPackageName(),R.layout.livecard);
    		remoteviews.setCharSequence(R.id.livecard_content, "setText", string);
    		mLiveCard.setViews(remoteviews);
    		
    		Intent intent = new Intent(context, MenuActivity.class);
    		mLiveCard.setAction(PendingIntent.getActivity(context, 0, intent, 0));
    		
    		if(! mLiveCard.isPublished()){
    			mLiveCard.publish(LiveCard.PublishMode.REVEAL);
    		}
    		else{
    			Log.d(TAG,"liveCard not published");
    		}
    	}
    }
    @Override
    public void onDestroy() {
        if (mLiveCard != null && mLiveCard.isPublished()) {
            Log.d(TAG, "Unpublishing LiveCard");
            mLiveCard.unpublish();
            mLiveCard = null;
        }
        super.onDestroy();
    }
    
    
}
