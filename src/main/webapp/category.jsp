<%--
  Created by IntelliJ IDEA.
  User: RENT
  Date: 2017-08-04
  Time: 20:22
  To change this template use File | Settings | File Templates.


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- zaciagamy biblioteke jstl -->
<%@ page import="ogloszenia.repository.*,java.util.List,ogloszenia.model.*" %> <!-- importujemy to c opotrzebujemy, nie trzeba servletow -->

<!-- pobieramy liste kategorii -->
<c:set var="categoryList" value="${CategoryRepository.findAll()}"/>



<c:forEach items="${categoryList}" var="categoryDTO">

    <div class="col-md-3">
                <span class="category-item fa ${categoryDTO.iconName}" style="font-size:20px;" >
                <a href="products.jsp?category=${categoryDTO.category}">${categoryDTO.name}</a>
                </span>
    </div>

</c:forEach>
