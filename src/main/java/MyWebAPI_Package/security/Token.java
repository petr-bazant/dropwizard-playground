package MyWebAPI_Package.security;

/**
 * Created by petrb on 11. 7. 2017.
 * https://stackoverflow.com/questions/30397933/jersey-2-x-custom-injection-annotation-with-attributes
 */
public class Token {
    private final String token;
    public Token(String token) { this.token = token; }
    public String getToken() { return token; }
}
