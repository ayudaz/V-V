/**
 * 
 */
package test;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import system.PhonyArrayList;

/**
 * Test case of the method {@link PhonyArrayList#isEmpty()}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 *
 */
public class TestPhonyArrayListIsEmpty {
	
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
	* Tests the "{@link PhonyArrayList#isEmpty()}" method when 
	* "this.elementData = EMPTY_ELEMENTDATA"
	* @see lemee-lelievre.PhonyArrayList#isEmpty()
	* @type Functional
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIsEmptyTrue () {
		
		assert(pal.isEmpty());
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#isEmpty()}" method when 
	* "this.elementData != EMPTY_ELEMENTDATA"
	* @see lemee-lelievre.PhonyArrayList#isEmpty()
	* @type Functional
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testIsEmptyFalse () {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assertFalse(pal.isEmpty());
		
	}
	
}
