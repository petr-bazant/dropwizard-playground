package MyWebAPI_Package.security;

import MyWebAPI_Package.core.App;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class SuperTwoAuthenticator implements Authenticator<BasicCredentials, App> {
    @Override
    public Optional<App> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("secret".equals(credentials.getPassword())) {
            return Optional.of(new App(credentials.getUsername()));
        }
        return Optional.empty();
    }
}
