package szp.rafael.thorntailwebsocketexample.chat;

import javax.websocket.Decoder;
import java.io.StringReader;
import java.time.LocalDateTime;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<ChatMessage>{

  @Override
  public void init(final EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public ChatMessage decode(final String textMessage) throws DecodeException {
    ChatMessage chatMessage = new ChatMessage();
    JsonObject obj = Json.createReader(new StringReader(textMessage))
            .readObject();
    chatMessage.setMessage(obj.getString("message"));
    chatMessage.setSender(obj.getString("sender"));
    chatMessage.setTimestamp(LocalDateTime.now());
    return chatMessage;
  }

  @Override
  public boolean willDecode(final String s) {
    return true;
  }

}
