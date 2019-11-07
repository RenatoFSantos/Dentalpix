package com.midilabs.dentech.api.repository.responsavel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midilabs.dentech.api.model.vo.Responsavel;
import com.midilabs.dentech.api.repository.filter.ResponsavelFilter;

public interface ResponsavelRepositoryQuery {
	
	public Page<Responsavel> filtrar(ResponsavelFilter responsavelFilter, Pageable pageable);

}
