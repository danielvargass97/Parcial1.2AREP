package edu.escuelaing.arep;

import static spark.Spark.get;
import static spark.Spark.port;

import com.google.gson.Gson;
import com.google.gson.JsonParser;


/**
 * 
 * @author Daniel
 *
 */
public class SparkWebApp {
	
	/**
	 * This main method uses SparkWeb static methods and lambda functions to create 
	 * a App that calculate the mean and estandar deviation of a number list entered 
	 * by a field on the web page
	 */
	public static void main(String[] args) {
		port(getPort());
		Gson gson = new Gson();
		
		get("/", (req, res) -> {
			String num = req.queryParams("value");
			String oper = req.queryParams("operation");
			return Facade.getValue(num, oper);
		});
	}
	
		/**
		 * This method reads the default port as specified by the PORT variable in
		 * the environment.
		 *
		 * Heroku provides the port automatically so you need this to run the
		 * project on Heroku.
		 */
		static int getPort() {
			if (System.getenv("PORT") != null) {
				return Integer.parseInt(System.getenv("PORT"));
			}
			return 4567; //returns default port if heroku-port isn't set	
		}
		

}