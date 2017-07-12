package MyWebAPI_Package.security;


import MyWebAPI_Package.core.User;
import io.dropwizard.auth.Authorizer;

public class SuperAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("good-guy") && role.equals("ADMIN");
    }
}