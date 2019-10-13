package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MePage extends Base {
    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarAbaMoreData(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clicarBotaoAddMoreData(){
        WebElement moreData = navegador.findElement(By.id("moredata"));

        Actions act = new Actions(navegador);
        act.moveToElement(moreData.findElement(By.className("modal-trigger"))).click().build().perform();
        return new AddContactPage(navegador);
    }
}
