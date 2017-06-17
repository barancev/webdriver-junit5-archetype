#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

  protected static URL gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeAll
  public static void loadConfig() throws Throwable {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  };

  @BeforeEach
  public void initDriver() throws Throwable {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
  }
}
