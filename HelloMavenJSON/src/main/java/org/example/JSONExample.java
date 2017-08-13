package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONExample {

	private static final String URL = "https://www.ing.nl/api/locator/atms/";
	private static final JSONArray DB;

	static {
		DB = fetchDataFromURLAsJSONArray(URL);
	}

	/**
	 * MAIN Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JSONExample example = new JSONExample();
		
		JSONArray atms = example.getATMForCity("UTRECHT");
		System.out.println(atms.length());
		System.out.println(atms);

		JSONArray atms1 = example.getATMForPostcode("3564");
		System.out.println(atms1.length());
		System.out.println(atms1);
	}

	/**
	 * Fetch the ATM's for a given city.
	 *
	 * @param input
	 * @param city
	 * @return
	 */
	protected JSONArray getATMForCity(String city) {
		JSONArray response = new JSONArray();
		Iterator<Object> itr = DB.iterator();
		while (itr.hasNext()) {
			JSONObject o = (JSONObject) itr.next(); // fetch parent object
			// fetch the Address Objects from parent object
			JSONObject addrObj = (JSONObject) o.get("address"); 
			// fetch city from the address object & compare with input city
			if (city.equals(addrObj.get("city"))) { 
				response.put(o);
			}
		}
		return response;
	}

	/**
	 * Fetch the ATM's for a given city.
	 *
	 * @param input
	 * @param city
	 * @return
	 */
	protected JSONArray getATMForPostcode(String postalCode) {
		JSONArray response = new JSONArray();
		Iterator<Object> itr = DB.iterator();
		while (itr.hasNext()) {
			JSONObject o = (JSONObject) itr.next(); // fetch parent object
			// fetch the Address Objects from parent object
			JSONObject addrObj = (JSONObject) o.get("address"); 
			String pc = addrObj.getString("postalcode");
			// fetch city from the address object & compare with input city
			if (null != pc && pc.startsWith(postalCode)) { 
				response.put(o);
			}
		}
		return response;
	}

	/**
	 * Fetches the data to maintain the internal data source.
	 *
	 * @param url
	 * @return
	 */
	protected static JSONArray fetchDataFromURLAsJSONArray(String url) {
		JSONArray jsonArray = null;
		try {
			String urlResult = getCompleteList(url);
			String parsedResult = urlResult.substring(urlResult.indexOf('['), urlResult.lastIndexOf(']') + 1);
			jsonArray = new JSONArray(parsedResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	/**
	 * Method to fetch the data from a given URL.
	 *
	 * @param urlStr
	 *            : input URL which should return JSON String data.
	 * @return String : JSON String with data
	 * @throws IOException
	 */
	public static String getCompleteList(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}
		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		return sb.toString();
	}
}