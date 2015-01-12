/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.cida;

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
public class ConsulRegistratorMojoTest {
    
    public ConsulRegistratorMojoTest() {
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
     * Test of execute method, of class ConsulRegistratorMojo.
     */
    @org.junit.Test
    public void testExecute() throws Exception {
	System.out.println("execute");
	ConsulRegistratorMojo instance = new ConsulRegistratorMojo();
	instance.execute();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of buildScript method, of class ConsulRegistratorMojo.
     */
    @org.junit.Test
    public void testBuildScript() {
	System.out.println("buildScript");
	String customScript = "";
	String[] urls = null;
	ConsulRegistratorMojo instance = new ConsulRegistratorMojo();
	String expResult = "";
	String result = instance.buildScript(customScript, urls);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
