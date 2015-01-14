/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.cida;

import org.apache.commons.lang3.text.StrBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cschroed
 */
public class ConsulRegistratorMojoUnitTest {
    public static final ConsulRegistratorMojo instance = new ConsulRegistratorMojo();
    public static final String HOST = "host";
    public static final int PORT = 8123;
    public static final String NON_CONTEXT_PATH = ConsulRegistratorMojo.PROTOCOL_PREFIX + HOST + ':' + PORT;
    /**
     * A wrapper for the real deal
     * @param customScript
     * @param contextPaths
     * @return 
     */
    public static String buildScript(String customScript, String[] contextPaths){
	return instance.buildScript(customScript, contextPaths, HOST, PORT);
    }
    
    public ConsulRegistratorMojoUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buildScript method, of class ConsulRegistratorMojo.
     */
    
    @org.junit.Test
    public void testBuildScriptNullAndEmptyParams() {
	String[] contextPaths = {};
	String expResult = null;
	String result;
	result = buildScript(null, contextPaths);
	assertEquals(expResult, result);
	
	result = buildScript(null, null);
	assertEquals(expResult, result);
	
	result = buildScript("", contextPaths);
	assertEquals(expResult, result);
	
	result = buildScript("", null);
	assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testBuildScriptBothCustomScriptAndUrls() {
	String customScript = "mkdir blah";
	String[] contextPaths = {"/wow", "/big", "/time"};
	String expResult = customScript;
	String result = buildScript(customScript, contextPaths);
	assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testBuildScriptCustomScriptOnly() {
	String customScript = "mkdir blah";
	String expResult = customScript;
	String result = buildScript(customScript, null);
	assertEquals(expResult, result);
	result = buildScript(customScript, new String[0]);
	assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testBuildScriptContextPathsOnly() {
	String[] contextPaths = {"/wow", "/big", "/time"};
	StrBuilder sb = new StrBuilder();
	sb.append(ConsulRegistratorMojo.URL_COMMAND);
	for(String contextPath : contextPaths){
	    sb.append(NON_CONTEXT_PATH)
	    .append(contextPath)
	    .append(' ');
	}
	sb.trim();
	
	String expResult = sb.build();
	
	String result = buildScript(null, contextPaths);
	assertEquals(expResult, result);
	result = buildScript("", contextPaths);
	assertEquals(expResult, result);
    }
    
}
