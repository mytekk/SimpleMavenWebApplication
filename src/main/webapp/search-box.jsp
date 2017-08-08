<%--
  Created by IntelliJ IDEA.
  User: mytek
  Date: 2017-08-08
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div>
    <form action="/search" method="post">
        <div class="form-group row col-md-5">
            <input type="text" placeholder="Wpisz nazwę..." name="phrase" class="form-control">
        </div>
        <div class="form-group row col-md-5">
            <input type="text" placeholder="Wpisz miejscowość..." name="location" class="form-control">
        </div>
        <div class="form-group row col-md-2">
            <button type="submit" class="btn btn-classic">Szukaj</button>
        </div>
    </form>
</div>
