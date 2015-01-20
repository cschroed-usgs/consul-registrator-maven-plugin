/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.cida;

/**
 *
 * @author cschroed
 */
public class ConsulRegistratorMojoIntegrationTest {
    public static final ConsulRegistratorMojo instance = new ConsulRegistratorMojo();
    public static final String HOST = "host";
    public static final int PORT = 8123;
    public static final String NON_CONTEXT_PATH = ConsulRegistratorMojo.PROTOCOL_PREFIX + HOST + ':' + PORT;
    
    @org.junit.Test
    public void testRealDeal(){
	String host = "localhost";
	int consulPort = 8500;
	String serviceId = null;
	String serviceName = "testService";
	int servicePort = 8080;
	String[] tags = {"1.0-SNAPSHOT"};
	String ttl = "";
	String interval = "5s";
	String customScript = null;
	String[] contextPaths = {"/service/health/"};
	instance.realDeal(host, consulPort, serviceId, serviceName, servicePort, tags, ttl, interval, customScript, contextPaths);
    }
    
}
