package test.mxa055.SubDower;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import mxa055.SubDower.OpenSubsXMLRPC;

import org.apache.xmlrpc.XmlRpcException;
import org.junit.Test;

public class OpenSubsXMLRPCTest {

	@Test
	public void test() {
		OpenSubsXMLRPC osXMLRPC;
		try {
			osXMLRPC = new OpenSubsXMLRPC();
			osXMLRPC.ServerInfo();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlRpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
