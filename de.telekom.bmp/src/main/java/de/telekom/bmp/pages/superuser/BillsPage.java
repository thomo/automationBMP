package de.telekom.bmp.pages.superuser;

import javax.inject.Singleton;

import com.google.inject.Inject;

import de.telekom.bmp.BmpApplication;
import de.telekom.testframework.selenium.annotations.Path;

/**
 * 
 * @author Mathias Herkt
 */
@Singleton
@Path("/superuser/bills")
public class BillsPage extends SubNavHeaderPage {

	@Inject
	public BillsPage(BmpApplication app) {
		super(app);
	}
}