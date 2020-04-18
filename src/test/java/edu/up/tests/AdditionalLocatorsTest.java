package edu.up.tests;

import edu.up.framework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AdditionalLocatorsTest extends TestBase  {

    @Test
    public void ShouldPlayWithSlider() throws InterruptedException {
        // arrange
        // Get driver and enable the slider
        driver.navigate().to("https://devexpress.github.io/testcafe/example/");
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tried-test-cafe")));
        WebElement enableSlider = driver.findElement((By.cssSelector("#tried-test-cafe")));
        enableSlider.click();

        // act
        // Sliders normally use actions to be manipulated
        WebElement slider = driver
                .findElement(By.xpath("//div[@id='slider']/span"));
        Action sliding = (Action) actions.dragAndDropBy(slider, 500, 0).build();
        sliding.perform();
        sliding = (Action) actions.pause(550).build();
        sliding.perform();
        sliding = (Action) actions.dragAndDropBy(slider,-300, 0).build();
        sliding.perform();
    }
}
