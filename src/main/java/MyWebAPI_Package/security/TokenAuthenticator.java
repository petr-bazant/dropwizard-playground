package MyWebAPI_Package.security;

import MyWebAPI_Package.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

public class TokenAuthenticator implements Authenticator<String, User>
{
    @Override
    public Optional<User> authenticate(String pass) throws AuthenticationException
    {
        Optional<User> user = Optional.of(new User("Petr"));
        return user;
    }
}