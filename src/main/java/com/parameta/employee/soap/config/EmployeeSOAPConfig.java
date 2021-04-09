package com.parameta.employee.soap.config;

import com.parameta.employee.soap.client.EmployeeSOAPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


/**
 * The class to configure the SOAP client.
 * */
@Configuration
public class EmployeeSOAPConfig {

    /**
     * Configure the location of the generated classes from jaxb2 maven plugin.
     *
     * @return Jaxb2Marshaller the marshaller.
     * */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.parameta.employee.soap.generated");
        return marshaller;
    }

    /**
     * Configure the SOAP client endpoint.
     *
     * @param marshaller The marshaller.
     * @return EmployeeSOAPClient the configured countryClient.
     * */
    @Bean
    public EmployeeSOAPClient countryClient(Jaxb2Marshaller marshaller) {
        EmployeeSOAPClient client = new EmployeeSOAPClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
