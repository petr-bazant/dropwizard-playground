package MyWebAPI_Package;

import MyWebAPI_Package.core.User;
import MyWebAPI_Package.core.App;
import MyWebAPI_Package.security.SuperAuthenticator;
import MyWebAPI_Package.security.SuperTwoAuthenticator;
import MyWebAPI_Package.security.SuperAuthorizer;
import MyWebAPI_Package.security.TokenFactoryProvider;
import MyWebAPI_Package.security.TokenFeature;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.PolymorphicAuthDynamicFeature;
import io.dropwizard.auth.PolymorphicAuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentials;

import MyWebAPI_Package.health.NecoHealthCheck;
import MyWebAPI_Package.resources.InfoResource;
import MyWebAPI_Package.resources.SecretResource;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import org.glassfish.hk2.utilities.binding.AbstractBinder;


public class MyWebAPI_NameApplication extends Application<MyWebAPI_NameConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyWebAPI_NameApplication().run(args);
    }

    @Override
    public String getName() {
        return "MyWebAPI_Name";
    }

    @Override
    public void initialize(final Bootstrap<MyWebAPI_NameConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyWebAPI_NameConfiguration configuration,
                    final Environment environment) {
        
        // healthcheck
        final NecoHealthCheck healthCheck = new NecoHealthCheck();
        environment.healthChecks().register("neco-neco", healthCheck);
        
        // resource
        final InfoResource infoResource = new InfoResource(configuration.getVersion());
        environment.jersey().register(infoResource);
        
        final SecretResource secretResource = new SecretResource();
        environment.jersey().register(secretResource);
        
        /*
        // auth
        //environment.jersey().register(TokenFeature.class);
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new SuperAuthenticator())
                        .setAuthorizer(new SuperAuthorizer())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
        */
       
       // auth - multiple principals
       final AuthFilter<BasicCredentials, User> userFilter
        = new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new SuperAuthenticator())
                .setRealm("SUPER SECRET STUFF")
                .buildAuthFilter();
                
        final AuthFilter<BasicCredentials, App> appFilter
                = new BasicCredentialAuthFilter.Builder<App>()
                        .setAuthenticator(new SuperTwoAuthenticator())
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter();
        
        final PolymorphicAuthDynamicFeature feature = new PolymorphicAuthDynamicFeature<>(
            ImmutableMap.of(
                User.class, userFilter,
                App.class, appFilter));
        final AbstractBinder binder = new PolymorphicAuthValueFactoryProvider.Binder<>(
            ImmutableSet.of(User.class, App.class));
        
        environment.jersey().register(feature);
        environment.jersey().register(binder);
    }

}
