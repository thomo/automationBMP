package de.telekom.bmp.tests.smoketest;

import com.google.inject.Inject;

import de.telekom.bmp.BmpApplication;
import de.telekom.bmp.data.Datapool;
import de.telekom.bmp.data.User;
import de.telekom.bmp.functional.FunctionalActions;
import de.telekom.bmp.pages.Header;
import de.telekom.bmp.pages.Home;
import de.telekom.bmp.pages.Login;
import de.telekom.bmp.pages.channel.MarketPlacePage;
import static de.telekom.testframework.Actions.*;
import de.telekom.testframework.annotations.QCId;
import static de.telekom.testframework.selenium.Matchers.*;
import de.telekom.testframework.selenium.annotations.UseWebDriver;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Pierre Nomo
 */

@QCId("4126")
@UseWebDriver
public class TC007_Login_as_Chanel_Support {
    
    @Inject
    BmpApplication app;
    
    @Inject
    FunctionalActions fa;
    
    @Inject
    Login login;
    
    @Inject
    Home home;
    
    @Inject
    MarketPlacePage marketplacepage;
    
    @Inject
    Datapool datapool;
    
    @Inject
    Header header;

    // Needed user
    User user;
    
    @BeforeMethod
    public void setup() {
        user = datapool.users().field("valid").equal(true)
                               .field("registered").notEqual(false)
                               .field("email").equal("mybmptestuser+chansupport@gmail.com").get();
        
        assertNotNull(user, "cannot find a valid user");
        
//        user.valid = false;
        
        navigateTo(login);
        
    }
    
    @Test
    public void test_007_Login_as_ChannelSupport() {

        try {
            fa.login(user);
            
            click(header.settings.channelUser);
            
// WORKAROUND BECAUSE OF CMS Redirect
//            navigateTo(marketplacepage);
            
            assertThat(marketplacepage,is(currentPage()));
            
            click(marketplacepage.evenlogsTab);            
            
            fa.logout();

            assertThat(home, is(currentPage()));
            
//            user.valid = true;
        } finally {
            user.registered = true;
            datapool.save(user);
        }

    }
    
    
}
