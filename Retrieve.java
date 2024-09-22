package com.movies.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movies.model.Movies;
import com.movies.model1.Longin;
import com.movies.model3.Organization;
import com.movies.service.MovieService;


@Controller
public class Retrieve {
	
	String user  ;
	String obj;
static	String admi;
	String add;
	String uid;
//	String w;
	@Autowired
   
	MovieService service;
	@RequestMapping("/retrieve")
	
	public ModelAndView insertData(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
			System.out.println("enters in servlet");
		PrintWriter out=  res.getWriter();
		  ModelAndView mav=new ModelAndView();
		  user=req.getParameter("a");
		  add=req.getParameter("o");
//		  w=req.getParameter("w");
		  Configuration cfg=new Configuration().configure().addAnnotatedClass(Longin.class);
			SessionFactory sf=cfg.buildSessionFactory();
			Session sess=sf.openSession();
			Transaction tr=sess.beginTransaction();
			NativeQuery query = sess.createNativeQuery("SELECT * from Longin  ", Longin.class);
			List list=query.list();
			Configuration cfg3=new Configuration().configure().addAnnotatedClass(Organization.class);
			SessionFactory sf3=cfg3.buildSessionFactory();
			Session sess3=sf3.openSession();
			Transaction tr3=sess3.beginTransaction();
			NativeQuery query3 = sess3.createNativeQuery("SELECT * from Organization  ", Organization.class);

			java.util.List list3 = query3.list();
			  
			for(Object el1:list3)
			{
				 admi=((Organization)el1).getAdmin();
			}
			for(Object el:list)
			{
				
				obj =((Longin) el).getPassword(); 
				
				uid =((Longin) el).getUId();
	            
		  if(user.contains(obj)&&add.contains(admi))
		  {
			  Configuration cfg1=new Configuration().configure().addAnnotatedClass(Movies.class);
				SessionFactory sf1=cfg1.buildSessionFactory();
				Session sess1=sf1.openSession();
				Transaction tr1=sess1.beginTransaction();
				NativeQuery query1 = sess1.createNativeQuery("SELECT * from movies  ", Movies.class);

				java.util.List list1 = query1.list();

				
				
				
				

				req.setAttribute("list1", list1);
			  RequestDispatcher dis=req.getRequestDispatcher("/admin.jsp");
				dis.include(req, res);
				return null;
		  }
		  else if(user.contains(obj)&&add.contains(uid))
		  {
		Configuration cfg1=new Configuration().configure().addAnnotatedClass(Movies.class);
		SessionFactory sf1=cfg1.buildSessionFactory();
		Session sess1=sf1.openSession();
		Transaction tr1=sess1.beginTransaction();
		NativeQuery query1 = sess1.createNativeQuery("SELECT * from movies  ", Movies.class);

		java.util.List list1 = query1.list();

		
		
		
		

		req.setAttribute("list1", list1);
		RequestDispatcher dis=req.getRequestDispatcher("/user.jsp");
		dis.include(req, res);
		return null;
		  }
		  else
			  out.println("Increcte Password");
			}
		return null;
		
		
		
	}
	

}