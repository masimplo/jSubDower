/**
 * 
 */
package mxa055.SubDower;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.*; 
import org.junit.Assert;

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
		boolean works = response.containsKey("xmlrpc_version");
		Object version = response.get("xmlrpc_version");
		Assert.assertNotNull(version);
	}
}
