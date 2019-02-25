package szp.rafael.thorntailwebsocketexample.chat;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.time.LocalDateTime;

@ServerEndpoint(value="/chat", encoders = MessageEncoder.class,decoders = MessageDecoder.class)
public class ChatEndpoint {

  @OnOpen
  public void myOnOpen(Session session) {
    System.out.println("WebSocket opened: " + session.getId());
  }

  @OnMessage
  public ChatMessage receiveMessage(final Session session, final ChatMessage message){
    System.out.println("Message received: "+message.getMessage());
    ChatMessage response = new ChatMessage();
    response.setMessage("You've sent: "+message.getMessage());
    response.setSender("Chat server");
    response.setTimestamp(message.getTimestamp());

    return response;
  }


  @OnClose
  public void myOnClose(CloseReason reason) {
    System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
  }

}
