package com.sparkapi;

import static spark.Spark.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.json.Json;  
public class SparkApi   
{  
    public static void main(String[] args)   
{  
    	ipAddress("192.xxx.xx.xxx");
    	port(32925);  //what ever port that we want
        get("/hello", (req, response) -> {
        	response.header("Access-Control-Allow-Headers",
    				"origin, content-type, accept, x-requested-with, my-cool-header");
    		response.header("Access-Control-Max-Age", "60");
    		response.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
    		response.header("Access-Control-Allow-Origin", "*");
    		response.type("application/json");
    		
    		JSONArray ary=new JSONArray();
    		ary.put("gaja");
    		ary.put("pala");
    		ary.put("ravi");
        	return ary;
        });  
        
       

        get("/hello/:name", (request, response) -> {  
        	response.type("application/json");
            return "Hello: " + request.params(":name");  
        });  
    }  
}  


//after running main call in chrome this is get method http://localhost:4567/hello  