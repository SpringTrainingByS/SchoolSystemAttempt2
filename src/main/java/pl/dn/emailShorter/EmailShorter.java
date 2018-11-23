package pl.dn.emailShorter;

import java.text.ParseException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailShorter {

    private long emailId;
    private String content;
    private Date creationTime;
    private String topic;
    private String firstName;
    private String lastName;
    private String email;

    public EmailShorter(Object[] queryResult) {
        this.emailId = Long.parseLong(queryResult[0].toString());
        this.content = queryResult[1].toString();
        try {
            this.creationTime = new SimpleDateFormat("yyyyMMdd").parse(queryResult[2].toString());
        }
        catch (ParseException e) { }

        this.topic = queryResult[3].toString();
        this.firstName = queryResult[4].toString();
        this.lastName = queryResult[5].toString();
        this.email = queryResult[6].toString();
    }

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
