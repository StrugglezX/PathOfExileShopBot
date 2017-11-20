package poeapi.infrastructure.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.infrastructure.PoeTradeItemModificationBuilder;
import poeapi.infrastructure.PoeTradeSearchParametersBuilder;
import poeapi.model.PathOfExileItem;
import poeapi.model.PathOfExileItemModification;
import poeapi.model.PoeTradeSearchParameters;
import poetest.PoeTest;

public class TestPoeTradeSearchParametersBuilder {

	PoeTradeItemModificationBuilder _itemModificationBuilder;
	
	PoeTradeSearchParametersBuilder _patient;
	
	@Before
	public void setUp() throws Exception {
		_itemModificationBuilder = mock(PoeTradeItemModificationBuilder.class);
		
		_patient = new PoeTradeSearchParametersBuilder(_itemModificationBuilder);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
		
		_itemModificationBuilder = null;
	}
	
	
	@Test
	public void testSearchParametersWillContainLeague() {
		PathOfExileItem item = new PathOfExileItem();
		String league = new String("Standard");
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getLeague(), league);
	}

	@Test
	public void testSearchParametersWillContainTypeLine() {
		PathOfExileItem item = new PathOfExileItem();
		String typeLine = new String("TypeLine");
		item.setTypeLine(typeLine);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getTypeLine(), typeLine);
	}
	
	@Test	
	public void testSearchParametersCanSearchForSixLinks() {
		PathOfExileItem item = new PathOfExileItem();
		item.setSixLink(true);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getLinkCount(), 6);
	}
	
	@Test	
	public void testSearchParametersCanSearchForNonSixLinks() {
		PathOfExileItem item = new PathOfExileItem();
		item.setSixLink(false);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getLinkCount(), 0);
	}
	
	@Test
	public void testWillBuildMods() {
		PathOfExileItem item = new PathOfExileItem();
		List<PathOfExileItemModification> expectedModifications = new ArrayList<PathOfExileItemModification>();
		expectedModifications.add(new PathOfExileItemModification("Mod", 5));
		
		_patient.buildParameters(item);
		
		verify(_itemModificationBuilder).buildModifications(item);
	}
	
	@Test
	public void testSearchParametersWillContainBuiltModifications() {
		PathOfExileItem item = new PathOfExileItem();
		List<PathOfExileItemModification> expectedModifications = new ArrayList<PathOfExileItemModification>();
		expectedModifications.add(new PathOfExileItemModification("Mod", 5));
		when(_itemModificationBuilder.buildModifications(item)).thenReturn(expectedModifications);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getMods(), expectedModifications);
	}

	@Test
	public void testSearchParametersWillContainItemLevel() {
		PathOfExileItem item = new PathOfExileItem();
		int level = 55;
		item.setItemLevel(level);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.getItemLevel(), level);
	}
	
	@Test
	public void testSearchParametersWillContainCorruption() {
		PathOfExileItem item = new PathOfExileItem();
		boolean corrupted = true;
		item.setCorrupted(corrupted);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.isCorrupted(), corrupted);
	}
	
	@Test
	public void testSearchParametersWillContainIdentification() {
		PathOfExileItem item = new PathOfExileItem();
		boolean identified = true;
		item.setIdentified(identified);
		
		PoeTradeSearchParameters actualParameters = _patient.buildParameters(item);
		
		PoeTest.verifyEquals(actualParameters.isIdentified(), identified);
	}
}
