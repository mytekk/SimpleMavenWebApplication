package ogloszenia.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by RENT on 2017-08-01.
 */

/**
 * Wiadomość - pojedyncza wiadomosc przypisana o danej konwersacji
 * id
 * id konwersacji (caly obiekt)
 * text
 * autor (autorem bedzie albo nadawca konwersacji albo odbiorca konwesacji: jedna z tym dwoch osob)
 */

@Entity
public class ConversationMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)  //jesli przy dodawaniu nowej wiadomosci konwersacja nie bedzie istniala, to najpierw ja doda, a dopiero potem doda wiadomosc
    @JoinColumn
    Conversation conversation;

    @Column(nullable=false)
    private String messageContent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    User author;

    @Column(nullable = false)
    LocalDate createDate;

    public ConversationMessage() {
    }

    public ConversationMessage(Conversation conversation, String messageContent) {
        this.conversation = conversation;
        this.messageContent = messageContent;
        this.createDate = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
