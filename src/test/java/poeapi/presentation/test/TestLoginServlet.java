package poeapi.presentation.test;

import static org.mockito.Mockito.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.InOrder;

import poeapi.infrastructure.LoginHttpDispatcher;
import poeapi.presentation.LoginServlet;

public class TestLoginServlet {

	@SuppressWarnings("serial")
	private class ShoppingServletInstance extends LoginServlet{
		public ShoppingServletInstance() {
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

		public void setDispatcher(LoginHttpDispatcher loginDispatcher){
			_loginDispatcher = loginDispatcher;
		}
		
		ServletContext sc;
	}
	ShoppingServletInstance _patient;

	LoginHttpDispatcher _loginDispatcher;
	
	HttpServletRequest _req;
	HttpServletResponse _res;
	RequestDispatcher _rd;
	String _requestAction;
	HttpSession _session;
	
	@Before
	public void setUp() throws Exception {
		_patient = new ShoppingServletInstance();
		_loginDispatcher = mock(LoginHttpDispatcher.class);
		_req = mock(HttpServletRequest.class);
		_res = mock(HttpServletResponse.class);
		_rd = mock(RequestDispatcher.class);
		_requestAction = new String("not login");
		_session = mock(HttpSession.class);

		_patient.setDispatcher(_loginDispatcher);
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_patient.sc.getRequestDispatcher(any())).thenReturn(_rd);
		when(_req.getSession(true)).thenReturn(_session);
	}

	@After
	public void tearDown() throws Exception {
		_patient = null;
	}

	@Test
	public void testDoPostWillGetRequestAction() throws Exception {
		_patient.doPost(_req, _res);

		verify(_req, atLeastOnce()).getParameter("do_this");
	}

	@Test
	public void testDoPostWillRedirectToHomeWhenActionIsNotLogin() throws Exception {
		_patient.doPost(_req, _res);

		verify(_patient.sc).getRequestDispatcher("/");
		verify(_rd).forward(_req, _res);
	}
	
	@Test
	public void testDoPostWillGetSessionIdOnLogin() throws Exception {
		_requestAction = new String("login");
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		
		_patient.doPost(_req, _res);

		InOrder inOrder = inOrder(_req);
		inOrder.verify(_req, times(2)).getParameter(AdditionalMatchers.or(eq("do_this"), eq("POESESSID")));
	}
	
	@Test
	public void testDoPostWillRedirectToHomeWhenSessionIdNull() throws Exception {
		_requestAction = new String("login");
		String sessId = null;
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		
		_patient.doPost(_req, _res);

		verify(_patient.sc).getRequestDispatcher("/");
		verify(_rd).forward(_req, _res);
	}
	
	@Test
	public void testDoPostNotAttemptToLoginWithANullSessionId() throws Exception {
		_requestAction = new String("login");
		String sessId = null;
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		
		_patient.doPost(_req, _res);

		verify(_loginDispatcher, never()).loginToPathOfExile(any());
	}

	@Test
	public void testDoPostWillLoginToPathOfExile() throws Exception {
		_requestAction = new String("login");
		String sessId = new String("not null");
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		
		_patient.doPost(_req, _res);

		verify(_loginDispatcher).loginToPathOfExile(sessId);
	}
	
	@Test
	public void testDoPostWillRedirectToHomeWhenLoginFails() throws Exception {
		_requestAction = new String("login");
		String sessId = new String("not null");
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		when(_loginDispatcher.loginToPathOfExile(any())).thenReturn(false);
		
		_patient.doPost(_req, _res);

		verify(_patient.sc).getRequestDispatcher("/");
		verify(_rd).forward(_req, _res);
	}

	@Test
	public void testDoPostRedirectToAccountPageWhenLoginSuccessful() throws Exception {
		_requestAction = new String("login");
		String sessId = new String("not null");
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		when(_loginDispatcher.loginToPathOfExile(any())).thenReturn(true);
		
		_patient.doPost(_req, _res);

		verify(_patient.sc).getRequestDispatcher("/account");
		verify(_rd).forward(_req, _res);
	}
	
	@Test
	public void testDoPostWillSetAccountNameOnLogin() throws Exception {
		_requestAction = new String("login");
		String sessId = new String("not null");
		String accountName = new String("account");
		when(_req.getParameter("do_this")).thenReturn(_requestAction);
		when(_req.getParameter("POESESSID")).thenReturn(sessId);
		when(_req.getParameter("accountName")).thenReturn(accountName);
		when(_loginDispatcher.loginToPathOfExile(any())).thenReturn(true);
		
		_patient.doPost(_req, _res);

		verify(_req).getParameter("accountName");
		verify(_req).getSession(true);
		verify(_session).setAttribute("accountName", accountName);
	}

}
