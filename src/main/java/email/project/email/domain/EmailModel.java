package email.project.email.domain;


import email.project.email.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "emails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailID;

    private String emailTo;

    private  String emailFrom;

    private  String emailSubject;

    @Column(columnDefinition = "TEXT")
    private String emailBody;
    private LocalDateTime createdAt;
    private EmailStatus statusEmail;


    public UUID getEmailID() {
        return emailID;
    }

    public void setEmailID(UUID emailID) {
        this.emailID = emailID;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public EmailStatus getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(EmailStatus statusEmail) {
        this.statusEmail = statusEmail;
    }
}
