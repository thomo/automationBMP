package de.telekom.bmp.pages.account;

import de.telekom.bmp.BmpApplication;
import de.telekom.testframework.selenium.Page;
import de.telekom.testframework.selenium.annotations.Path;
import de.telekom.testframework.selenium.annotations.UseParent;
import de.telekom.testframework.selenium.controls.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Tatiana
 */

@Singleton
@Path("/account/home")
public class Dashboard extends Page {

    @Inject
    public Dashboard(BmpApplication app) {
        super(app);
    } 
    
        
    @FindBy(xpath = ".//div[contains(@class, 'loadMore')]")
    public Link loadMoreBtn;
    
    @FindBy(xpath = ".//div[@id='quickLinks']")
    Link quickLinks;
    
    @FindBy(xpath = ".//a[@class='inviteMore']")
    @UseParent("quickLinks")
    public Link inviteUsersLnk;
        
    @FindBy(xpath = ".//a[contains(@href, 'assign')]")
    @UseParent("quickLinks")
    public Link assignLnk;
    
    @FindBy(xpath = ".//a[contains(@href, 'apps')]")
    @UseParent("quickLinks")
    public Link upgradeLnk;
    
    @FindBy(xpath = ".//a[contains(@href, 'bills?selectedPanel=BILLING_INFO')]")
    @UseParent("quickLinks")
    public Link billingInfoLnk;
    
    @FindBy(xpath = ".//a[@href='./bills']")
    @UseParent("quickLinks")
    public Link billsLnk;
    
    @FindBy(xpath = ".//div[@id='singleUserInvite']")
    Form singleInvite;
    
    @FindBy(xpath = ".//button[@name=':submit']")
    @UseParent("singleInvite")
    public Link singleInviteBtn;
    
    @FindBy(xpath = ".//div[contains(@class, 'headerTop')]//a[contains(@href, '/directories/')]")
    public Link allMembersLnk;
    
       
}