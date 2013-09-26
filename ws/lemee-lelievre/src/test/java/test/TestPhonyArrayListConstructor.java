/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import system.PhonyArrayList;

/**
 * Test case of the three constructor {@link PhonyArrayList}
 * @author Thomas LELIEVRE - Anthony LE MEE (13000170 - 10003134)
 * @since 20/09/2013
 *
 */
public class TestPhonyArrayListConstructor {
	
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
	* Tests the "{@link PhonyArrayList#lastIndexOf(int)}" constructor with illegal 
	* "Capacity" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type Functional
	* @input -1
	* @oracle Must return throw IllegalArgumentException
	* @passed Yes
	*/
	@Test(expected=IllegalArgumentException.class)
	public void testPhonyArrayListCapacityException() {
		
		pal = new PhonyArrayList<Object>(-1);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(int)}" constructor with correct 
	* "Capacity" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type Functional
	* @input 8
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCapacityCreat() {
		
		pal = new PhonyArrayList<Object>(8);
		assert(pal!=null);
		
	}

	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(Collection)}" constructor with 
	* empty "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(Collection)
	* @type Functional
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCollectionVide() {
		
		Collection<Object> c = new LinkedList<Object>();
		pal = new PhonyArrayList<Object>(c);
		assert(pal != null);
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(Collection)}" constructor with non object Element
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(Collection)
	* @type Functional
	* @input 
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCollectionOfQextendsE() {
		
		PhonyArrayList<Object> c1 	= new PhonyArrayList<Object>();
		Collection<Object> c2 	= new PhonyArrayList<Object>();
		c1 = new PhonyArrayList<Object>(Arrays.asList(c2));
		assert(c1 != null);
	
	}
	
	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(Collection)}" constructor with 
	* full "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(Collection)
	* @type Functional
	* @input ArrayList with two elements : String("toto") and String ("titi")
	* @oracle Must return "true"
	* @passed Yes
	*/
	@Test
	public void testPhonyArrayListCollectionPleine() {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assert(pal.size() == c.size());
		
	}
	
	/**
	* Tests the "{@link PhonyArrayList#lastIndexOf(Collection)}" constructor with 
	* illegal "Collection" parameter.
	* @see lemee-lelievre.PhonyArrayList#PhonyArrayList(int)
	* @type Functional
	* @input -1
	* @oracle Must return throw NullPointerException
	* @passed Yes
	*/
	@Test(expected=NullPointerException.class)
	public void testPhonyArrayListCollectionNull() {
		
		Collection<Object> c = null;
		pal = new PhonyArrayList<Object>(c);
		
	}
	
}
