package com.midilabs.dentech.api.master;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MasterService {
	
    public static Map<Object, Object> getDataSourceHashMap() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/dentalpix?createDatabaseIfNotExist=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost/dentalpix_2?createDatabaseIfNotExist=true&useSSL=false");
        dataSource1.setUsername("root");
        dataSource1.setPassword("");
        
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("dentalpix1", dataSource);
        hashMap.put("dentalpix2", dataSource1);
        return hashMap;

    }
}
