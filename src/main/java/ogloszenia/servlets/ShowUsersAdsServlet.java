package ogloszenia.servlets;

import ogloszenia.model.User;
import ogloszenia.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ShowUsersAdsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = null;
        userId = (Integer) req.getSession().getAttribute("userId");

        if (userId != null) {
            Optional<User> user = UserRepository.findById(userId);

            if (user.isPresent()) {
                resp.sendRedirect("my-ads.jsp");
            } else {
                resp.getWriter().write("Nie ma takiego usera w bazie.");
            }
        } else {
            //resp.getWriter().write("Nikt nie jest zalogowany.");
            resp.sendRedirect("login.jsp");
        }

    }
}
