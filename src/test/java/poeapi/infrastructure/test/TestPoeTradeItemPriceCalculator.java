package poeapi.infrastructure.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import poeapi.infrastructure.PoeTradeItemPriceCalculator;
import poetest.PoeTest;

@RunWith(Parameterized.class)
public class TestPoeTradeItemPriceCalculator {

	List<String> _input;
	String _expected;
	
	PoeTradeItemPriceCalculator _patient;
	
	@Parameterized.Parameters(name ="{index}: Test with input={0}, expected={1}")
	public static Iterable<Object[]> data(){
		List<String> input1 = new ArrayList<String>();
		input1.add("1 chaos");
		input1.add("2 chaos");
		input1.add("3 chaos");
		input1.add("4 chaos");
		input1.add("5 chaos");
		String expected1 = new String("1 chaos");

		List<String> input2 = new ArrayList<String>();
		input2.add("1 exalt");
		input2.add("2 exalt");
		input2.add("3 exalt");
		input2.add("4 exalt");
		input2.add("5 exalt");
		String expected2 = new String("1 exalt");
		
		return Arrays.asList(new Object[][]{
			{new ArrayList<String>(), "Fail"},
			{input1, expected1},
			{input2, expected2},
		});
	}
	
	public TestPoeTradeItemPriceCalculator(List<String> input, String expected){
		_input = input;
		_expected = expected;
	}
	
	@Before
	public void setUp() throws Exception {
		_patient = new PoeTradeItemPriceCalculator();
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void testCanCalculatePriceFromListOfPrice() {
		for(String listedPrice : _input){
			_patient.addListedPrice(listedPrice);
		}
		
		String actual = _patient.price();
		PoeTest.verifyEquals(actual, _expected);
	}

}
