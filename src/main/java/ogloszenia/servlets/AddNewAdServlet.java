package ogloszenia.servlets;

import ogloszenia.model.Advertisement;
import ogloszenia.model.CATEGORY;
import ogloszenia.model.User;
import ogloszenia.repository.AdvertisementRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by RENT on 2017-07-31.
 */
public class AddNewAdServlet extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId=0;
        userId =(Integer) req.getSession().getAttribute("userId");

        if(userId == null) {
            resp.sendRedirect("login.jsp");
        }else {

            String title;
            BigDecimal price = BigDecimal.ZERO;
            String description;
            String location;
            CATEGORY category = null;


            title = req.getParameter("title");
            try {
                price = new BigDecimal(req.getParameter("price"));
                category = CATEGORY.valueOf(req.getParameter("category"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            description = req.getParameter("description");
            location = req.getParameter("location");

            if (isValid(title, price, description, location)) {
                PrintWriter writer = resp.getWriter();
                writer.write("blad!");
            }

            Advertisement newAd = new Advertisement(title, price, description, location, category);
            AdvertisementRepository.persist(newAd, userId);

            resp.sendRedirect("products.jsp?category=" + newAd.getCategory());
        }


    }

    private boolean isValid(String title, BigDecimal price, String description, String location) {
        return title.isEmpty() || description.isEmpty() || location.isEmpty() || price.compareTo(BigDecimal.ZERO) == -1;
    }
}
