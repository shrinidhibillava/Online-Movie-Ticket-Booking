package com.movies.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import com.movies.model.Accounts;
import com.movies.model.Movies;
import com.movies.service.MovieService;

@Controller
public class DeleteController {
	 Movies m;
	 double total;
	 Accounts a1;
	@Autowired
	   
	MovieService service;
	@RequestMapping("/delete")
	
	public ModelAndView insertData(HttpServletRequest req,HttpServletResponse res,Accounts a1) throws IOException, ServletException {
		 PrintWriter out=res.getWriter();
		  ModelAndView mav=new ModelAndView();
		  int a=Integer.parseInt(req.getParameter("a"));

		Configuration cfg=new Configuration().configure().addAnnotatedClass(Movies.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();

		NativeQuery query = sess.createNativeQuery("SELECT * from movies  "
				 , Movies.class);
		List list=query.list();
		    
		
		for(Object ele:list)
		{
			Object obj=	((Movies)ele).getmId();
			out.println(ele);
		if(obj.equals(a) )
		{
			out.println();
			out.println("Deleted Movie "+ele);
		  sess.delete(ele);
		  
		tr.commit();
		sess.close();
		}
		}
		

			
			
		
			

		return null;
		}
    
}