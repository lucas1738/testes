package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage extends Base {
    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage pegaLogin(String login){
        //digitar "julio001" no campo name "login" que está dentro do formulário de id "signinbox"
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }
    public LoginFormPage pegaSenha(String senha){
       navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);
        return this;
    }

    public SecretaPage clicarSignIn() {
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin(String login, String senha){
        return pegaLogin(login)
                .pegaSenha(senha)
                .clicarSignIn();

    }
}
