package org.wiztools.xmlvalidator;

import java.io.File;
import javax.xml.validation.Schema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author subwiz
 */
public class SchemaUtilTest {
    
    public SchemaUtilTest() {
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
     * Test of validate method, of class SchemaUtil.
     */
    @Test
    public void testValidateXsdPositive() {
        System.out.println("validate");
        try {
            Schema schema = SchemaUtil.getWXSSchema(new File("src/test/resources/books.xsd"));
            File file = new File("src/test/resources/books.xml");
            SchemaUtil.validate(schema, file);
        }
        catch(Exception ex) {
            fail("The test case is a prototype.");
        }
    }
    
}
