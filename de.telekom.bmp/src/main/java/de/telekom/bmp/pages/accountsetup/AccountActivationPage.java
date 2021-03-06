package de.telekom.bmp.pages.accountsetup;

import de.telekom.bmp.BmpApplication;
import de.telekom.testframework.selenium.Page;
import de.telekom.testframework.selenium.annotations.Path;
import de.telekom.testframework.selenium.controls.Button;
import de.telekom.testframework.selenium.controls.CheckBox;
import de.telekom.testframework.selenium.controls.RadioGroup;
import de.telekom.testframework.selenium.controls.Select;
import de.telekom.testframework.selenium.controls.TextField;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Mathias Herkt
 */
@Singleton
@Path("/accountSetup")
public class AccountActivationPage extends Page {

    @Inject
    public AccountActivationPage(BmpApplication application) {
        super(application);
    }

    @FindBy(name = "firstName")
    public TextField firstName;

    @FindBy(name = "companySetupForm:companyNameBorder:companyNameBorder_body:companyName")
    public TextField companyName;

    @FindBy(name = "lastName")
    public TextField lastName;

    @FindBy(name = "passwordBorder:passwordBorder_body:password")
    public TextField password;

    @FindBy(name = "confirmBorder:confirmBorder_body:confirmPassword")
    public TextField confirmPassword;

    @FindBy(name = "companySetupForm:requiredPhoneNumber:requiredPhoneNumber_body:phoneNumber")
    public TextField phoneNumber;

    @FindBy(name = "companySetupForm:sizeRadioGroup")
    public RadioGroup companySize;

    @FindBy(name = "companySetupForm:inputIndustry")
    public Select industry;

    @FindBy(name = "marketingPanelContainer:emailMarketingCheckbox")
    public CheckBox emailMarketing;

    @FindBy(name = "marketingPanelContainer:dataPermissionCheckbox")
    public CheckBox dataPermission;

    @FindBy(name = "companySetupForm:termsPanel:termsAndConditionBorder:termsAndConditionBorder_body:termsAndCondition")
    public CheckBox termsAndCondition;

    @FindBy(name = "noStepActivateButton")
    public Button createAccountBtn;
}
