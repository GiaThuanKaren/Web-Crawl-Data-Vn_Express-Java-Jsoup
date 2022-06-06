package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class AddServlet extends HttpServlet {
	   public  double ConvertPriceToDouble(String price) {
//	        System.out.println(price);
	        double result = 0;// Intiallize value;
	        if (!price.equals("")) {
	            String tmp = price.substring(0, price.indexOf(' '));
	            return Double.parseDouble(tmp);
	        }
	        return result;
	    }

	    public  String ConverQuantitySold(String quantity) {

	        String result = "";
	        if (!quantity.equals("")) {
	            int tmp = quantity.lastIndexOf(' ');
	            return quantity.substring(tmp);
	        }
	        return result;
	    }
	private void ShowJson(JSONObject obj,HttpServletResponse res,int pagenum) {
		 try {
	            Document document = (Document) Jsoup.connect("https://tiki.vn/phu-kien-thoi-trang/c27498?page="+pagenum).get();
//	            System.out.println(document.outerHtml());
	            int i = 0;
	            ArrayList<JSONObject> ds = new ArrayList<JSONObject>();
	            obj.put("Page",pagenum);
	            for (Element ele : document.select(".product-item")) {
	                String DetailProductLink ="https://tiki.vn"+ ele.attr("href");
	                Document detaildoc = Jsoup.connect(DetailProductLink).get();
//	                System.out.println(detaildoc.outerHtml());
	                
	                String quantity = ConverQuantitySold(ele.select(".styles__StyledQtySold-sc-732h27-2.fCfYNm").text());
	                double priceOfficial = ConvertPriceToDouble(ele.select(".price").text());
	                double priceDiscount = ConvertPriceToDouble(ele.select(".price-discount__price").text());
	                String name = ele.select(".name h3").text();
	                String image = ele.select("picture img").attr("src");
//	                System.out.println(name + " " + image + " " + priceOfficial + " " + priceDiscount + " " + quantity);
	                JSONObject getcur = new JSONObject();
	                ByteBuffer byteBuffer = StandardCharsets.US_ASCII.encode(name);

	                String utf8String = new String(byteBuffer.array(), StandardCharsets.US_ASCII);
	                getcur.put("name", name);
	                getcur.put("quantitySold", quantity);
	                getcur.put("priceOfficial", priceOfficial);
	                getcur.put("priceDiscount", priceDiscount);
	                getcur.put("image", image);
//	                DTOJSON tmp = new DTOJSON(quantity, name, image, priceOfficial, priceDiscount);
	                ds.add(getcur);
	            }
//	            obj.put("", ds);
	            System.out.println(ds);
	    		PrintWriter out = res.getWriter();
	    		res.setCharacterEncoding("UTF-8");
//	    		ds.add(obj);
	    		out.println(ds);
	            
//	            System.ot.println(i);
	        } catch (Exception e) {
	            System.out.println("Error" + e);
	        }
	}
	public void service(HttpServletRequest req , HttpServletResponse res ) throws IOException, ServletException {
		int a =Integer.parseInt(req.getParameter("num1")) ;
		int b=Integer.parseInt(req.getParameter("num2")) ;
		System.out.println(a+b);
		req.setAttribute("k", a+b);
		HttpSession session = req.getSession();
		session.setAttribute("k",a+b);
		Cookie cookie = new Cookie("val", a+b+"");
		res.addCookie(cookie);
		JSONObject obj = new JSONObject();
		ShowJson(obj,res,1);

//		res.sendRedirect("sq");
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
	}
}
