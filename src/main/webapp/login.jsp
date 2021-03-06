<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- zaciagamy biblioteke jstl -->
<%@ page import="ogloszenia.repository.*,java.util.List,ogloszenia.model.*" %>

<!DOCTYPE html>

<head>
    <title>Serwis z ogloszeniami</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="function.js"></script>
</head>

<body>

    <!-- header strony -->
    <div class="container header">
        <c:import url="top-menu.jsp"/>
    </div>

    <!-- wyszukiwarka -->
    <div class="container">
        <c:import url="search-box.jsp"/>
    </div>

    <!-- kontener z tytulem -->
    <div class="container category">
        <div class="col-md-6">
            <h2>Logowanie uzytkownika</h2>
        </div>
    </div>

    <!-- kontener z contentem -->
    <div class="container ad">

        <form action="/login" method="post">
            <div class="form-group">
                <label>email</label>
                <input class="form-control" name="email" type="email" required />
            </div>
            <div class="form-group">
                <label>Password</label>
                <input class="form-control" name="password" type="password" required />
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-classic">Zaloguj sie</button>
            </div>
        </form>


    </div>


    <!-- footer -->
    <footer>
        <div class="container footer form-inline">
            <div class="col-md-3">
                <a href="#">Strona główna</a>
            </div>
            <div class="col-md-3">
                <a href="#">Profil</a>
            </div>
            <div class="col-md-3">
                <a href="#">Aukcje</a>
            </div>
            <div class="col-md-3">
                <a href="#">Kontakt</a>
            </div>
        </div>
    </footer>

</body>
