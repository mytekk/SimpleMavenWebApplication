package ogloszenia.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

/*
 * Wiadomosc
    id ogloszenia
    id nadawca
    id odbiorca
    tresc
    data
 */

@Entity
public class Conversation {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false)
    private Advertisement advertisement;

    @JoinColumn(nullable=false)
    @ManyToOne
    private User conversationSender;

    @JoinColumn(nullable=false)
    @ManyToOne
    private User conversationReceiver;

    @OneToMany(mappedBy = "conversation")
    Set<ConversationMessage> conversationMessages;

    @Column(nullable=false)
    private LocalDate messageDate;

    public Conversation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisementId) {
        this.advertisement = advertisementId;
    }

    public User getConversationSender() {
        return conversationSender;
    }

    public void setConversationSender(User conversationSender) {
        this.conversationSender = conversationSender;
    }

    public User getConversationReceiver() {
        return conversationReceiver;
    }

    public void setConversationReceiver(User conversationReceiver) {
        this.conversationReceiver = conversationReceiver;
    }

    public LocalDate getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDate messageDate) {
        this.messageDate = messageDate;
    }





}