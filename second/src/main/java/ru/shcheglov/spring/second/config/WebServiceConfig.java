package ru.shcheglov.spring.second.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.shcheglov.spring.second.endpoint.PersonEndpoint;

/**
 * @author Alexey Shcheglov
 * @version dated 23.01.2019
 */

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @NotNull
    public static final String WS_MAPPING = "/soap/*";

    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, WS_MAPPING);
    }

    @Bean(name = "PersonService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema testEndpointSchema) {
        final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(PersonEndpoint.PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(PersonEndpoint.LOCATION_URI);
        wsdl11Definition.setTargetNamespace(PersonEndpoint.NAMESPACE);
        wsdl11Definition.setSchema(testEndpointSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema testEndpointSchema() {
        return new SimpleXsdSchema((new ClassPathResource("xsd/personEndpoint.xsd")));
    }
}
