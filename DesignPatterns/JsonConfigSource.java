import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.IIOException;

public class JsonConfigSource implements ConfigSource {
    private final String filePath;

    public JsonConfigSource(String filePath) {

        this.filePath = filePath;
    }

    @Override
    public Map<String, String> readConfig() {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file" + e.getMessage());
        }

    }
}
