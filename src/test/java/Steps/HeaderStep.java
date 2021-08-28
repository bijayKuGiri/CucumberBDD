package Steps;

import Base.BaseUtilities;
import com.unilever.Pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class HeaderStep extends BaseUtilities {

    private BaseUtilities base;
    private Home _home;
    private List<String> linkTxt=new ArrayList<String>();
    private List<String> uatlinkTxt=new ArrayList<String>();

    public HeaderStep(BaseUtilities base) {
        this.base = base;
    }

    @Given("^The production site is Up and Running$")
    public void theProductionSiteIsUpAndRunning() {
        _home=new Home(base._driver);
        System.out.println("Given");
        _home.NavigateToProd();
    }

    @And("^the links of the header file should be available$")
    public void theLinksOfTheHeaderFileShouldBeAvailable() {
        System.out.println("And");
        linkTxt=_home.getLinktext();
        _home.quit();
    }

    @When("^i try to find the header links in UAT environment$")
    public void iTryToFindTheHeaderLinksInUATEnvironment() {
        System.out.println("When");
        _home.Initialize();
        _home.NavigateToUAT();
        uatlinkTxt= _home.getLinktext();
        _home.quit();
    }

    @Then("^All the link should be same as Production Site$")
    public void allTheLinkShouldBeSameAsProductionSite() {
        System.out.println("Then");
        Assert.assertTrue("Expected both the header link Text should be same",linkTxt.equals(uatlinkTxt));
    }
}
