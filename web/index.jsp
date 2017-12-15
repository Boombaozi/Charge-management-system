<%@ page import="test.utils.datainfo" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试</title>
  </head>
  <body>
<h1>测试</h1>



<jsp:useBean id="aa"class="test.user"></jsp:useBean>


<jsp:getProperty name="aa" property="a"></jsp:getProperty>
  </body>
</html>