	<%@page import="com.demo.MySQLConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.sql.*,com.demo.MySQLConnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<%
	MySQLConnect ms = new MySQLConnect();
	ResultSet rs;
	try {
        String sql = "SELECT * FROM customer";
        rs = ms.executeQuery(sql);
        while (rs.next()) {

            String maNV = rs.getString("customerID");
            String hoNV = rs.getString("customerLast");
            String tenNV = rs.getString("customerFirst");
            String GioiTinh = rs.getString("customerGender");
            String sdt = rs.getString("customerTelephone");
            String addresss = rs.getString("customerAddress");
            String birth = rs.getString("customerBirth");
			out.println("<h1>"+ maNV+ "</h1>");
	
            
        }
        rs.close();
        ms.disConnect();
    } catch (Exception e) {
        out.println("Loi ket noi db");
    }
	%>
	
</body>
</html>