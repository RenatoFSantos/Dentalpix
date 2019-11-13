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
        	String tenantId = serverName.substring(0, serverName.indexOf("."));
        	System.out.println("Nome do schema selecionado => " + tenantId);
        	
//            String tenantId = attr.getRequest().getParameter("tenantId");       // find parameter from request
            return tenantId;
        } else {
            return "dentalpix1";             // default data source
        }
	}
}
