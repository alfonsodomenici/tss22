<%-- 
    Document   : users
    Created on : 8 apr 2022, 16:50:24
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>users</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${userstore.all()}" var="user">
                <li><c:out value="${user.lastName}"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
