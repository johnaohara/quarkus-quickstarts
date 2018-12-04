package org.acme.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.shamrock.runtime.ShutdownEvent;
import org.jboss.shamrock.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger("ListenerBean");

    /**
     * Inject a bean used in the callbacks.
     */
    @Inject MyOtherBean bean;

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...{}", bean.hello());          
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping... {}", bean.bye());
    }
    
}