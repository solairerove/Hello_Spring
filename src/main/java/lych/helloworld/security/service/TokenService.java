package lych.helloworld.security.service;

public interface TokenService {

    String getToken(final String username,final String password) throws Exception;
}
