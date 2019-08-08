package com.midilabs.dentech.api.repository.dentista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.Dentista;
import com.midilabs.dentech.api.repository.filter.DentistaFilter;

public interface DentistaRepositoryQuery {

	public Page<Dentista> filtrar(DentistaFilter dentistafilter, Pageable pageable); 
	
}
