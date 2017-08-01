package ogloszenia.model;

import javax.persistence.*;

/**
 * Created by RENT on 2017-08-01.
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

    public ConversationMessage() {
    }

    public ConversationMessage(Conversation conversation, String messageContent, User author) {
        this.conversation = conversation;
        this.messageContent = messageContent;
        this.author = author;
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
}
