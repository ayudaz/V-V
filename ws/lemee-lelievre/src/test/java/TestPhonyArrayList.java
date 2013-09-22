import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import  static org.junit.Assert.*;

import  system.PhonyArrayList;

/**
 * 
 */

/**
 * @author 13000170
 *
 */
public class TestPhonyArrayList {

	private PhonyArrayList<Object> pal;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		pal = new PhonyArrayList<Object>();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		pal = null;
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPhonyArrayListCapacityException() {
		
		pal = new PhonyArrayList<Object>(-1);
		
	}
	
	@Test
	public void testPhonyArrayListCapacityCreat() {
		
		pal = new PhonyArrayList<Object>(8);
		assert(pal!=null);
		
	}
	
	@Test
	public void testPhonyArrayListCollectionVide() {
		
		Collection<Object> c = new LinkedList<Object>();
		pal = new PhonyArrayList<Object>(c);
		assert(pal != null);
		
	}
	
	@Test
	public void testPhonyArrayListCollectionPleine() {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assert(pal.size() == c.size());
		
	}

	@Test
	public void testIsEmptyTrue () {
		
		assert(pal.isEmpty());
		
	}
	
	@Test
	public void testIsEmptyFalse () {
		
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		pal = new PhonyArrayList<Object>(c);
		assertFalse(pal.isEmpty());
		
	}
	
	@Test
	public void testAdd() {
		
		pal.add(new String("lemee"));
		Collection<Object> c = new ArrayList<Object>();
		c.add(new String("toto"));
		c.add(new String("titi"));
		PhonyArrayList<Object> paltest = new PhonyArrayList<Object>(c);
		
		
	}
	
}
