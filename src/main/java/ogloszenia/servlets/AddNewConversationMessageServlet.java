package ogloszenia.servlets;

import ogloszenia.model.Conversation;
import ogloszenia.model.ConversationMessage;
import ogloszenia.model.User;
import ogloszenia.repository.ConversationMessageRepository;
import ogloszenia.repository.ConversationRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by RENT on 2017-08-01.
 */
public class AddNewConversationMessageServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer conversationId = 0;
        String text = "";
        User messageSender = new User("Romek", "11111", "romek@gmail.com", "Poznan");

        try {
            conversationId = Integer.valueOf(req.getParameter("conversationId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        text = req.getParameter("message");

        //pobieramy konwrsacje
        Optional<Conversation> conversationTmp = ConversationRepository.findById(conversationId);
        if (conversationTmp.isPresent()) {
            Conversation conversation = conversationTmp.get();

            ConversationMessage newMessage = new ConversationMessage(conversation, text, messageSender);

            ConversationMessageRepository.persist(newMessage);

            resp.getWriter().write("wiadomosc zostala wyslana");


        }
    }
}
