/**
 * 
 */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import system.PhonyArrayList;

/**
 * Test case of the method {@link PhonyArrayList#indexOf(Object)}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 *
 */
public class TestPhonyArrayListIndexOf {
	
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
	* Tests the "{@link PhonyArrayList#indexOf(Object)}" method - test membership and not membership to an 
	* Object that is present only once
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfOneOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		assert(pal.indexOf(toto) < 0);
		
		pal.add(toto);
		
		assert(pal.indexOf(toto) == 0);
		assert(pal.indexOf(titi) < 0);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#indexOf(Object)}" method - test membership and not membership to an 
	* Object not instantiated that is present only once
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type Functional
	* @input toto, null, toto, null
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfOneOccNull() {
		
		assert(pal.indexOf(null) < 0);
		
		String toto = new String("toto");
		
		pal.add(toto);
		pal.add(null);
		pal.add(toto);
		pal.add(null);

		assert(pal.indexOf(null) == 1);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#indexOf(Object)}" method - test membership and not memberships to an 
	* object that is present several times
	* @see lemee-lelievre.PhonyArrayList#indexOf()
	* @type  Functional
	* @input toto, titi, toto
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIndexOfMultiOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		pal.add(toto);
		pal.add(titi);
		pal.add(toto);
				
		assert(pal.indexOf(toto) == 0);
		assert(pal.indexOf(titi) == 1);
		
	}
	
}
