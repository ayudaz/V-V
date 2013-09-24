package test;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import system.PhonyArrayList;

/**
 * test Case of {@link TestPhonyArrayList}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 */
public class TestPhonyArrayList {
	

	/** Class Attributes */
	private PhonyArrayList<Object> pal;
	
	/**
	 * Executed before each test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		pal = new PhonyArrayList<Object>();
		
	}

	/**
	 * Executed after each test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		pal = null;
		
	}
	
	/**
	* Tests the "contains" method 
	* @see lemee-lelievre.PhonyArrayList#contains()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	l.208
	* 	- indexOf(o) > 0; 
	*   + indexOf(o) >= 0;
	* </pre>
	*/
	@Test
	public void testContains() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		String tutu = new String("tutu");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(toto);
				
		assert(pal.contains(toto));
		assertFalse(pal.contains(tutu));
		
	}	
	
}
