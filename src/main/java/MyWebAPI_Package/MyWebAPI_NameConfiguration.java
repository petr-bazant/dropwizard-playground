package MyWebAPI_Package;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class MyWebAPI_NameConfiguration extends Configuration {
    
    // Inserted by Petr Bazant
    @NotEmpty
    private String version;
    
    @JsonProperty
    public String getVersion() {
        return version;
    }

    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
   }
   
}
