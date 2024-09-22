package com.movies.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.movies.model.Movies;
import com.movies.model.bank.Account;
import com.movies.service.MovieService;
@Controller
public class Booking {
	Movies m;
	int otp;
	String Name;
	int seat;
	double bal1;
	Account a1;
	Screen1 s1;

	String sc;
	@Autowired

	MovieService service;
	@RequestMapping("/insert1")

	public ModelAndView insertData(HttpServletRequest req,HttpServletResponse res,Account a1,Screen1 s1) throws IOException, ServletException {
		PrintWriter out=  res.getWriter();
		ModelAndView mav=new ModelAndView();
		int a=Integer.parseInt(req.getParameter("a"));
		seat=Integer.parseInt(req.getParameter("b"));
		sc=req.getParameter("rc");

		//		int x=Integer.parseInt(req.getParameter("lang"));

		Configuration cfg=new Configuration().configure().addAnnotatedClass(Movies.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		NativeQuery query = sess.createNativeQuery("SELECT * from movies  ", Movies.class);


		java.util.List list = query.list();


		Object obj=list.get(a);



		for (Object ele : list) {

			if(ele.equals(obj) &&seats.getSeats()>seat &&sc.equalsIgnoreCase("1"))
			{
				Name = ((Movies) ele).getmName();
				bal1 = ((Movies) ele).getmPrice()*seat+seat*Screen1.getScreen();






				RequestDispatcher dis=req.getRequestDispatcher("/mobile.jsp");
				dis.include(req, res);






			}
			else if(ele.equals(obj) &&seats.getSeats()>seat &&sc.equalsIgnoreCase("2"))
			{

				Name = ((Movies) ele).getmName();
				bal1 = ((Movies) ele).getmPrice()*seat+seat*Screen2.getScreen2();



				RequestDispatcher dis=req.getRequestDispatcher("/mobile.jsp");
				dis.include(req, res);




			}


		}






		return null;
	}

	@RequestMapping("/mobile")
	public ModelAndView mobile(HttpServletRequest req,HttpServletResponse res,Account a1,Screen1 s1) throws IOException, ServletException {
		PrintWriter out=  res.getWriter();
		long n=Long.parseLong(req.getParameter("n"));
		if(n==n)
		{
			otp= (int) Math.floor(Math.random()*n);
			otp=otp/10000;
			req.setAttribute("otp", otp);
			RequestDispatcher dis=req.getRequestDispatcher("/otp.jsp");
			dis.include(req, res);
		}
		return null;

	}
	@RequestMapping("/otp")

	public ModelAndView otp(HttpServletRequest req,HttpServletResponse res,Account a1,Screen1 s1) throws IOException, ServletException {
		PrintWriter out=  res.getWriter();
		int a=Integer.parseInt(req.getParameter("k"));
		if(a==otp)
		{
			RequestDispatcher dis=req.getRequestDispatcher("/pin.jsp");
			dis.include(req, res);




		}
		else
			out.println("Invalid OTP please Enter valid OTP");

		return null;

	}
	@RequestMapping("/pin")

	public ModelAndView Payment(HttpServletRequest req,HttpServletResponse res,Account a1,Screen1 s1) throws IOException, ServletException {
		PrintWriter out=  res.getWriter();
		int a=Integer.parseInt(req.getParameter("s"));
		Configuration cfg6=new Configuration().configure().addAnnotatedClass(Account.class);
		SessionFactory sf6=cfg6.buildSessionFactory();
		Session sess6=sf6.openSession();
		Transaction tr6=sess6.beginTransaction();
		NativeQuery query6=sess6.createNativeQuery("select*from account",Account.class);
		List list6=	query6.list();
		for(Object pn:list6)
		{

			Object ob=((Account)pn).getPin();

			Object id=((Account)pn).getId();
			double amount =((Account)pn).getBal();
			if(ob.equals(a))
			{
              

				double total=amount-bal1;

				
				
			Account Account=	sess6.load(Account.class, (Serializable) id);
			NativeQuery que=sess6.createNativeQuery("	update Account set bal = "+total+" where id="+id	);
			
			
			 Account.setBal(total);
			 que.executeUpdate();

			tr6.commit();
			sess6.close();

				if(sc.equalsIgnoreCase("1"))
				{

					Object obj=(Name+" movie Successfully booked in Screen1 "+"Total amount for  "+seat+" seats is:"+bal1);
					req.setAttribute("con", obj);
					RequestDispatcher dis=req.getRequestDispatcher("/Feedback.jsp");
					dis.include(req, res);
				}
				else if(sc.equalsIgnoreCase("2"))
				{
					Object obj=(Name+" movie Successfully booked in Screen2 "+"Total amout for  "+seat+" seats is:"+bal1);
					req.setAttribute("con", obj);
					RequestDispatcher dis=req.getRequestDispatcher("/Feedback.jsp");
					dis.include(req, res);
				}
			}
			else
				out.println("Increcte Pin");
		}
		return null;
	}

}
