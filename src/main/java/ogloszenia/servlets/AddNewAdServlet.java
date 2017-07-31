package ogloszenia.servlets;

import ogloszenia.model.Advertisement;
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

        String title;
        BigDecimal price = BigDecimal.ZERO;
        String description;
        String location;


        title = req.getParameter("title");
        try {
            price = new BigDecimal(req.getParameter("price"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        description = req.getParameter("description");
        location = req.getParameter("location");

        if (isValid(title, price, description, location)) {
            PrintWriter writer = resp.getWriter();
            writer.write("blad!");
        }

        User owner = new User();
        owner.setCityName("Poznań");
        owner.setEmail("example@com.pl");
        owner.setNick("testUser");
        owner.setPassword("admin");

        Advertisement newAd = new Advertisement(title, price, description, location, owner);
        AdvertisementRepository.persist(newAd);

        PrintWriter writer = resp.getWriter();
        writer.write("ok!");
    }

    private boolean isValid(String title, BigDecimal price, String description, String location) {
        return title.isEmpty() || description.isEmpty() || location.isEmpty() || price.compareTo(BigDecimal.ZERO) == -1;
    }
}
