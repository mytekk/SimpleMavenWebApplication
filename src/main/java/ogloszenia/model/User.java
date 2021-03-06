package ogloszenia.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

	/*
	 * Uzytkownik
    email
    haslo
    nick
    avatar
    city name
	 */

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true)
    Integer id;

    @Column(nullable=false,unique=true)
    String nick;

    @Column(nullable=false)
    String password;

    @Lob
    byte[] avatar;

    @Column(nullable=false)
    String email;

    @Column(nullable=false)
    String cityName;

    @OneToMany(mappedBy="owner")
    Set<Advertisement> ads;

    @OneToMany(mappedBy="conversationSender")
    Set<Conversation> sendConversations;

    @OneToMany(mappedBy="conversationReceiver")
    Set<Conversation> receivedConversations;

    @ManyToMany(mappedBy = "watchers")
    Set<Advertisement> followedAdvertisements;

    @OneToMany(mappedBy = "author")
    Set<ConversationMessage> conversationMessages;

    public User() {}

    public User(String nick, String password, String email, String cityName) {
        this.nick = nick;
        this.password = password;
        this.email = email;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}