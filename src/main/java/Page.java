import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Page {
    Connection connection = new Connection();
    public void signIn(String un, String pw) {
        connection.webDriver.manage().window().maximize();
        connection.webDriver.manage().timeouts().implicitlyWait(Duration.of(30, TimeUnit.SECONDS.toChronoUnit()));

        connection.webDriver.get("https://www.demoblaze.com/index.html");
        WebElement log = connection.webDriver.findElement(By.id("signin2"));
        WebElement usernameBar = connection.webDriver.findElement(By.id("sign-username"));
        WebElement passwordBar = connection.webDriver.findElement(By.id("sign-password"));
        WebElement signUpButton = connection.webDriver.findElement(By.xpath(".//div[@id='signInModal']/div[1]/div[1]/div[3]/button[2]"));
        WebElement logInButton = connection.webDriver.findElement(By.id("login2"));
        WebElement logInUsername = connection.webDriver.findElement(By.id("loginusername"));
        WebElement logInPassword = connection.webDriver.findElement(By.id("loginpassword"));
        WebElement logInButtonOther =connection.webDriver.findElement(By.xpath(".//div[@id='logInModal']/div[1]/div[1]/div[3]/button[2]"));
        WebElement laptop = connection.webDriver.findElement(By.xpath(".//div[@id='tbodyid']/div[8]/div[1]/a[1]"));

        log.click();
        usernameBar.sendKeys(un);
        passwordBar.sendKeys(pw);
        signUpButton.click();

        WebDriverWait waito = new WebDriverWait(connection.webDriver,Duration.of(12, ChronoUnit.SECONDS));
        waito.until(ExpectedConditions.alertIsPresent()).accept();

        logInButton.click();
        logInPassword.sendKeys(pw);
        logInUsername.sendKeys(un);
        logInButtonOther.click();

        try{
            laptop.click();}
        catch (StaleElementReferenceException e){
            WebElement laptop1 = connection.webDriver.findElement(By.xpath(".//div[@id='tbodyid']/div[8]/div[1]/a[1]"));
            laptop1.click();
        }


    }

    public void addToCartAndClickCart(){

        WebElement addToCart = connection.webDriver.findElement(By.xpath(".//div[@class='col-sm-12 col-md-6 col-lg-6']/a[1]"));
        WebElement cart  = connection.webDriver.findElement(By.id("cartur"));

        addToCart.click();

        WebDriverWait waito = new WebDriverWait(connection.webDriver,Duration.of(12, ChronoUnit.SECONDS));
        waito.until(ExpectedConditions.alertIsPresent()).accept();

        cart.click();

    }

    public boolean notebookIsPresent(){
        WebElement display = connection.webDriver.findElement(By.xpath(".//tr[@class='success']"));
        return display.isDisplayed();
    }

    public void quit(){
        connection.webDriver.quit();
    }
}
