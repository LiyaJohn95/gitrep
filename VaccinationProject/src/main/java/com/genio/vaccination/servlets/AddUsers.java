package com.genio.vaccination.servlets;

import java.io.DataOutputStream;
import java.io.IOException;


import java.net.HttpURLConnection;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.net.ssl.HttpsURLConnection;

/**
 * Servlet implementation class AddUsers
 */
public class AddUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void sendRequest(String request) throws IOException
    {
    	String urlParameters  = "param1=a&param2=b&param3=c";
    	byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
    	int    postDataLength = postData.length;
    	request        = "http://localhost:8080/VaccinationProject/AddUsers";
    	URL url = new URL(request);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	
    	conn.setDoOutput( true );
    	conn.setInstanceFollowRedirects( false );
    	conn.setRequestMethod( "GET" );
    	conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
    	conn.setRequestProperty( "charset", "utf-8");
    	conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
    	conn.setUseCaches( false );
    	try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
    	   wr.write( postData );
    	}
    }
}


