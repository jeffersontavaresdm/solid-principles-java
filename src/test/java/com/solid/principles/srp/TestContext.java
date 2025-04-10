package com.solid.principles.srp;

public class TestContext {
    private UserService userService;
    private UserRepository userRepository;
    private UserValidator userValidator;
    private String currentUserId;
    private String currentUserName;
    private String currentUserEmail;
    private boolean operationResult;

    public TestContext() {
        this.userRepository = new UserRepository();
        this.userValidator = new UserValidator();
        this.userService = new UserService(userRepository, userValidator);
    }

    public void setUserDetails(String id, String name, String email) {
        this.currentUserId = id;
        this.currentUserName = name;
        this.currentUserEmail = email;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public void setOperationResult(boolean result) {
        this.operationResult = result;
    }

    public boolean getOperationResult() {
        return operationResult;
    }
} 