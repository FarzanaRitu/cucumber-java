package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ExampleStepDefinitions {
    @Given("I want to print hello")
    public void i_want_to_print_hello() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Preparing to print hello...");
    }

    @Then("I print {string}")
    public void i_print(String message) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(message);
    }
}
