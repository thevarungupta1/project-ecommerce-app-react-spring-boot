package com.thevarungupta.grocery_app_api.dto;

public record AuthResponse(String token, UserDto user, String message) {
}
