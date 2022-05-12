package rtu.mirea.kursach6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "messages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message {  
    @Id
    @SequenceGenerator(name = "messages_messageid_seq", sequenceName = "messages_messageid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_messageid_seq")
    private Integer messageid;
    private String chatcode;
    private String usernam;
    private String content;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getChatcode() {
        return chatcode;
    }

    public void setChatcode(String chatcode) {
        this.chatcode = chatcode;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsernam() {
        return usernam;
    }

    public void setUsernam(String usernam) {
        this.usernam = usernam;
    }
}
