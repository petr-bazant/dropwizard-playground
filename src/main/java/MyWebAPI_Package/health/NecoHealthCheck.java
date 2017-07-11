package MyWebAPI_Package.health;

import com.codahale.metrics.health.HealthCheck;

public class NecoHealthCheck extends HealthCheck {
    
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}