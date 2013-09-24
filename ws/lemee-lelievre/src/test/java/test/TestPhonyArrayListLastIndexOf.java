/**
 * 
 */
package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import system.PhonyArrayList;

/**
 * Test case of the method {@link PhonyArrayList#lastIndexOf(Object)} of {@link PhonyArrayList}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 *
 */
public class TestPhonyArrayListLastIndexOf {
	
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
	* Tests the "{@link PhonyArrayList#lastIndexOf(Object)}" method - test membership and not membership to an 
	* Object that is present only once
	* @see lemee-lelievre.PhonyArrayList#lastIndexOf(Object o)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	
	* </pre>
	*/
	@Test
	public void testLastIndexOfOneOcc() {
		
		String toto = new String("toto");
		String titi = new String("titi");
		
		assert(pal.lastIndexOf(toto) < 0);
		
		pal.add(toto);
		
		assert(pal.lastIndexOf(toto) == 0);
		assert(pal.lastIndexOf(titi) < 0);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(Object)}" method - test membership and not memberships to an 
	* object that is present several times
	* @see lemee-lelievre.PhonyArrayList#lastIndexOf(Object o)
	* @type 
	* @input 
	* @oracle Must return "true"
	* @passed No
	* @correction
	* <pre>
	* 	
	* </pre>
	*/
	@Test
	public void testLastIndexOfMultiOcc() {
		
//		String toto = new String("toto");
//		String titi = new String("titi");
//		String tutu = new String("tutu");
//		
//		pal.add(toto);
//		pal.add(titi);
//		pal.add(tutu);
//
//		assert(pal.indexOf(toto) == 2);
//		assert(pal.indexOf(titi) == 1);
		
	}
	
}
