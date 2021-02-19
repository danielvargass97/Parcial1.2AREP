package edu.escuelaing.arep;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Facade {
	
	public static JSONObject getValue(String number, String operation) throws UnirestException {
        HttpResponse<String> answer = Unirest.get("https://fast-bastion-77299.herokuapp.com/?value=" 
        							+ number 
        							+ "&operation="
        							+ operation).asString();
        return new JSONObject(answer.getBody());
    }
}
