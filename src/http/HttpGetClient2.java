package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient2 {

	public static void main(String[] args) {

		String urlString = "http://127.0.0.1:8080/test";

		try {
			URL url = new URL(urlString);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputStr;
			StringBuffer responseBuffer = new StringBuffer();

			while ((inputStr = brIn.readLine()) != null) {
				responseBuffer.append(inputStr);
			}

			brIn.close();
			String[] str = responseBuffer.toString().split("\\s");
			for (String word : str) {
				System.out.println(word);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
