package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends Base {
    public AddContactPage(WebDriver navegador) {
        super(navegador);
    }

        WebElement addMoreData = navegador.findElement(By.id("addmoredata"));
    public AddContactPage pegaTipo(String tipo){
        WebElement campoType = addMoreData.findElement(By.name("type"));
        new Select(campoType).selectByValue(tipo);
        return this;
    }
    public AddContactPage pegaContato(String contato){
        addMoreData.findElement(By.name("contact")).sendKeys(contato);
        return this;
    }
    public MePage adicionarContato(String tipo,String contato){
        addMoreData.findElement(By.linkText("SAVE")).click();
        return new MePage(navegador);

    }
}
