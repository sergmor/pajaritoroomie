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

import java.io.File;

import com.google.android.glass.media.CameraManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
//Simport android.os.Handler.Callback;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;


/**
 * Activity showing the options menu.
 */
public class MenuActivity extends Activity {
	private static int TAKE_PICTURE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stopwatch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        switch (item.getItemId()) {
            case R.id.stop:
            	takePicture();
                //stopService(new Intent(this, StopwatchService.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Log.d("length","length");
        startActivityForResult(intent, TAKE_PICTURE_REQUEST);
        
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	Log.d("length22","length22");
        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
            final String picturePath = data.getStringExtra(
                    CameraManager.EXTRA_PICTURE_FILE_PATH);
            try {
				processPictureWhenReady(picturePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    
    
    private void processPictureWhenReady( final String picturePath) throws IOException {
    	final File pictureFile = new File(picturePath);
    	Log.d("picture path",picturePath);
        long len = pictureFile.length();
        Log.d("length",Long.toString(len));

        if (pictureFile.exists()) {
            // The picture is ready; process it.
        	Log.d("TEMP", "namaste");
        	
        	String email = fetchAccountMailId();
        	byte[] fileBytes = readFile(pictureFile);
        	
        	String encodedImage = Base64.encodeToString(fileBytes, Base64.DEFAULT);
        	long timestamp = getTimestamp();
        	CalenderService.putEvent(picturePath,email,timestamp);
        	//sendPostR(email,pictureFile,timestamp);
        	//JSONObject jsonobj = convertToJSON(email,encodedImage,timestamp);
        	//sendPost(jsonobj);
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	StrictMode.setThreadPolicy(policy);
    /*    	HttpClient httpclient = new DefaultHttpClient();
        	HttpPost post = new HttpPost("http://160.39.212.162:9000/request/new");
            InputStream is = new FileInputStream(pictureFile);
            byte[] bytearray = IOUtils.toByteArray(is);
            String encodeImaging= Base64.encodeToString(bytearray, Base64.DEFAULT);
        	//String temp = Hex.encodeHexString(IOUtils.toByteArray(is));
        	try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("registrationid",
                        "123456789"));
                nameValuePairs.add(new BasicNameValuePair("email",email));
                nameValuePairs.add(new BasicNameValuePair("timestamp",String.valueOf(timestamp)));
                nameValuePairs.add(new BasicNameValuePair("filetext",encodeImaging));	
                nameValuePairs.add(new BasicNameValuePair("email",email));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
           
                HttpResponse response = httpclient.execute(post);
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                  System.out.println(line);
                  Log.d("line",line);
                }

              } catch (IOException e) {
                e.printStackTrace();
              }
  */      	
        	Gson gson = new Gson();
  
        		RestAdapter restadapter = new RestAdapter.Builder()
				.setEndpoint("http://160.39.212.162:9000")
				.setConverter(new GsonConverter(gson))
				.build();    
        	
        	GitHubService service = restadapter.create(GitHubService.class);
        	TypedFile typedfile = new TypedFile("application/octet-stream",pictureFile);
        	service.addPhoto(typedfile, new Callback<File>(){
        		
        		@Override
        		public void failure(RetrofitError retrofitError){
        			Log.e("YES",retrofitError.getMessage());
        		}
				@Override
				public void success(File arg0, Response arg1) {
					// TODO Auto-generated method stub
					
				}
        	});//, email, timestamp);
        	StopwatchService.updateCard(this, "Picture was taken.",email);
        	
        } else {
            // The file does not exist yet. Before starting the file observer, you
            // can update your UI to let the user know that the application is
            // waiting for the picture (for example, by displaying the thumbnail
            // image and a progress indicator).

            final File parentDirectory = pictureFile.getParentFile();
            FileObserver observer = new FileObserver(parentDirectory.getPath()) {
                // Protect against additional pending events after CLOSE_WRITE is
                // handled.
                private boolean isFileWritten;

                @Override
                public void onEvent(int event, String path) {
                    if (!isFileWritten) {
                        // For safety, make sure that the file that was created in
                        // the directory is actually the one that we're expecting.
                        File affectedFile = new File(parentDirectory, path);
                       isFileWritten = (event == FileObserver.CLOSE_WRITE
                                && affectedFile.equals(pictureFile));

                        if (isFileWritten) {
                            stopWatching();

                            // Now that the file is ready, recursively call
                            // processPictureWhenReady again (on the UI thread).
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   try {
									processPictureWhenReady(picturePath);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                                }
                            });
                        }
                    }
                }
            };
            observer.startWatching();
        }
    }
    
    public static byte[] readFile(File file) throws IOException {
        // Open file
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
            // Get and check length
            long longlength = f.length();
            int length = (int) longlength;
            if (length != longlength)
                throw new IOException("File size >= 2 GB");
            // Read file and return data
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }
    
    public long getTimestamp(){
    	return System.currentTimeMillis()/1000L;	
    }
    
    public JSONObject convertToJSON(String email,String fileBytes,long timestamp){
    	JSONObject obj = new JSONObject();
    	obj.put("email", email);
    	obj.put("file",fileBytes);
    	obj.put("timestamp", timestamp);
    	return obj;
    }

    public String fetchAccountMailId() {

    	String accountEmailId=null;
    	AccountManager manager = (AccountManager) getSystemService("account");
    	Account[] list = manager.getAccounts();

    	String alternateId = null;
    	for (Account acct : list) {
    	if (acct.type.equalsIgnoreCase("com.google")) {
    	accountEmailId = acct.name;
    	}
    	else {
    	alternateId = acct.name;
    	}
    	}

    	if (accountEmailId == null) {
    	accountEmailId = alternateId;
    	}
    	return accountEmailId;
    	//System.out.println(accountEmailId);
    	}
    public void sendPost(JSONObject jsonobj) throws IOException{
    	
    	String url ="http://160.39.212.162:9000/request/new"; // URL Search 
    	URL obj = new URL(url);
    	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    	
    	//HttpPost post = new HttpPost();
		con.setDoOutput(true);
    	//add request header
    	con.setRequestMethod("POST");
    	//con.setRequestProperty("User-Agent", "Mozilla/5.0");
    	//con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    	con.setRequestProperty("Content-Type","application/json");
    	//con.setRequestProperty("Accept-Language", "application/json");
    	//post.setURI(new URI("http://160.39.207.108:9000/request/new"));
    	//post.setHeader("User-Agent", "Mozilla/5.0");
    	//post.setHeader("Content-type", "application/json"); //text/json
    	
    	HttpResponse response = null;
    	// Quick fix 
    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    	StrictMode.setThreadPolicy(policy); 
    	
    	//add request body
    	OutputStream os = con.getOutputStream();
    	os.write(jsonobj.toString().getBytes());
    	os.flush();
    	//OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
    	//wr.write(jsonobj.toString().getBytes());
    	//wr.flush();
    	//StringEntity sEntity = new StringEntity(jsonobj.toString(), "UTF-8");
    	//post.setEntity(sEntity);
    	//Log.d("newmethod", "JSon String to send as body in this request ==>> ");
    	
    	//response= httpClient.execute(post);
    	
    	StringBuilder sb = new StringBuilder();
    	int HttpResult = con.getResponseCode();
    	
    	if(HttpResult==HttpURLConnection.HTTP_OK){
    		BufferedReader br  = new BufferedReader(new InputStreamReader(con.getInputStream()));
    	
    		String line = null;
    		while((line=br.readLine())!=null){
    			sb.append(line+"\n");
    		}		
    		br.close();
    		Log.d("Good",sb.toString());
    	}
    	else{
    		Log.d("Bad",con.getResponseMessage());
    	}
    }
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        // Nothing else to do, closing the Activity.
    	//super.onOptionsMenuClosed(menu);
        //finish();
    }
    public void sendPostR(String email, File file, long time) throws IOException{
              Log.d("Name",file.getAbsolutePath());
              // open a URL connection to the Servlet
            FileInputStream fileInputStream = new FileInputStream(file);
            URL url = new URL("http://160.39.212.162:9000/request/new");
            String twoHyphens = "--";
            String boundary = "*****";
            String lineEnd = "\r\n";
            // Open a HTTP  connection to  the URL
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true); // Allow Inputs
            conn.setDoOutput(true); // Allow Outputs
            conn.setUseCaches(false); // Don't use a Cached Copy
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            conn.setRequestProperty("uploaded_file", "pranav");
            
            // Quick fix like last time.
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy); 
            
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

            dos.writeBytes(twoHyphens + boundary + lineEnd);
            //dos.writeBytes(email+" "+boundary);
            dos.writeBytes("Content-Disposition: form-data; name=file; filename="+ file.getName()+lineEnd);
            dos.writeBytes("Content-Transfer-Encoding: binary"+lineEnd); 
            dos.writeBytes(lineEnd);

            
            // create a buffer of  maximum size
            int bytesAvailable = fileInputStream.available();
            int maxBufferSize = 1024*1024*1024;   
            int  bufferSize = Math.min(bytesAvailable, maxBufferSize);
            byte[] buffer = new byte[bufferSize];
   
            // read file and write it into form...
            int bytesRead = fileInputStream.read(buffer, 0, bufferSize); 
           
            while (bytesRead > 0) {
                 
              dos.write(buffer, 0, bufferSize);
              bytesAvailable = fileInputStream.available();
              bufferSize = Math.min(bytesAvailable, maxBufferSize);
              bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
               
             }
   
            // send multipart form data necesssary after file data...
           dos.writeBytes(lineEnd);
           //dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
   
            // Responses from the server (code and message)
            int serverResponseCode = conn.getResponseCode();
            String serverResponseMessage = conn.getResponseMessage();
              
            Log.i("uploadFile", "HTTP Response is : "
                    + serverResponseMessage + ": " + serverResponseCode);
             
            if(serverResponseCode == 200){
                 Log.d("Good","Good");
                //runOnUiThread(new Runnable() {
                  //   public void run() {
                          
                   //      String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
                             //          +" http://www.androidexample.com/media/uploads/"
                               //        +"pranav";
                          
                     //    Textview messageText.setText(msg);
                       //  Toast.makeText(UploadToServer.this, "File Upload Complete.",
                         //             Toast.LENGTH_SHORT).show();
                     }
            else{
            	Log.d("Bad",String.valueOf(serverResponseCode));
            }
                                
              
             
            //close the streams //
            fileInputStream.close();
            dos.flush();
            dos.close();
              
       //dialog.dismiss();      

 
    }
    
    public interface GitHubService {
    	 @Multipart 
    	 @POST("/request/new")
    	 //void addPhoto (@Part("file") TypedFile photo, @Part("email") TypedString email, @Part("timestamp") TypedString timestamp);
    	 void addPhoto (@Part("file") TypedFile photo, Callback<File> callback);
    	}
    
}
