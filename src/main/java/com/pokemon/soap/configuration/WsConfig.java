package com.pokemon.soap.configuration;

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

@EnableWs
@Configuration
public class WsConfig extends WsConfigurerAdapter {
  @Bean
  public ServletRegistrationBean webServiceServlet(ApplicationContext context) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(context);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name="pokemon")
  public DefaultWsdl11Definition definition(XsdSchema xsdSchema) {
    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    definition.setPortTypeName("PokemonPort");
    definition.setLocationUri("/ws");
    definition.setTargetNamespace("http://soap.pokemon.com/");
    definition.setSchema(xsdSchema);
    return definition;
  }

  @Bean
  public XsdSchema pokemonSchema() {
    return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
  }
}
