package lab4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    ObjectMapper jsonMapper = new ObjectMapper();
    XmlMapper xmlMapper = new XmlMapper();

    try {
      User user = jsonMapper.readValue(new File("input.json"), User.class);
      System.out.println("Deserialized User from JSON: " + user.getUsername());

      xmlMapper.writeValue(new File("output.xml"), user);
      System.out.println("User saved to output.xml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
