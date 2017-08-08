package ogloszenia.servlets;

import ogloszenia.model.Advertisement;
import ogloszenia.repository.AdvertisementRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by RENT on 2017-08-02.
 */
public class SearchAdServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String location;
        String phrase;

        location = req.getParameter("location");
        phrase = req.getParameter("phrase");

        //jesli phrase jest null, to zamieniamy ją na pusty lancuch, bo nulla nie mozna przeslac w url-u do strony jsp
        phrase = (phrase == null) ? "" : phrase;

        if (location == null || location.isEmpty()) { //location moze byc puste, wtedy wyszukujemy tylko po phrase. Tutaj byc moze przeslemy pusty lancuch (patrz wyzej), ale wtedy po stornie jsp wypiszemy odpowiedni komunukat
            resp.sendRedirect("search-results.jsp?phrase=" + phrase);
        } else {
            resp.sendRedirect("search-results.jsp?phrase=" + phrase + "&location=" + location);
        }

    }
}
