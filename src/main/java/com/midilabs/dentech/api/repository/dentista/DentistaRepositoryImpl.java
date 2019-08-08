package com.midilabs.dentech.api.repository.dentista;

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

import com.midilabs.dentech.api.model.vo.Dentista;
import com.midilabs.dentech.api.model.vo.Dentista_;
import com.midilabs.dentech.api.repository.filter.DentistaFilter;

public class DentistaRepositoryImpl implements DentistaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Dentista> filtrar(DentistaFilter dentistaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Dentista> criteria = builder.createQuery(Dentista.class);
		Root<Dentista> root = criteria.from(Dentista.class);
		
		// --- criar as restrições
		Predicate[] predicates = criarRestricoes(dentistaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Dentista> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(dentistaFilter));
	}

	private Predicate[] criarRestricoes(DentistaFilter dentistaFilter, CriteriaBuilder builder, Root<Dentista> root) {
		List<Predicate> predicates = new ArrayList<>();
		// where nome like "%conteudo procurado%"
		if(!StringUtils.isEmpty(dentistaFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Dentista_.DETT_NM_DENTISTA)), "%" + dentistaFilter.getNome().toLowerCase() + "%"));
		}

		if(dentistaFilter.getCro() != null) {
			predicates.add(builder.like(
					builder.lower(root.get(Dentista_.DETT_CD_CRO)), "%" + dentistaFilter.getCro().toLowerCase() + "%"));
		}

		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Dentista> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(DentistaFilter dentistaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Dentista> root = criteria.from(Dentista.class);
		
		Predicate[] predicates = criarRestricoes(dentistaFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

}
