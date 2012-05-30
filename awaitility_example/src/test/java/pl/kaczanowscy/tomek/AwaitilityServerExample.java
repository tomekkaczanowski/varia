package pl.kaczanowscy.tomek;

import org.testng.annotations.Test;

import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.with;
import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Tomasz Kaczanowski
 * http://kaczanowscy.pl/tomek
 * 5/30/12, 8:12 PM
 */
@Test
public class AwaitilityServerExample {

    public void verifyAppIsStarted() throws Exception {
        with().pollDelay(1, MINUTES).and().with().pollInterval(5, SECONDS)
                .await("waiting for web app to be ready")
                .atMost(3, MINUTES).until(webAppResponds());
    }

    private Callable<Boolean> webAppResponds() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean result = false; // here calling some servlets to determine if the web app works
                return result;
            }
        };
    }
}
