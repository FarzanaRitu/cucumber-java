Feature: Website Testing

 

  Scenario: Verify About Us Page
    Given I navigate to the About Us page
    Then I should see the header "About Us"

  Scenario: Verify Contact Page Loads
    Given I navigate to the Contact page
    Then I should see the contact form

  Scenario: Verify Sign Up Functionality
    Given I am on the Sign Up page
    When I fill in "username" with "testuser"
    And I fill in "password" with "password123"
    And I click the "Sign Up" button
    Then I should see a success message

  Scenario: Verify Login Functionality
    Given I am on the Login page
    When I fill in "username" with "testuser"
    And I fill in "password" with "password123"
    And I click the "Login" button
    Then I should be redirected to the dashboard

  

  Scenario: Verify Adding Product to Cart
    Given I am on a product page
    When I click the "Add to Cart" button
    Then the cart count should increase

  Scenario: Verify Removing Product from Cart
    Given I have a product in my cart
    When I click the "Remove from Cart" button
    Then the cart count should decrease

  Scenario: Verify Checkout Process
    Given I have products in my cart
    When I proceed to checkout
    Then I should see the checkout page

  Scenario: Verify User Profile
    Given I am logged in
    When I navigate to my profile
    Then I should see my account details

  Scenario: Verify Password Reset
    Given I am on the Login page
    When I click on "Forgot Password"
    Then I should see a password reset form

  Scenario: Verify Newsletter Subscription
    Given I am on the homepage
    When I enter my email in the newsletter subscription box
    And I click the "Subscribe" button
    Then I should see a confirmation message

 

  Scenario: Verify Privacy Policy Link
    Given I am on the homepage
    When I click on "Privacy Policy"
    Then I should be redirected to the privacy policy page

  Scenario: Verify Page Not Found
    Given I navigate to a non-existing page
    Then I should see a 404 error message


  Scenario: Navigate to the terms and conditions page
    Given I am on the homepage for terms and conditions
