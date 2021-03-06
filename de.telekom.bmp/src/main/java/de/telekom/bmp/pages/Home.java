package de.telekom.bmp.pages;

import de.telekom.bmp.BmpApplication;
import de.telekom.testframework.selenium.Page;
import de.telekom.testframework.selenium.annotations.Path;
import de.telekom.testframework.selenium.controls.Button;
import de.telekom.testframework.selenium.controls.Text;
import de.telekom.testframework.selenium.controls.TextField;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Daniel
 */
@Singleton
@Path("/home")
public class Home extends Page {

    @Inject
    public Home(BmpApplication app) {
        super(app);
    }

    @Deprecated
    @FindBy(xpath = "//div[@class = 'login']")
    public Button loginBtn;

    @Deprecated
    @FindBy(xpath = "//a[@href='./signup' or contains(text(),'Registrieren')]")
    public Button registerBtn;

    @Deprecated
    @FindBy(xpath = "//li[contains(@class, 'languageToggle')]")
    public Button langToggleBtn;

    @Deprecated
    @FindBy(xpath = "//li[@class='feedbackPanelINFO']")
    public Text feedbackMessage;

    @FindBy(name = "body:footer:describe")
    public TextField bodyFooterDescribe;
}
