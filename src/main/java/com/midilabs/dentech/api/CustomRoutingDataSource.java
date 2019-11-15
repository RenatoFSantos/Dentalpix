package com.midilabs.dentech.api;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        if(attr!=null) {
        	String serverName = attr.getRequest().getServerName();
        	// Selecionando o schema do bd
        	// ATUAL -> Selecionando o schema pelo subdomínio criado - ex.: http://dentalpix1.localhost:8080/clinicas/1/dentistas
        	String tenantId = serverName.substring(0, serverName.indexOf("."));
        	
        	// ANTIGO -> Selecionando o schema pela passagem de parâmetros - ex.: http://localhost:8080/clinicas/1/dentistas?tenantid=dentalpix1
        	// String tenantId = attr.getRequest().getParameter("tenantid");       // find parameter from request
            return tenantId;
        } else {
            return "dentalpix1";  // default data source
        }
	}
}
