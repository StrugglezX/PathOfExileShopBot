package poeapi.infrastructure.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import poeapi.infrastructure.PoeTradeItemModificationBuilder;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileItemModification;
import poetest.PoeTest;

@RunWith(Parameterized.class)
public class TestPoeTradeItemModificationBuilder {

	List<String> _explicitModsInput;
	List<String> _implicitModsInput;
	List<PathOfExileItemModification> _expectedMods;
	
	PoeTradeItemModificationBuilder _patient;
	
	@Parameterized.Parameters(name ="{index}: Test with explicitMods={0}, implicitMods={1}, expectedMods= {2}")
	public static Iterable<Object[]> data(){
		PathOfExileItem input1 = new PathOfExileItem();
		
		List<String> explicitMods1 = new ArrayList<String>();
		explicitMods1.add("Adds 88 to 348 Physical Damage");
		explicitMods1.add("50% of Physical Damage Converted to Lightning Damage");
		explicitMods1.add("You cannot Cast Supported Triggerable Spells directly");
		
		List<String> implicitMods1 = new ArrayList<String>();
		implicitMods1.add("+22 to Dexterity");
		
		List<PathOfExileItemModification> expectedMods1 = new ArrayList<PathOfExileItemModification>();
		PathOfExileItemModification expectedMod1 = new PathOfExileItemModification("Adds # to # Physical Damage", 218);
		expectedMods1.add(expectedMod1);
		PathOfExileItemModification expectedMod2 = new PathOfExileItemModification("#% of Physical Damage Converted to Lightning Damage", 50);
		expectedMods1.add(expectedMod2);
		PathOfExileItemModification expectedMod3 = new PathOfExileItemModification("You cannot Cast Supported Triggerable Spells directly", 0);
		expectedMods1.add(expectedMod3);
		PathOfExileItemModification expectedMod4 = new PathOfExileItemModification("(implicit) +# to Dexterity", 22);
		expectedMods1.add(expectedMod4);
		
		return Arrays.asList(new Object[][]{
			{new ArrayList<String>(), new ArrayList<String>(), new ArrayList<PathOfExileItemModification>()},
			{explicitMods1, implicitMods1, expectedMods1},
		});
	}
	
	public TestPoeTradeItemModificationBuilder(List<String> explicitModsInput, List<String> implicitModsInput, List<PathOfExileItemModification> expectedMods){
		_explicitModsInput = explicitModsInput;
		_implicitModsInput = implicitModsInput;
		_expectedMods = expectedMods;
	}
	
	@Before
	public void setUp() throws Exception {
		_patient = new PoeTradeItemModificationBuilder(); 
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void testWillBuildModificationsCorrectly() {
		PathOfExileItem item = new PathOfExileItem();
		item.setExplicitMods(_explicitModsInput);
		item.setImplicitMods(_implicitModsInput);
		
		List<PathOfExileItemModification> actualMods = _patient.buildModifications(item);
		
		PoeTest.verifyEquals(actualMods, _expectedMods);
	}

}
