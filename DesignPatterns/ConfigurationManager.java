import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    private final Map<String, String> configurationMap;
    private ConfigSource currSource;

    private ConfigurationManager() {
        configurationMap = new HashMap<>();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public synchronized String getConfig(String key) {
        return configurationMap.getOrDefault(key, null);

    }

    public synchronized void setConfig(String key, String val) {
        configurationMap.put(key, val);
    }

    public synchronized void loadFromSource(ConfigSource source) {

        Map<String, String> configs = source.readConfig();

        configurationMap.clear();
        configurationMap.putAll(configs);
        currSource = source;
    }

    public synchronized void refreshConfig() {
        if (currSource == null) {
            throw new RuntimeException("config not loaded ");
        }
        Map<String, String> configs = currSource.readConfig();

        configurationMap.clear();
        configurationMap.putAll(configs);
    }


}