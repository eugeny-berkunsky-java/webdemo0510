<%--
  Created by IntelliJ IDEA.
  User: eberk
  Date: 05.10.2020
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <jsp:useBean id="calcBean" type="beans.CalcBean" scope="session"/>
    <p>Sum = ${calcBean.sum}</p>
    <p>Avg = ${calcBean.avg}</p>
    <p>Counter = ${calcBean.counter}</p>
</body>
</html>
