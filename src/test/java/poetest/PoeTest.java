package poetest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

public class PoeTest {
	public static void verifyTrue(boolean value){
		try{
			assertTrue(value);
		}
		catch(Exception e){
			System.out.println("Expected True, was False");
			throw e;
		}
	}
	public static void verifyFalse(boolean value){
		try{
			assertFalse(value);
		}
		catch(Exception e){
			System.out.println("Expected False, was True");
			throw e;
		}
	}
	public static void verifyEquals(Object actual, Object expected){
		try{
			assertEquals(expected, actual);
		}
		catch(AssertionError  e){
			System.out.println("Expected.'" + expected.toString() + "'");
			System.out.println("Actual...'" + actual.toString() + "'");
			throw e;
		}
	}

	public static <T> void verifyEquals(List<T> actual, List<T> expected){
		try{
			assertEquals(expected.size(), actual.size());
			
		}
		catch(AssertionError  e){
			System.out.println("Expected size '" + expected.size() + "'");
			System.out.println("Actual size ..'" + actual.size() + "'");
			throw e;
		}
		for(int i = 0; i < actual.size(); i++){
			T expectedValue = expected.get(i);
			T actualValue = actual.get(i);
			try{
				assertEquals(expectedValue, actualValue);
			}
			catch(AssertionError e){
				System.out.println("Expected[" + i + "] " + expectedValue.toString());
				System.out.println("Actual..[" + i + "] " + actualValue.toString());
				throw e;
			}
		}
	}

	public static <T> void verifyEquals(Set<T> actual, Set<T> expected){
		try{
			assertEquals(expected.size(), actual.size());
			
		}
		catch(AssertionError  e){
			System.out.println("Expected size '" + expected.size() + "'");
			System.out.println("Actual size ..'" + actual.size() + "'");

			throw e;
		}
		for(T value : expected){
			try{
				assertTrue(actual.contains(value));
			}
			catch(AssertionError e){
				System.out.println("Expected " + value.toString());
				throw e;
			}
		}
	}
}
