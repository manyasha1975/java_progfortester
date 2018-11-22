package ru.mytest.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.mytest.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class); //organize logs

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @BeforeMethod (alwaysRun = true)
  public void logTestStart(Method m, Object[] p) {
    //Method m will have information about method, which run it current moment, Object[] p - information about parameters
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p)); //Arrays.asList(p) to get information in convenient view
  }

  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m) {  //Method m will have information about method, which run it current moment
    logger.info("Stop test " + m.getName());
  }
}
