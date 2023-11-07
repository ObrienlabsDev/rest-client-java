package dev.obrienlabs;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class RestClient {
	
	// from 
	
	static Logger logger = Logger.getLogger(RestClient.class.getName());
		
	private static final String URL_CREATE_RECORD =
	            "http://biometric.elasticbeanstalk.com/FrontController?action=activeid";
	    
	public static void restCall() {		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL_CREATE_RECORD))
				.GET()
				.build();
// async
		//		HttpRequest request = HttpRequest.newBuilder()
//			        .uri(URI.create("https://foo.com/"))
//			        .timeout(Duration.ofMinutes(2))
//			        .header("Content-Type", "application/json")
//			        .POST(BodyPublishers.ofFile(Paths.get("file.json")))
//			        .build();	
		
	//HttpClient client = HttpClient.newBuilder().build();
	HttpClient client = HttpClient.newBuilder()
	        .version(Version.HTTP_1_1)
	        .followRedirects(Redirect.NORMAL)
	        .connectTimeout(Duration.ofSeconds(20))
	        //.proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
	        //.authenticator(Authenticator.getDefault())
	        .build();
	try {
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		logger.info("Response: " + body);
		   
		System.out.println(response.statusCode());
		System.out.println(response.body()); 
	} catch (IOException ioe) {
		ioe.printStackTrace();
	} catch (InterruptedException ie) {
		ie.printStackTrace();
	}
 
	
	}
	
    public static void main( String[] args )
    {
        RestClient app = new RestClient();
        app.restCall();
    }
}
