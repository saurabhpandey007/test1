package com.roomautomation.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DotNetClient {
	static List<String> lstn;
	
	public static void getDotNet() throws Exception
	{
		System.out.println("in .net clnt");
		lstn=new ArrayList<String>();
		  try {

			//URL url = new URL("http://localhost:50053/api/temperatureapi/Get");
			  URL url = new URL("http://localhost:58876/Service1.svc/Temperature");
			  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			  System.out.println("before method"+new Date().getTime());
			//conn.setRequestMethod("GET");
			  conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			System.out.println(conn.getResponseCode());
			String output;
			System.out.println("after method"+ new Date().getTime());
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			List<String> oplist=DataProvider.getParseData("Temperature_freq", "date", "Temperature",output);
			System.out.println("inop"+oplist.get(0));	
			Double value = Double.parseDouble(oplist.get(0));
			System.out.println(value.getClass().getName());
			System.out.println(value);
			System.out.println("inop"+oplist.get(1));	
			
			String ss=oplist.get(1);
			
			System.out.println("iiiii"+ss);
			
			String[] parts = ss.split("\\+");	
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = format.parse(parts[0]);
			System.out.println(date);

			
			
			
			
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		
	}
}
