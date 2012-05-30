package pl.kaczanowscy.tomek;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import static com.jayway.awaitility.Awaitility.with;
import static java.util.concurrent.TimeUnit.SECONDS;
/**
 * Tomasz Kaczanowski
 * http://kaczanowscy.pl/tomek
 * 5/30/12, 8:12 PM
 */
@Test
public class AwaitilityGodotExample {

    private static SimpleDateFormat HH_MM_SS = new SimpleDateFormat("HH:mm:ss");

    public void godotWillNotShowUp() throws Exception {
        System.out.println(HH_MM_SS.format(new Date()) + " waiting for Godot (for max 20 seconds)");
        with().pollDelay(5, SECONDS).and().with().pollInterval(2, SECONDS).await("waiting for Godot").atMost(20, SECONDS)
                .until(godotIsHere());
    }

    private Callable<Boolean> godotIsHere() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                System.out.println(HH_MM_SS.format(new Date()) + " is Godot here? no...");
                return false;
            }
        };
    }
}
