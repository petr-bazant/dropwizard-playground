package MyWebAPI_Package.core;

import java.security.Principal;

public class App implements Principal {
    private final String name;
 
    public App(String name) {
        this.name = name;
    }
 
   public String getName() {
        return name;
    }
 
}