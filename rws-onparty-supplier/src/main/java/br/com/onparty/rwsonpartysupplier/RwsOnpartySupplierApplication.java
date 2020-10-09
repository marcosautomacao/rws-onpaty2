package br.com.onparty.rwsonpartysupplier;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class RwsOnpartySupplierApplication {

	public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("spring.datasource.url", "jdbc:postgresql//localhost:5432/onparty-suppliers");
        properties.put("spring.datasource.username", "postgres");
        properties.put("spring.datasource.password", "123");
        properties.put("spring.jpa.show-sql", "true");
        properties.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("pring.jpa.hibernate.ddl-auto", "update");
        properties.put("server.port", 8089);
        new SpringApplicationBuilder(RwsOnpartySupplierApplication.class)

        .properties(properties)
        .build()
        .run(args);	}

}
