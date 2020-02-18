package poc.cyclops.config;

import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Provider
@Component
public class NiceJsonProvider extends JacksonJsonProvider {

    public NiceJsonProvider() {
        super();

        final ObjectMapper mapper = _mapperConfig.getDefaultMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_ABSENT);
        mapper.registerModule(new Jdk8Module());
    }
}
