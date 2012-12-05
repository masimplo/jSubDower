/**
 * 
 */
package mxa055.SubDower;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.*; 
import org.junit.Assert;

import sun.security.util.Debug;

public class OpenSubsXMLRPC {
	private XmlRpcClient server;
	public OpenSubsXMLRPC() throws MalformedURLException
	{
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();  
	    config.setServerURL(new URL("http://api.opensubtitles.org/xml-rpc"));
	    server = new XmlRpcClient();
	    server.setConfig(config);
	}
	
	public void ServerInfo() throws XmlRpcException
	{
		Object[] params = new Object[0];
		HashMap<String,Object> response = (HashMap<String, Object>) server.execute("ServerInfo", params);
		Assert.assertNotNull(response);
		
		Debug.println("Version", (String) response.get("xmlrpc_version"));
		Debug.println("Url", (String) response.get("xmlrpc_url"));
		Debug.println("Application", (String) response.get("application"));
		Debug.println("Contact",(String) response.get("contact"));
		Debug.println("Website url",(String) response.get("website_url"));
		Debug.println("Total Users online", String.valueOf((int) response.get("users_online_total")));
		Debug.println("Program Users online", String.valueOf((int) response.get("users_online_program")));
		Debug.println("Users logged in", String.valueOf((int) response.get("users_loggedin")));
		Debug.println("Maximum users online", (String) response.get("users_max_alltime"));
		Debug.println("Registered users", (String) response.get("users_registered"));
		Debug.println("Sub downloads", (String) response.get("subs_downloads"));
		Debug.println("Subtitles files", (String) response.get("subs_subtitle_files"));
		Debug.println("Total movies", (String) response.get("movies_total"));
		Debug.println("Movies aka", (String) response.get("movies_aka"));
		Debug.println("Total subtitle languages", (String) response.get("total_subtitles_languages"));
		Debug.println("Seconds",  String.valueOf((double)response.get("seconds")));
		
		HashMap<String, Object> lastUpdateStrings =  (HashMap<String, Object>) response.get("last_update_strings");
		Debug.println("GR", (String) lastUpdateStrings.get("el"));
		Debug.println("EN", (String) lastUpdateStrings.get("en"));
		
		
		HashMap<String, Object> downloadLimits =  (HashMap<String, Object>) response.get("download_limits");
		Debug.println("Global 24 Hour download limit", String.valueOf((int) downloadLimits.get("global_24h_download_limit")));
		Debug.println("Client IP", (String) downloadLimits.get("client_ip"));
		Debug.println("Limit check by", (String) downloadLimits.get("limit_check_by"));
		Debug.println("Client 24h download count", String.valueOf((int) downloadLimits.get("global_24h_download_limit")));
		Debug.println("Client download quota", String.valueOf((int) downloadLimits.get("client_download_quota")));
		Debug.println("Client 24 Hour download limit", String.valueOf((int) downloadLimits.get("client_24h_download_limit")));		  
	}
}
