package core;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class Driver {
    private WebDriver driver;
    private String timeOutString = "30";
    private final int TIMEOUT = Integer.parseInt(timeOutString);

    public Driver() throws MalformedURLException, InterruptedException {
        long threadId = Thread.currentThread().getId();
        this.driver = DriverManager.GetDriver();
    }

    public boolean elementIsPresent(By locator) {
        try {
            if(locator == null)
                return false;

            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    public void takeScreenShot(Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
    public void tearDown() {
        DriverManager.ReleaseDriver();
    }
    public WebElement find(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            //driver.quit();
            throw new NoSuchElementException(
                    "No se ha encontrado ningun elemento web en la ruta indicada: "
                            + locator);
        }
        return element;
    }
    public void waitForElement(By expectedLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(expectedLocator));
    }
    public void click(By locator) {

        find(locator).click();
    }

    public void sendKeys(String text, By locator) {
        find(locator).sendKeys(text);
    }

    public String getVisibleText(By locator) {
        waitForElement(locator);
        return find(locator).getText();
    }
    public void moverMouse(By locator){
        WebElement webElement = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new WebDriverException(
                    "Error inesperado mientras el hilo con id="
                            + Thread.currentThread().getId()
                            + " estaba en espera");
        }
    }
}
