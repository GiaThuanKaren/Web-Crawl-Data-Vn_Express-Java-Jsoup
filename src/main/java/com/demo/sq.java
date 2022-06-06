package com.demo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sq")
public class sq extends HttpServlet {
	public void service(HttpServletRequest req , HttpServletResponse res ) throws IOException {
//		HttpSession session  = req.getSession();
//		System.out.println("Session value: "+ session.getAttribute("k"));
		Cookie get[]= req.getCookies();
		for(Cookie a : get) {
			if(a.getValue().equals("val")) {
				System.out.println(a.getValue().equals("val"));
			}
		}
	}
}
