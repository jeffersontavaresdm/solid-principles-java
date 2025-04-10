package com.solid.principles.srp;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.assertj.core.api.Assertions.*;

public class UserManagementSteps {
    private TestContext context;

    @Before
    public void setup() {
        context = new TestContext();
    }

    // Given steps
    @Given("a new user with id {string}, name {string} and email {string}")
    public void givenNewUser(String id, String name, String email) {
        context.setUserDetails(id, name, email);
    }

    @Given("the user is already created")
    public void givenUserIsAlreadyCreated() {
        createUser(
            context.getCurrentUserId(),
            context.getCurrentUserName(),
            context.getCurrentUserEmail()
        );
    }

    @Given("a user exists with id {string}, name {string} and email {string}")
    public void givenUserExists(String id, String name, String email) {
        createUser(id, name, email);
        context.setUserDetails(id, name, email);
    }

    @Given("no user exists with id {string}")
    public void givenNoUserExists(String id) {
        context.setUserDetails(id, null, null);
    }

    // When steps
    @When("I try to create the user")
    public void whenTryToCreateUser() {
        boolean result = createUser(
            context.getCurrentUserId(),
            context.getCurrentUserName(),
            context.getCurrentUserEmail()
        );
        context.setOperationResult(result);
    }

    @When("I try to create another user with the same id")
    public void whenTryToCreateDuplicateUser() {
        boolean result = createUser(
            context.getCurrentUserId(),
            "Another Name",
            "another@example.com"
        );
        context.setOperationResult(result);
    }

    @When("I update the user with name {string} and email {string}")
    public void whenUpdateUser(String newName, String newEmail) {
        boolean result = updateUser(context.getCurrentUserId(), newName, newEmail);
        if (result) {
            context.setUserDetails(context.getCurrentUserId(), newName, newEmail);
        }
        context.setOperationResult(result);
    }

    // Then steps
    @Then("the user should be created successfully")
    public void thenUserCreatedSuccessfully() {
        assertThat(context.getOperationResult())
            .as("User creation should be successful")
            .isTrue();
    }

    @Then("the user creation should fail")
    public void thenUserCreationFails() {
        assertThat(context.getOperationResult())
            .as("User creation should fail")
            .isFalse();
    }

    @Then("the update should be successful")
    public void thenUpdateSuccessful() {
        assertThat(context.getOperationResult())
            .as("User update should be successful")
            .isTrue();
    }

    @Then("the update should fail")
    public void thenUpdateFails() {
        assertThat(context.getOperationResult())
            .as("User update should fail")
            .isFalse();
    }

    // And steps
    @And("the user should exist in the system")
    public void andUserExists() {
        assertThat(context.getUserRepository().exists(context.getCurrentUserId()))
            .as("User should exist in the system")
            .isTrue();
    }

    @And("the user should not exist in the system")
    public void andUserDoesNotExist() {
        assertThat(context.getUserRepository().exists(context.getCurrentUserId()))
            .as("User should not exist in the system")
            .isFalse();
    }

    @And("the user details should be updated")
    public void andUserDetailsUpdated() {
        User user = context.getUserRepository()
            .findById(context.getCurrentUserId())
            .orElseThrow(() -> new AssertionError("User not found"));

        assertThat(user)
            .as("Updated user details")
            .satisfies(u -> {
                assertThat(u.getName()).isEqualTo(context.getCurrentUserName());
                assertThat(u.getEmail()).isEqualTo(context.getCurrentUserEmail());
            });
    }

    // Helper methods
    private boolean createUser(String id, String name, String email) {
        return context.getUserService().createUser(id, name, email);
    }

    private boolean updateUser(String id, String name, String email) {
        return context.getUserService().updateUser(id, name, email);
    }
} 