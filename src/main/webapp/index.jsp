<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> <!-- zaciagamy biblioteke jstl -->
<%@ page import="ogloszenia.repository.*,java.util.List,ogloszenia.model.*" %>
<%@ page import="java.util.Optional" %>
<!-- importujemy to c opotrzebujemy, nie trzeba servletow -->

<!-- pobieramy liste kategorii -->
<c:set var="categoryList" value="${CategoryRepository.findAll()}"/>

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

<!DOCTYPE html>

<head>
    <title>Serwis z ogloszeniami</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="function.js"></script>
</head>

<body>

   <!-- header strony -->
    <div class="container header">
        <div class="logo col-md-2">
            <img src="marketlogo.png" alt="brak zdjecia" />
        </div>
        <div class="col-md-6">
        </div>
        <div class="logo col-md-4 menu">
            <div>
                Login:
                    <c:if test="${! empty nick}">
                        ${nick}
                    </c:if>
                    <c:if test="${empty nick}">
                    zaloguj sie
                </c:if>
            </div>

           <div>menu</div>
            <div id="nav-icon1">
                <span></span>
                <span></span>
                <span></span>
            </div>

        </div>
    </div>

    <!-- wyszukiwarka -->
    <div class="container">
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
    </div>

   <!-- kategorie -->
    <div class="container category">
        <c:import url="category.jsp" />
    </div>


   <!-- kontener z contentem -->
    <div class="container ad">

       <!-- pierwsze ogloszenie -->
        <div class="media panel">
            <div class="media-left media-middle">
                <a href="#">
                    <img class="media-object small-object" src="http://blog.caranddriver.com/wp-content/uploads/2016/11/Ford-Mustang-Shelby-GT350-lead.jpg" alt="brak zdjeci">
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">Middle aligned media</h4>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, hic fugiat id illo quod porro quam corporis sint quidem blanditiis quo quas reprehenderit officia! Quibusdam magni ipsa voluptas ullam molestiae.
                <h3 class="price">
                    50.000 zł
                </h3>
            </div>
        </div>

       <!-- drugie ogloszenie -->
        <div class="media panel">
            <div class="media-left media-middle">
                <a href="#">
                    <img class="media-object small-object" src="http://blog.caranddriver.com/wp-content/uploads/2016/11/Ford-Mustang-Shelby-GT350-lead.jpg" alt="brak zdjeci">
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">Middle aligned media</h4>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, hic fugiat id illo quod porro quam corporis sint quidem blanditiis quo quas reprehenderit officia! Quibusdam magni ipsa voluptas ullam molestiae.
                <h3 class="price">
                    50.000 zł
                </h3>
            </div>
        </div>

       <!-- trzecie ogloszenie -->
        <div class="media panel">
            <div class="media-left media-middle">
                <a href="#">
                    <img class="media-object small-object" src="http://blog.caranddriver.com/wp-content/uploads/2016/11/Ford-Mustang-Shelby-GT350-lead.jpg" alt="brak zdjeci">
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">Middle aligned media</h4>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, hic fugiat id illo quod porro quam corporis sint quidem blanditiis quo quas reprehenderit officia! Quibusdam magni ipsa voluptas ullam molestiae.
                <h3 class="price">
                    50.000 zł
                </h3>
            </div>
        </div>

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
