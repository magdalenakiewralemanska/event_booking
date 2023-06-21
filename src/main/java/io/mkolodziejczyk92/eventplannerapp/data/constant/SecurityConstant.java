package io.mkolodziejczyk92.eventplannerapp.data.constant;

public class SecurityConstant {

    public static final String AUTHORITIES = "Authorities";
    public static final long EXPIRATION_TIME = 3_600_000;
    public static final String NOT_VERIFIED_TOKEN = "Token not verified";
    public static final String TOKEN_FRONT = "Bearer ";
    public static final String HTTP_METHODS = "OPTIONS";
    public static final String FORBIDDEN = "You have to log in first";
    public static final String ACCESS_DENIED = "Your permissions are insufficient";
    public static final String[] PUBLIC_URLS = {"/user/login", "/user/registration", "/events",
            "/events/*/offers/*", "/events/*/offers", "/offers/*/packages"};
    public static final String TOKEN_HEADER = "Jwt-Token";
}
