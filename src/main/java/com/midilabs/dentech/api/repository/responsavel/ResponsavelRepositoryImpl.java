package com.midilabs.dentech.api.repository.responsavel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.midilabs.dentech.api.model.vo.Responsavel;
import com.midilabs.dentech.api.model.vo.Responsavel_;
import com.midilabs.dentech.api.repository.filter.ResponsavelFilter;

public class ResponsavelRepositoryImpl implements ResponsavelRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Responsavel> filtrar(ResponsavelFilter responsavelFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Responsavel> criteria = builder.createQuery(Responsavel.class);
		Root<Responsavel> root = criteria.from(Responsavel.class);
		
		// --- Criar as restrições
		Predicate[] predicates = criarRestricoes(responsavelFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Responsavel> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(responsavelFilter));
	}
	

	private void adicionarRestricoesDePaginacao(TypedQuery<Responsavel> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(ResponsavelFilter responsavelFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Responsavel> root = criteria.from(Responsavel.class);
		
		Predicate[] predicates = criarRestricoes(responsavelFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}


	private Predicate[] criarRestricoes(ResponsavelFilter responsavelFilter, CriteriaBuilder builder, Root<Responsavel> root) {
		List<Predicate> predicates = new ArrayList<>();
		// where nome like "%conteudo procurado%"
		if(!StringUtils.isEmpty(responsavelFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Responsavel_.RESP_NM_RESPONSAVEL)), "%" + responsavelFilter.getNome().toLowerCase() + "%"));
		}
			
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}
