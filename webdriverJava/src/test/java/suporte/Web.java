package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
//    public static final String USERNAME = "seu-username";
//    public static final String AUTOMATE_KEY = "sua-key";
//    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\lucasbarbosa\\Documents\\Chromedrive\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        navegador.get("http://www.juliodelima.com.br/taskit");
        return navegador;

    }


    }
