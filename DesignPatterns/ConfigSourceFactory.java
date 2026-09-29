import java.util.HashMap;
import java.util.Map;

public class ConfigSourceFactory {
    private static final Map<String, ConfigSource> cache = new HashMap<>();

    public static synchronized ConfigSource createSource(String type, String filePath) {

        String key = type.toLowerCase() + ":" + filePath;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        ConfigSource source;
        switch (type.toLowerCase()) {

            case "json":
                source = new JsonConfigSource(filePath);
                break;

            case "yaml":
                source = new YamlConfigSource(filePath);
                break;

            case "properties":
                source = new PropertiesConfigSource(filePath);
                break;
            default:
                throw new RuntimeException("Unsupported configuration type:" + type);
        }
        cache.put(key, source);
        return source;
    }
}