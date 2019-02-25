package szp.rafael.thorntailwebsocketexample.chat;

import java.time.LocalDateTime;

public class ChatMessage {

  private String message;
  private String sender;
  private LocalDateTime timestamp;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "ChatMessage{" +
            "message='" + message + '\'' +
            ", sender='" + sender + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
