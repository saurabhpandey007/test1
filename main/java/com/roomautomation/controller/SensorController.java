package com.roomautomation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.roomautomation.pojo.User;
import com.roomautomation.provider.DotNetClient;

@RestController
@CrossOrigin
@RequestMapping("/charts")
public class SensorController {

	Cluster cluster;
	Session session;
	@RequestMapping(value = "/sensordetail", method = RequestMethod.GET /*produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json"*/)
	public List<List<Object>>sensorDetailList () throws Exception {
				
		List<List<Object>> lst=new ArrayList<List<Object>>();
		List<Object> lst1=new ArrayList<Object>();
				
		cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect("roomautomation");
		
		
		lst1.add("Time");
		lst1.add("Lux");
		lst1.add("humidity");
		lst1.add("pressure");
		lst1.add("temprature");
		lst.add(lst1);
		ResultSet results = session.execute("SELECT * FROM frequencydetail LIMIT 6");
		
		
		for (Row row : results) {
			lst1=new ArrayList<Object>();
			double tmpf = row.getDouble("temp_freq");
			double prsf = row.getDouble("pressure_freq");
			double luxf = row.getDouble("lux_freq");
			double humif = row.getDouble("humidity_freq");
			Date tm = row.getTimestamp("time");
			
			lst1.add(tm.getTime());
			lst1.add(luxf);
			lst1.add(humif);
			lst1.add(prsf);
			lst1.add(tmpf);
			lst.add(lst1);
		}								
		
		
		DotNetClient.getDotNet();
		return lst;
	}
	
	@RequestMapping(value = "/apidetail", method = RequestMethod.GET /*, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json"*/)
	public List<List<Object>> apiDetailList() throws ParseException {
		
	List<Object> lst2=null;
	List<Object> lst3=null;
	List<Object> lst4=null;
	List<Object> lst5=null;
	List<Object> lst6=null;
	List<List<Object>> lst=new ArrayList<List<Object>>();
	List<Object> lst1=new ArrayList<Object>();
			
	cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	session = cluster.connect("roomautomation");
	
	
	lst1.add("Time");
	lst1.add("Lux");
	lst1.add("humidity");
	lst1.add("pressure");
	lst1.add("temprature");
	lst.add(lst1);
	ResultSet results = session.execute("SELECT * FROM apidetails");
	
	
	for (Row row : results) {

		lst1=new ArrayList<Object>();
		int rescode = row.getInt("response_code");
		String apiName = row.getString("api_name");
		Date tm = row.getTimestamp("restime");
			
			
		lst1.add(tm);
		if(apiName.equalsIgnoreCase("lux"))
			{
		
				lst2=new ArrayList<Object>();
				lst2.add(rescode);
			}
			
		
		if(apiName.equalsIgnoreCase("humidity"))
		{
		
			lst3=new ArrayList<Object>();
			lst3.add(rescode);
		}
		
		
		if(apiName.equalsIgnoreCase("pressure"))
		{
			
			lst4=new ArrayList<Object>();
			lst4.add(rescode);
		}
		
		
		if(apiName.equalsIgnoreCase("temperature"))
		{
			
			lst5=new ArrayList<Object>();
			lst5.add(rescode);
		}
		
		if(lst2!=null && lst3!=null && lst4!=null && lst5!=null)
		{
			lst6=new ArrayList<Object>();
			lst6.add(lst1.get(0));
			lst6.add(lst2.get(0));
			lst6.add(lst3.get(0));
			lst6.add(lst4.get(0));
			lst6.add(lst5.get(0));
			lst.add(lst6);
			lst2=null;
			lst3=null;
			lst4=null;
			lst5=null;
			
			
		}
	
		
	}								
	
	
	
	return lst;
}


	@RequestMapping(value = "/responsecode", method = RequestMethod.GET  /*, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json"*/)
	public List<Object> showAllUsers() throws ParseException {
		System.out.println("in ctrl show users ");

		//java.util.List<User> result = userService.showAllUsers();
		//String json = new Gson().toJson(result);
		return null;
	}
	
}
