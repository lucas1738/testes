package tests;

import static org.junit.Assert.*;

import com.sun.jna.platform.win32.OaIdl;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

//
//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")
public class informacoesUsuarioTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lucasbarbosa\\Documents\\Chromedrive\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navegador.manage().window().maximize();

        navegador.get("http://www.juliodelima.com.br/taskit");

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){


        //clicar no link que possui o nome Sign in
        WebElement linkSingIn = navegador.findElement(By.linkText("Sign in"));
        linkSingIn.click();


        //identificando o forumulário de login in

        WebElement signInBox = navegador.findElement(By.id("signinbox"));

        //digitar "julio001" no campo name "login" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("login")).sendKeys("julio001");

        //digitar "123456" no campo name "password" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("password")).sendKeys("123456");

        //clicar no limk com texto "SIGN IN" (em maiúsculo porque é o que o usuário vê
        navegador.findElement(By.linkText("SIGN IN")).click();

        //validar que dentro do elemento com class "me" possui ou está o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();


        assertEquals("Hi, Julio",textoNoElementoMe);

        //fechar o navegador


    } @Test
    public void testCadastrarTelefone(@Param(name="tipo")String tipo, @Param(name="contato")String
                                      contato, @Param(name="mensagem")String mensagemEsperada){


        //clicar no link que possui o nome Sign in
        WebElement linkSingIn = navegador.findElement(By.linkText("Sign in"));
        linkSingIn.click();


        //identificando o forumulário de login in

        WebElement signInBox = navegador.findElement(By.id("signinbox"));

        //digitar "julio001" no campo name "login" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("login")).sendKeys("julio001");

        //digitar "123456" no campo name "password" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("password")).sendKeys("123456");

        //clicar no limk com texto "SIGN IN" (em maiúsculo porque é o que o usuário vê
        navegador.findElement(By.linkText("SIGN IN")).click();

        //validar que dentro do elemento com class "me" possui ou está o texto "Hi, Julio"
         navegador.findElement(By.className("me")).click();

        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


        WebElement moreData = navegador.findElement(By.id("moredata"));

        Actions act = new Actions(navegador);
        act.moveToElement(moreData.findElement(By.className("modal-trigger"))).click().build().perform();

        WebElement addMoreData = navegador.findElement(By.id("addmoredata"));
       WebElement campoType = addMoreData.findElement(By.name("type"));
       new Select(campoType).selectByValue(tipo);
       //selectByIndex -> primeiro, segundo, terceiro
       //selectByVisibleText -> texto que aparece pro usuário

       addMoreData.findElement(By.name("contact")).sendKeys(contato);
       addMoreData.findElement(By.linkText("SAVE")).click();

//        Actions act = new Actions(navegador);
//        act.moveToElement(navegador.findElement(By.xpath("//span[contains(text(),'9123456')]/../a"))).click().build().perform();
//        Alert alert= navegador.switchTo().alert();
//        alert.accept();

//        navegador.findElement(By.xpath("//span[contains(text(),'9123456789')]/../a")).click();
//
       WebElement toast = navegador.findElement(By.id("toast-container"));
       String toastMessage = toast.getText();
       assertEquals(mensagemEsperada,toastMessage);
//       assertEquals("Rest in peace, dear phone!",toastMessage);




        //fechar o navegador


    }
    @Test
    public void testDeletarTelefone(){


        //clicar no link que possui o nome Sign in
        WebElement linkSingIn = navegador.findElement(By.linkText("Sign in"));
        linkSingIn.click();


        //identificando o forumulário de login in

        WebElement signInBox = navegador.findElement(By.id("signinbox"));

        //digitar "julio001" no campo name "login" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("login")).sendKeys("julio001");

        //digitar "123456" no campo name "password" que está dentro do formulário de id "signinbox"
        signInBox.findElement(By.name("password")).sendKeys("123456");

        //clicar no limk com texto "SIGN IN" (em maiúsculo porque é o que o usuário vê
        navegador.findElement(By.linkText("SIGN IN")).click();

        //validar que dentro do elemento com class "me" possui ou está o texto "Hi, Julio"
         navegador.findElement(By.className("me")).click();

        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


//        WebElement moreData = navegador.findElement(By.id("moredata"));
//        moreData.findElement(By.className("modal-trigger")).click();
//        WebElement addMoreData = navegador.findElement(By.id("addmoredata"));
//       WebElement campoType = addMoreData.findElement(By.name("type"));
//       new Select(campoType).selectByValue("phone");
//       addMoreData.findElement(By.name("contact")).sendKeys("+55 9123456789");
//       addMoreData.findElement(By.linkText("SAVE")).click();

        Actions act = new Actions(navegador);
        act.moveToElement(navegador.findElement(By.xpath("//ul[@class=\"collection\"]/li[2]/a"))).click().build().perform();
        Alert alert= navegador.switchTo().alert();
        alert.accept();
//        navegador.findElement(By.xpath("//span[contains(text(),'9123456789')]/../a")).click();


//
       WebElement toast = navegador.findElement(By.id("toast-container"));
       String toastMessage = toast.getText();
       assertEquals("Rest in peace, dear phone!",toastMessage);

       String screenshotArquivo = "C:\\Users\\lucasbarbosa\\Documents\\A nova\\testes\\FOTOS_TESTES\\"
               + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";

        Screenshot.tirar(navegador, screenshotArquivo );
//       assertEquals("Your contact has been added!",toastMessage);


        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(toast));

        navegador.findElement(By.linkText("Logout")).click();


        //fechar o navegador


    }

//    @Test
//    public void testAutomatizaDeletarTelefone() {
//        int i = 0;
//        for (i=0;i<5;i++){
//            testDeletarTelefone();
//            tearDown();
//        }
//
//    }

//    @Test
//    public void test2(){
//
//
//        //clicar no link que possui o nome Sign in
//        WebElement linkSingIn = navegador.findElement(By.linkText("Sign in"));
//        linkSingIn.click();
//
//
//        //identificando o forumulário de login in
//
//        WebElement signInBox = navegador.findElement(By.id("signinbox"));
//
//        //digitar "julio001" no campo name "login" que está dentro do formulário de id "signinbox"
//        signInBox.findElement(By.name("login")).sendKeys("julio002");
//
//        //digitar "123456" no campo name "password" que está dentro do formulário de id "signinbox"
//        signInBox.findElement(By.name("password")).sendKeys("654321");
//
//        //clicar no limk com texto "SIGN IN" (em maiúsculo porque é o que o usuário vê
//        navegador.findElement(By.linkText("SIGN IN")).click();
//
//        //validar que dentro do elemento com class "me" possui ou está o texto "Hi, Julio"
//        WebElement me = navegador.findElement(By.className("me"));
//        String textoNoElementoMe = me.getText();
//
//
//        assertEquals("Hi, Julio",textoNoElementoMe);
//
//        //fechar o navegador
//
////    }


    @After
    public void tearDown(){
        navegador.close();
    }

}
