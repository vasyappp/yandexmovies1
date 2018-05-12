package Utils;

import java.util.HashMap;
import java.util.Map;

public class Stash {
    private static Stash ourInstance = new Stash();
    private Map<String, Object> stash;

    public static String movieName = "movieName";
    public static String theatersAmount = "theatersAmount";
    public static String choosenFilteredMovie = "choosenFilteredMovie";

    public static Stash getInstance() {
        return ourInstance;
    }

    private Stash() {
        stash = new HashMap<>();
    }

    public void put(String key, Object value) {
        stash.put(key, value);
    }

    public Object get(String key) {
        return stash.get(key);
    }
}
