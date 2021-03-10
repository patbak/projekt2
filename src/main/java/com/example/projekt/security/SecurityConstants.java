package com.example.projekt.security;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 3_600_0000; // 15min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/sign-up";
    public static final String CONFIRMATION_TOKEN_URL = "/api/account-confirm";
    public static final String SWAGGER_URL = "/documentation/swagger-ui.html";
    public static final String SIGN_IN_URL = "/login";
    public static final String RESET_URL = "/resetPassword";
    public static final String ROLES_URL= "/api/roles";
    public static final String CONFIRMMATION_RESET_TOKEN = "/confirmResetToken";
    public static final String SWAGGER_DOCS_URL = "/v2/api-docs";
}
