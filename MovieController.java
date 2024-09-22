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
import com.movies.model.bank.Account;
import com.movies.model1.Longin;
import com.movies.model3.Organization;
import com.movies.service.MovieService;


@Controller
public class MovieController {
	Longin u;
	@Autowired

	MovieService sarvice;
	@RequestMapping("/insert")

	public ModelAndView insertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int price=Integer.parseInt(req.getParameter("price"));
		String lang=req.getParameter("lang");
		String status=sarvice.insertMovie(id,name, price,lang);
		if(1==1)
		{
			ModelAndView mav=new ModelAndView();
			mav.setViewName("output.jsp");
			mav.addObject("output",status );

			out.println("MOvie Addede Sucessfully");

		}
		return null;

	}

	@RequestMapping("/insertu")

	public ModelAndView UinsertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();


		String name=req.getParameter("name");
		String uid=req.getParameter("u");
		String psw=req.getParameter("p");
		String stat=sarvice.insertUser(name, uid,psw);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",stat );
		out.println("Acount Sucessfully created");

		return null;

	}

	@RequestMapping("/feedback")

	public ModelAndView FinsertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();



		String feed=req.getParameter("u");
		String rate=req.getParameter("m");
		String stat=sarvice.insertFeedback(rate, feed);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",stat );
		out.println("Thank You For rating ");



		return null;

	}
	@RequestMapping("/insertA")

	public ModelAndView AinsertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();


		String name=req.getParameter("s");
		String uid=req.getParameter("n");
		String psw=req.getParameter("k");
		String empid=req.getParameter("tr");
		String stat=sarvice.insertAser(name, uid,psw,empid);
		 

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",stat );
		out.println("Acount Sucessfully created");

		return null;

	}
	
	String GSTN;
   	@RequestMapping("/insertAR")

	public ModelAndView ArinsertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();


		String TheaterNameAndAdress=req.getParameter("bn");
		String adminPassword=req.getParameter("cn");
		String GSTNUMBER=req.getParameter("dn");
		
		Configuration cfg1=new Configuration().configure().addAnnotatedClass(Organization.class);
		SessionFactory sf1=cfg1.buildSessionFactory();
		Session sess1=sf1.openSession();
		Transaction tr1=sess1.beginTransaction();
		NativeQuery query1 = sess1.createNativeQuery("SELECT * from Organization  ", Organization.class);

		java.util.List list1 = query1.list();
		  
		for(Object el1:list1)
		{
			 GSTN=((Organization)el1).getGSTNUMBER();
		}

		
		 if(GSTN==null)
		 {
			   
				String stat4=sarvice.insertArser(TheaterNameAndAdress, adminPassword,GSTNUMBER);

				ModelAndView mav=new ModelAndView();
				mav.setViewName("output.jsp");
				mav.addObject("output",stat4 );
				out.println("Acount Sucessfully created");
		 }
		 else
		 out.println("You have already account");
		 for(Object ele:list1)
		 {
			 out.println(ele); 
		 }



		return null;

	}
   	@RequestMapping("/insertBank")

	public ModelAndView BankinsertData(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();


		String name=req.getParameter("name");
		long accn=Long.parseLong(req.getParameter("acc"));
		int pin=Integer.parseInt(req.getParameter("pin"));
		double bal=Double.parseDouble(req.getParameter("bal"));
		String stat=sarvice.insertDitails(name, accn, pin, bal);
		 

		ModelAndView mav=new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("output",stat );
		out.println("Acount Sucessfully created");

		return null;

	}
   	@RequestMapping("/diposite")

	public ModelAndView BankDiposite(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=  res.getWriter();


		long acc=Long.parseLong(req.getParameter("acc"));
		double bal=Double.parseDouble(req.getParameter("bal"));
		int a=Integer.parseInt(req.getParameter("pin"));
		Configuration cfg6=new Configuration().configure().addAnnotatedClass(Account.class);
		SessionFactory sf6=cfg6.buildSessionFactory();
		Session sess6=sf6.openSession();
		Transaction tr6=sess6.beginTransaction();
		NativeQuery query6=sess6.createNativeQuery("select*from account",Account.class);
		List list6=	query6.list();
		for(Object pn:list6)
		{

			Object ob=((Account)pn).getPin();
			Object ac=((Account)pn).getAccno();
			Object id=((Account)pn).getId();
			double amount =((Account)pn).getBal();
			if(ob.equals(a)&&ac.equals(acc))
			{
              

				double total=amount+bal;

		
		Account Account=	sess6.load(Account.class, 41);
		NativeQuery que=sess6.createNativeQuery("	update Account set bal = "+total+" where id="+id	);
		
		
		 Account.setBal(total);
		 que.executeUpdate();
//		sess6.saveOrUpdate(Account);	

//		sess.createQuery((CriteriaQuery<T>) que);
		tr6.commit();
		sess6.close();

			}
		
		}	
		return null;
   	
   	}
	

}