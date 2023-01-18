import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DBTest {

    @Given("element is present") @When("i assert if element is present") @Then("i should return true")
    @Test
    public void testPage() {

        String username = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomNumeric(4);

        Page page = new Page();
        page.signIn(username,password);
        page.addToCartAndClickCart();
        Assert.assertTrue(page.notebookIsPresent());
        page.quit();

    }
}
