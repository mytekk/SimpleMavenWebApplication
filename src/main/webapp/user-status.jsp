<%--
  Created by IntelliJ IDEA.
  User: mytek
  Date: 2017-08-07
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- zaciagamy biblioteke jstl -->
<%@ page import="ogloszenia.repository.*,java.util.List,ogloszenia.model.*" %>
<%@ page import="java.util.Optional" %>
<!-- importujemy to c opotrzebujemy, nie trzeba servletow -->

<%
    Integer userId = (Integer) request.getSession().getAttribute("userId");
    if (userId != null) {
        Optional<User> user = UserRepository.findById(userId);
        if (user.isPresent()) {
            String nick = user.get().getNick();
            pageContext.setAttribute("nick", nick);

        }
    }
%>

<div>
    <c:if test="${! empty nick}">
        Login: ${nick} <a href="/logout">(wyloguj się)</a>
    </c:if>
    <c:if test="${empty nick}">
        <a href="login.html">Zaloguj się</a>
    </c:if>
</div>
