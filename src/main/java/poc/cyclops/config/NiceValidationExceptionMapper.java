package poc.cyclops.config;

import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Provider
@Component
@Import({ JAXRSBeanValidationInInterceptor.class })
public class NiceValidationExceptionMapper extends ValidationExceptionMapper {
    public NiceValidationExceptionMapper() {
        super();
        setAddMessageToResponse(true);
    }
}
