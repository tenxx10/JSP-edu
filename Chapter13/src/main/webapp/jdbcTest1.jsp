<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>JDBC 연동 테스트 예제</title>
</head>
<body>
<b>JDBC 연동 테스트 예제</b>
    <%
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
   /*      String username = "java";
        String password = "java"; */
        
        Boolean connect = false;

     
       
	try {
           
            connect = true;
            
        } catch (Exception e) {
            connect = false;
            e.printStackTrace();
        } 
   
%>
</body>
</html>
