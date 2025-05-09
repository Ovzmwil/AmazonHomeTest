package steps.hooks;

import static utils.DriverFactory.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import steps.TestContext;

public class Hooks {
	
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }
	
	@Before
    public void setUp() {
		WebDriver driver = getDriver();
        context.setDriver(driver);
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) context.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "screenshot");

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = "screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
            try {
                Files.createDirectories(Path.of("screenshots"));
                Files.write(Path.of(filename), screenshot);
                System.out.println("Screenshot salvo: " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        quitDriver();
    }
}
