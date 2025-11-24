package htw.webtech.test.entity;

import java.time.LocalDateTime;

public class Message {
    private String userName;
    private String message;
    private LocalDateTime timestamp;

    public Message() {}

    public Message(String userName, String message, LocalDateTime timestamp) {
        this.userName = userName;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getter und Setter...
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}