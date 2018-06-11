/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.dita.dev.shecemimplementation.model.Base;

/**
 *
 * @author brian-kamau
 */
public class BaseTests {  
    public BaseTests() {
    }
    
    @Test
    public void testDatabaseConnection(){
        System.out.println("Testing Database Implementation");
        Base Implementation = new BaseImplementation();
        boolean expectedResult = true;
        boolean result = Implementation.getDatabaseConnection();
        assertEquals(result,expectedResult);
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
    
    public class BaseImplementation extends Base{
        
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
