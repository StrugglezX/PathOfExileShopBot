package poeapi.presentation.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import poeapi.presentation.AccountServlet;

public class TestAccountServlet {

	private class AccountServletInstance extends AccountServlet{
		public AccountServletInstance() {
			sc = mock(ServletContext.class);
		}
		@Override
		public void doPost(HttpServletRequest req, HttpServletResponse res) 
				throws ServletException, IOException {
			super.doPost(req,res);
		}
		
		@Override
		public ServletContext getServletContext(){
			return sc;
		}

//		public void setDispatcher(PathOfExileHttpDispatcher httpDispatcher){
//			_httpDispatcher = httpDispatcher;
//		}
//		
		ServletContext sc;
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

}
