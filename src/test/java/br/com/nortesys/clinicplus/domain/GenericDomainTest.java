/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nortesys.clinicplus.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francisco
 */
public class GenericDomainTest {
    
    public GenericDomainTest() {
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
     * Test of getCodigo method, of class GenericDomain.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        GenericDomain instance = new GenericDomain();
        Long expResult = null;
        Long result = instance.getCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodigo method, of class GenericDomain.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        Long codigo = null;
        GenericDomain instance = new GenericDomain();
        instance.setCodigo(codigo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GenericDomain.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GenericDomain instance = new GenericDomain();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GenericDomain.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        GenericDomain instance = new GenericDomain();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
