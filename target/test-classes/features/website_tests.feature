Feature: Website Testing

 Scenario: Verify Homepage Title
    Given I am on the homepage
    Then I should retrieve the page title
 Scenario: Verify URL of Makeup Page
    Given I am on the homepage for make up url
    When I click on the Makeup link
    Then I should be redirected to the Makeup page URL

  Scenario: Verify Title of Makeup Page
    Given I am on the homepage for make up title
    When I click on the Makeup link
    Then the page title should be "Makeup"

   Scenario: Verify URL of Fragrance Product Category Page
    Given I am on the homepage for Fragrance link
    When I click on the Fragrance link
    Then I should be redirected to the Fragrance page URL

  Scenario: Verify Title of Fragrance Product Category Page
    Given I am on the homepage for Fragrance title
    When I click on the Fragrance link
    Then the page title should be again "fragrance"

  Scenario: Verify About Us Page
    Given I navigate to the About Us page
    Then I should see the header "About Us"

  Scenario: Verify Contact Page Loads
    Given I navigate to the Contact page
    Then I should see the contact form

 
  Scenario: Verify clicking the cart icon opens the cart slider
    Given I am on the product category page for Mom & Baby
    When I click on the cart icon
    Then I should see the cart slider with the header "CART"
   Scenario: Verify URL of Refund and Return Policy Page
    Given I am on the homepage for refund
    When I click on the Refund and Return Policy link
    Then I should be redirected to the Refund and Return Policy page URL

  
  Scenario: Verify adding a product increases the cart count
    Given I am on the Mom & Baby product category page
    When I check the cart count
    And I click on the "ADD TO CART" button of the first product
    Then I should see the cart count increased by 1
     
  Scenario: Verify removing a product decreases the cart count
    Given I am on the Mom & Baby product category page again
    When I open the cart slider
    And I remove a product from the cart
    Then I should see the cart count decreased by 1

   Scenario: Verify clicking the "PROCEED" button navigates to the checkout page
    Given I am on the Mom & Baby product category page
    When I check if the cart is empty
    And I add a product to the cart if it is empty
    And I open the cart slider
    And I click on the "PROCEED" button
    Then I should be redirected to the checkout page
 

  Scenario: Verify Privacy Policy Link
    I am on the homepage for privacy policy
    When I click on "Privacy Policy"
    Then I should be redirected to the privacy policy page

  Scenario: Verify Page Not Found
    Given I navigate to a non-existing page
    Then I should see a 404 error message


  Scenario: Navigate to the terms and conditions page
    Given I am on the homepage for terms and conditions
