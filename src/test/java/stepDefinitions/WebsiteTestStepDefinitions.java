package stepDefinitions;
import org.junit.Assert;
import java.lang.AssertionError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
// import utilis.TestContextSetup;
// import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

public WebsiteTestStepDefinitions() {
    // Initialize the WebDriver (Assuming it is already set up in your test framework)
    // Example: driver = new ChromeDriver();
}
            ///get the title///

            @Given("I am on the homepage")
            public void i_am_on_the_homepage() {
            
                driver.get("https://shop.shajgoj.com/"); // Navigate to the homepage
            }
        
            @Then("I should retrieve the page title")
            public void i_should_retrieve_the_page_title() {
                // Get the title of the page
                String pageTitle = driver.getTitle();
                System.out.println("Page Title: " + pageTitle); // Print the page title to the console
        
            }

          
            @Given("I am on the homepage for make up url")
public void i_am_on_the_homepage_for_make_up_url() {
    driver.get("https://shop.shajgoj.com/");
}

@When("I click on the Makeup link")
public void i_click_on_the_makeup_link() {
    WebElement makeupLink = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/nav/div[2]/li[1]/a"));
    makeupLink.click();
}

@Then("I should be redirected to the Makeup page URL")
public void i_should_be_redirected_to_the_makeup_page_url() {
    // Add an explicit wait to ensure the navigation is complete
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("/product-category/makeup"));

    // Get the actual URL and use contains to verify the expected part of the URL
    String actualUrl = driver.getCurrentUrl();
    String expectedUrlPart = "/product-category/makeup";

    // Assert that the URL contains the expected part
    assertTrue("The URL did not match the expected URL part.",
               actualUrl.contains(expectedUrlPart));
}
@Given("I am on the homepage for make up title")
public void i_am_on_the_homepage_for_make_up_title() {
     
    driver.get("https://shop.shajgoj.com/product-category/makeup");

}


@Then("the page title should be {string}")
public void the_page_title_should_be(String expectedTitle) {
    // Add an explicit wait to ensure the page title is loaded
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.titleIs(expectedTitle));

    // Verify the page title
    String actualTitle = driver.getTitle();
    assertEquals("The page title did not match.", expectedTitle, actualTitle);
}
            ///Return and refund///
            @Given("I am on the homepage for refund")
            public void i_am_on_the_homepage_for_refund() {
                driver.get("https://shop.shajgoj.com/");
            }
        
            @When("I click on the Refund and Return Policy link")
            public void i_click_on_the_refund_and_return_policy_link() {
                WebElement refundAndReturnPolicyLink = driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div/div[2]/div/a[4]"));
                refundAndReturnPolicyLink.click();
            }
        
            @Then("I should be redirected to the Refund and Return Policy page URL")
            public void i_should_be_redirected_to_the_refund_and_return_policy_page_url() {
                String expectedUrl = "https://shop.shajgoj.com/refund-and-return-policy";
                String actualUrl = driver.getCurrentUrl();
                assertEquals(expectedUrl, actualUrl);
            }
            ///Fragrance//
            @Given("I am on the homepage for Fragrance link")
            public void i_am_on_the_homepage_for_fragrance_link () {
                driver.get("https://shop.shajgoj.com/");
            }
        
            @When("I click on the Fragrance link")
            public void i_click_on_the_fragrance_link() {
                WebElement fragranceLink = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/nav/div[2]/li[6]/a"));
                fragranceLink.click();
            }
        
            @Then("I should be redirected to the Fragrance page URL")
             public void i_should_be_redirected_to_the_fragrance_page_url() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("product-category/fragrance"));
    String expectedUrl = "https://shop.shajgoj.com/product-category/fragrance";
    String actualUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);
}
@Given("I am on the homepage for Fragrance title")
public void i_am_on_the_homepage_for_fragrance_title () {
    driver.get("https://shop.shajgoj.com/product-category/fragrance");
}
        
@Then("the page title should be again {string}")
public void the_page_title_should_be_again(String expectedTitle) {
    String actualTitle = driver.getTitle();
    assertEquals(expectedTitle, actualTitle);
}

             ///About us page///

    @Given("I navigate to the About Us page")
    public void i_navigate_to_the_about_us_page() {
        driver.get("https://shop.shajgoj.com/about-us"); 
    }
    @Then("I should see the header {string}")
    public void i_should_see_the_header(String expectedHeader) {
    try {
        // Wait until the header element located by XPath is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div[2]/main/div/div[1]/h2")));
        
        // Get the actual header text and trim any extra whitespace
        String actualHeader = headerElement.getText().trim();
        
        // Print actual header for debugging
        System.out.println("Actual header: '" + actualHeader + "'");
        
        // Use JUnit assertion to compare expected and actual header
        Assert.assertEquals("Expected header did not match", expectedHeader, actualHeader);
    } catch (NoSuchElementException e) {
        throw new AssertionError("Header element was not found on the page.", e);
    }
}

  
    
     
                 ///contact page///
@Given("I navigate to the Contact page")
public void i_navigate_to_the_contact_page() {
    // Replace with the actual URL of the Contact page
    driver.get("https://shop.shajgoj.com/contact");
}
@Then("I should see the contact form")
public void i_should_see_the_contact_form() {
    try {
        // Wait for the contact information div to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactInfoDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div[2]/main/div/div[2]/div/div/div[1]/div")));

        // Verify that the contact information div is displayed
        Assert.assertTrue("Contact information div is not visible.", contactInfoDiv.isDisplayed());

        // Print out the content for debugging purposes
        String contactInfoText = contactInfoDiv.getText();
        System.out.println("Contact information content: " + contactInfoText);

        // Optionally, verify specific pieces of information if you have expected values
        Assert.assertTrue("Contact information does not contain email.", contactInfoText.contains("info@shajgoj.com"));
        Assert.assertTrue("Contact information does not contain phone number.", contactInfoText.contains("+8809666737475"));
        
    } catch (NoSuchElementException e) {
        throw new AssertionError("Contact information element was not found on the page.", e);
    }
}
     ///login page///
   
    @Given("I am on the Log in page")
    public void i_am_on_the_log_in_page() {
        // Code to navigate to Login page
        driver.get("https://shop.shajgoj.com/login"); 
    }
    @Then("I should be redirected to the dashboard")
     public void i_should_be_redirected_to_the_dashboard() {
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals("https://shop.shajgoj.com/login", currentUrl);
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

                      ///wishlist page///

@Given("I am on the wishlist page")
    public void i_am_on_the_wishlist_page() {
        driver.get("https://shop.shajgoj.com/wishlist"); // Navigate to the wishlist page
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        // Locate the element containing the wishlist message
        WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]"));
        
        // Get the actual text and verify it matches the expected message
        String actualMessage = messageElement.getText();
        assertEquals("The wishlist message text is incorrect.", expectedMessage, actualMessage);
      
    }
                      ///checking card slider///

    @Given("I am on the product category page for Mom & Baby")
    public void i_am_on_the_product_category_page_for_mom_baby() {
       
        driver.get("https://shop.shajgoj.com/product-category/mom-baby"); // Navigate to the Mom & Baby category page
    }

    @When("I click on the cart icon")
    public void i_click_on_the_cart_icon() {
        // Locate and click the cart icon to open the cart slider
        WebElement cartIcon = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]"));
        cartIcon.click();

        // Wait for a moment to allow the cart slider to open
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the cart slider with the header {string}")
    public void i_should_see_the_cart_slider_with_the_header(String expectedHeader) {
        // Get the header element of the cart slider
        WebElement cartHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[1]/h4"));

        // Verify that the header text matches the expected value
        assertEquals("Cart header does not match!", expectedHeader, cartHeader.getText());

    }

    ///add to cart///
    int initialCartCount;
                   
                       WebDriverWait wait;
                       
                       @Given("I am on the Mom & Baby product category page")
                       public void i_am_on_the_mom_baby_product_category_page() {
                           driver.get("https://shop.shajgoj.com/product-category/makeup"); // Navigate to the Mom & Baby category page
                           
                           // Add an explicit wait for the page to load
                           wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        //    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'product-list')]"))); // Replace with a more general locator for page loading
                       }
                       
                       @When("I check the cart count")
                       public void i_check_the_cart_count() {
                           // Wait for the cart count element to be visible and retrieve the current count
                           WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]/span")));
                           String cartCountText = cartCountElement.getText();
                           initialCartCount = Integer.parseInt(cartCountText);
                       }
                       
                       @When("I click on the \"ADD TO CART\" button of the first product")
                       public void i_click_on_the_add_to_cart_button_of_the_first_product() {
                           // Locate and click the "ADD TO CART" button of the first product using explicit wait
                           WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/main/div/div[2]/div/div[2]/div[3]/div[2]/div/ul/li[1]/div/button")));
                           addToCartButton.click();
                           
                       
                           // Wait until the cart count is updated (you can use a different condition to check if needed)
                           wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]/span"), String.valueOf(initialCartCount + 1)));
                       }
                       
                       @Then("I should see the cart count increased by 1")
                       public void i_should_see_the_cart_count_increased_by_1() {
                           // Locate the cart count element again and retrieve the updated count
                           WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]/span")));
                           String updatedCartCountText = cartCountElement.getText();
                           int updatedCartCount = Integer.parseInt(updatedCartCountText);
                       
                           // Verify that the cart count has increased by 1
                           assertEquals("The cart count did not increase as expected.", initialCartCount + 1, updatedCartCount);
                       }
                       
    /// remove-product from the cart///
    @Given("I am on the Mom & Baby product category page again")
    public void i_am_on_the_mom_baby_product_category_page_again() {
       
        driver.get("https://shop.shajgoj.com/product-category/makeup"); // Navigate to the Mom & Baby category page
    }

    @When("I verify the cart count")
    public void i_verify_the_cart_count() {
        // Locate the cart count element and retrieve the current count
        WebElement cartCountElement = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]/span"));
        String cartCountText = cartCountElement.getText();
        initialCartCount = Integer.parseInt(cartCountText);
    }

    @When("I open the cart slider")
    public void i_open_the_cart_slider() {
        // Locate and click on the button to open the cart slider
        WebElement cartSliderButton = driver.findElement(By.xpath("/html/body/div/div[2]/button/div[1]"));
        cartSliderButton.click();

        // Wait for some time to allow the slider to open
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I remove a product from the cart")
    public void i_remove_a_product_from_the_cart() {
        // Locate and click the remove button for the product in the cart slider
        WebElement removeButton = driver.findElement(By.xpath("//*[@id='__next']/div[2]/div[3]/div[2]/div[1]/div/div[1]/div[3]/div/div/button[1]/span"));
        removeButton.click();

        // Wait for some time to allow the cart count to update
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the cart count decreased by 1")
    public void i_should_see_the_cart_count_decreased_by_1() {
        // Locate the cart count element again and retrieve the updated count
        WebElement cartCountElement = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/nav/div[1]/div[3]/div/a[2]/span"));
        String updatedCartCountText = cartCountElement.getText();
        int updatedCartCount = Integer.parseInt(updatedCartCountText);

        // Verify that the cart count has decreased by 1
        assertEquals("The cart count did not decrease as expected.", initialCartCount - 1, updatedCartCount);

    }



               ///terms and condition///
     @Given("I am on the homepage for terms and conditions")
    public void i_am_on_the_homepage_for_terms_and_conditions() {
        driver.get("https://shop.shajgoj.com/terms-conditions");
    }

    @Then("I should be redirected to the terms page")
public void i_should_be_redirected_to_the_terms_page() {
    // Wait for the URL to be as expected
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe("https://shop.shajgoj.com/terms-conditions"));

    // Verify that the current URL is correct
    String currentUrl = driver.getCurrentUrl();
    assertEquals("https://shop.shajgoj.com/terms-conditions", currentUrl);

    // Wait for the header element to be present before verifying
    WebElement termsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div/div/h2")));

    // Verify that the header element is present
    assertNotNull("The Terms & Conditions header was not found on the page.", termsHeader);
}

    @Given("I am on the homepage for privacy policy")
    public void i_am_on_the_homepage_for_privacy_policy() {
        driver.get("https://shop.shajgoj.com");
    }
    @When("I click on {string}")
    public void i_click_on(String string) {
        // Use an explicit wait to wait until the element is clickable
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"__next\"]/div[2]/footer/div/div/div[2]/div/a[3]")));
        
        // Click the element
        elementToClick.click();
    }

    @Then("I should be redirected to the privacy policy page")
    public void i_should_be_redirected_to_the_privacy_policy_page() {
        // Navigate to the privacy policy page
        driver.get("https://shop.shajgoj.com/privacy-policy");

        // Verify that the current URL is correct
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://shop.shajgoj.com/privacy-policy", currentUrl);

        // Optionally, verify that an element unique to the privacy policy page is present
        WebElement privacyHeader = driver.findElement(By.xpath("//h2[contains(text(), 'Privacy Policy')]"));
        assertNotNull("The Privacy Policy header was not found on the page.", privacyHeader);
    }
                                ////404 error///
   @Given("I navigate to a non-existing page")
    public void i_navigate_to_a_non_existing_page() {
    
        driver.get("https://shop.shajgoj.com/non-existing-page"); // Navigate to a non-existing page
    }

    @Then("I should see a 404 error message")
    public void i_should_see_a_404_error_message() {
        // Locate the header element using the given XPath and verify it
        WebElement errorHeader = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/h4"));
        assertNotNull("The 404 error message header was not found on the page.", errorHeader);
        
        // Verify the text of the 404 error message, if needed
        String expectedMessage = "UH OH! You are lost."; // Replace with the actual text
        String actualMessage = errorHeader.getText();
        assertEquals("UH OH! You are lost. text is incorrect.", expectedMessage, actualMessage);
        
       
    }
}

