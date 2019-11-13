package com.midilabs.dentech.api;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.midilabs.dentech.api.config.property.DentechApiProperty;
import com.midilabs.dentech.api.master.MasterService;

@SpringBootApplication
@EnableConfigurationProperties(DentechApiProperty.class)
@ComponentScan(basePackages = "com.midilabs.dentech.api")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.midilabs.dentech.api")
public class DentechApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentechApiApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource(){
	    CustomRoutingDataSource customDataSource=new CustomRoutingDataSource();
	    customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
	    return customDataSource;
    }
}
