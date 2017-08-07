<%--
  Created by IntelliJ IDEA.
  User: mytek
  Date: 2017-08-07
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<div class="logo col-md-2">
    <img src="marketlogo.png" alt="brak zdjecia" />
</div>
<div class="col-md-6">
</div>
<div class="logo col-md-4 menu">

    <div>
        <c:if test="${! empty nick}">
            Login: ${nick} <a href="/logout">(wyloguj się)</a>
        </c:if>
        <c:if test="${empty nick}">
            <a href="login.jsp">Zaloguj się</a> / <a href="dodawanie-uzytkownika.jsp">Zarejestruj się</a>
        </c:if>
    </div>

    <%--<div>menu</div>--%>
    <%--<div id="nav-icon1">--%>
        <%--<span></span>--%>
        <%--<span></span>--%>
        <%--<span></span>--%>
    <%--</div>--%>

    <div class="dropdown">
        <button onclick="myFunction()" class="dropbtn">Menu</button>
        <div id="myDropdown" class="dropdown-content">
            <a href="dodawanie_ogloszenia.jsp">Dodaj ogloszenie</a>
        </div>
    </div>

</div>



