package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dto.CustomerAddress;
import org.yaml.snakeyaml.Yaml;

import java.util.List;

public class TestUtil {

    private static final List<Object> addresses = new Yaml()
            .load(TestUtil.class.getResourceAsStream("/addresses.yaml"));

    public static CustomerAddress getAddress(int yamlDataIndex) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.convertValue(addresses.get(yamlDataIndex), CustomerAddress.class);
    }
}
