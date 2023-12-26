<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<html>
<head>
    <title>JDBC 연동 테스트 예제</title>
</head>
<body>
    <%
        Connection conn = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "java";
        String password = "java";
        Boolean connect = false;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            connect = true;
            conn.close();
        } catch (Exception e) {
            connect = false;
            e.printStackTrace();
        }
    %>

    <h3>
        <% if (connect) { %>
            연결되었습니다.
        <% } else { %>
            연결에 실패하였습니다.
        <% } %>
    </h3>
</body>
</html>
