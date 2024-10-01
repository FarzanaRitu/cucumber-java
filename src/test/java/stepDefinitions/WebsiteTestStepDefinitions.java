package stepDefinitions;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// import static org.junit.Assert.assertEquals;

// import org.openqa.selenium.By;
public class WebsiteTestStepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        driver.get("https://shop.shajgoj.com/");
    }

    @Then("the page title should be {string}")
public void the_page_title_should_be(String expectedTitle) {
    String actualTitle = driver.getTitle();
    assertEquals(expectedTitle, actualTitle);
}

    @Given("I navigate to the About Us page")
    public void i_navigate_to_the_about_us_page() {
        driver.get("https://shop.shajgoj.com/about-us"); 
    }


    @Then("I should see the header {string}")
    public void i_should_see_the_header(String header) {
        // Code to verify the header
    }

    @Given("I navigate to the Contact page")
    public void i_navigate_to_the_contact_page() {
        // Code to navigate to Contact page
    }

    @Then("I should see the contact form")
    public void i_should_see_the_contact_form() {
        // Code to verify contact form visibility
    }

    @Given("I am on the Sign Up page")
    public void i_am_on_the_sign_up_page() {
        // Code to navigate to Sign Up page
    }

    @When("I fill in {string} with {string}")
    public void i_fill_in_with(String field, String value) {
        // Code to fill in a field
    }

    @When("I click the {string} button")
    public void i_click_the_button(String button) {
        // Code to click a button
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        // Code to verify success message
    }

   
    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        // Code to navigate to Login page
        driver.get("https://shop.shajgoj.com/login"); // Replace with the actual Login page URL
    }
    @Then("I should be redirected to the dashboard")
public void i_should_be_redirected_to_the_dashboard() {
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals("https://shop.shajgoj.com/login", currentUrl);
}



    @Given("I am on a product page")
    public void i_am_on_a_product_page() {
        // Code to navigate to a product page
    }

    @Given("I have a product in my cart")
    public void i_have_a_product_in_my_cart() {
        // Code to verify product in cart
    }

    @Then("the cart count should increase")
    public void the_cart_count_should_increase() {
        // Code to verify cart count increase
    }

    @Then("the cart count should decrease")
    public void the_cart_count_should_decrease() {
        // Code to verify cart count decrease
    }

    @Given("I have products in my cart")
    public void i_have_products_in_my_cart() {
        // Code to verify products in cart
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        // Code to proceed to checkout
    }

    @Then("I should see the checkout page")
    public void i_should_see_the_checkout_page() {
        // Code to verify checkout page visibility
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        // Code to verify user is logged in
    }

    @When("I navigate to my profile")
    public void i_navigate_to_my_profile() {
        // Code to navigate to user profile
    }

    @Then("I should see my account details")
    public void i_should_see_my_account_details() {
        // Code to verify account details
    }

   
    @When("I click on {string}")
    public void i_click_on(String linkText) {
        // Code to click on a link
    }

    @Then("I should see a password reset form")
    public void i_should_see_a_password_reset_form() {
        // Code to verify password reset form
    }
    @When("I search for {string}")
    public void i_search_for(String product) {
        // Locate the search box using the input class name
        WebElement searchBox = driver.findElement(By.cssSelector("input[aria-label='Search']"));
        
        // Clear the search box if it has any default value
        searchBox.clear();
        
        // Enter the product name into the search box
        searchBox.sendKeys(product);
        
        // Submit the search form
        searchBox.submit(); // This will simulate pressing Enter
        
       
    }
    
    @Then("I should see search results")
public void i_should_see_search_results() {
    // Adjust the locator as per your search results' HTML structure
    WebElement resultsContainer = driver.findElement(By.cssSelector(".search-results")); // Replace with the correct selector

    // Verify that results are displayed
    Assert.assertTrue("Search results should be displayed", resultsContainer.isDisplayed());
}



    
    @When("I enter my email in the newsletter subscription box")
    public void i_enter_my_email_in_the_newsletter_subscription_box() {
        // Code to enter email
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        // Code to verify confirmation message
    }
   @Given("I am on the homepage for terms and conditions")
public void i_am_on_the_homepage_for_terms_and_conditions() {
    driver.get("https://shop.shajgoj.com/terms-conditions"); 
}

    

    @Then("I should be redirected to the terms page")
    public void i_should_be_redirected_to_the_terms_page() {
        // Code to verify redirection
    }

    @Then("I should be redirected to the privacy policy page")
    public void i_should_be_redirected_to_the_privacy_policy_page() {
        // Code to verify redirection
    }

    @Given("I navigate to a non-existing page")
    public void i_navigate_to_a_non_existing_page() {
        // Code to navigate to a non-existing page
    }

    @Then("I should see a 404 error message")
    public void i_should_see_a_404_error_message() {
        // Code to verify 404 error message
    }
}
