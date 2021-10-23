package sample.junit.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

/**
 * データベースプロパティ
 */
@Slf4j
public class DatabaseProperties {
  private static String ROOT_PATH =
      Thread.currentThread().getContextClassLoader().getResource("").getPath();
  private static String CONFIG_PATH = ROOT_PATH + "database.properties";
  private static Properties properties = new Properties();

  static {
    try {
      properties.load(new FileInputStream(CONFIG_PATH));
    } catch (IOException e) {
      e.printStackTrace();
      log.error(e.getMessage());
    }
  }

  private DatabaseProperties() {}

  protected static String getValue(final String name) {
    String value = properties.getProperty(name);

    if (value == null) {
      log.error("parameter not found: name = {}", name);
      throw new InvalidParameterException();
    }

    return value;
  }
}
