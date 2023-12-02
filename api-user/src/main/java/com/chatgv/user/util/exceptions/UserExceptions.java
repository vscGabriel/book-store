package com.chatgv.user.util.exceptions;

public class UserExceptions extends RuntimeException{
    public static String USER_NOT_FOUND = "User not found";
    public static String USER_DUPLICATE = "There is already user with this email";

    public UserExceptions(String message) {
        super(message);
    }
}
