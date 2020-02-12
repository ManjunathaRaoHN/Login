package com.login.Loginservlet;
import com.login.input.*;
import com.login.LoginDao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.LoginDao.LoginDao;
import com.login.input.Logininput;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao logindao;
    public void init() {
        logindao = new LoginDao();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	Logininput logininput=new Logininput();
	logininput.setUsername(username);
	logininput.setPassord(password);
		
		 try {
	            if (logindao.validate(logininput)) {
	                //HttpSession session = request.getSession();
	                // session.setAttribute("username",username);
	                response.sendRedirect("loginsuccess.jsp");
	            } else {
	                HttpSession session = request.getSession();
	                session.setAttribute("user", username);
	                response.sendRedirect("Login.jsp");
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}

}
