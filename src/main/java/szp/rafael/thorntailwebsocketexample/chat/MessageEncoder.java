package szp.rafael.thorntailwebsocketexample.chat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<ChatMessage> {
  @Override
  public String encode(ChatMessage chatMessage) throws EncodeException {
    return Json.createObjectBuilder()
            .add("message", chatMessage.getMessage())
            .add("sender", chatMessage.getSender())
            .add("timestamp", chatMessage.getTimestamp().toString()).build()
            .toString();
  }

  @Override
  public void init(EndpointConfig config) {

  }

  @Override
  public void destroy() {

  }
}
