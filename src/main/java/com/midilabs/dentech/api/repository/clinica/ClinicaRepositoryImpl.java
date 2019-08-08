package com.midilabs.dentech.api.repository.clinica;

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

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.model.vo.Clinica_;
import com.midilabs.dentech.api.repository.filter.ClinicaFilter;
import com.midilabs.dentech.api.resource.projection.ResumoClinica;

public class ClinicaRepositoryImpl implements ClinicaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	public Page<Clinica> filtrar(ClinicaFilter clinicaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Clinica> criteria = builder.createQuery(Clinica.class);
		Root<Clinica> root = criteria.from(Clinica.class);
		
		// --- criar as restrições
		Predicate[] predicates = criarRestricoes(clinicaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Clinica> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(clinicaFilter));
	}

	@Override
	public Page<ResumoClinica> resumir(ClinicaFilter clinicaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoClinica> criteria = builder.createQuery(ResumoClinica.class);
		Root<Clinica> root = criteria.from(Clinica.class);
		
		criteria.select(builder.construct(ResumoClinica.class
				, root.get(Clinica_.ID)
				, root.get(Clinica_.CLIN_NM_CLINICA)
				, root.get(Clinica_.CLIN_IN_ATIVO)));
		
		// --- criar as restrições
		Predicate[] predicates = criarRestricoes(clinicaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoClinica> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(clinicaFilter));
		
	}
	
	private Predicate[] criarRestricoes(ClinicaFilter clinicaFilter, CriteriaBuilder builder, Root<Clinica> root) {
		List<Predicate> predicates = new ArrayList<>();
		// where nome like "%conteudo procurado%"
		if (!StringUtils.isEmpty(clinicaFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Clinica_.CLIN_NM_CLINICA)), "%" + clinicaFilter.getNome().toLowerCase() + "%"));
		}

		if (clinicaFilter.getDocumento() != null) {
			predicates.add(builder.like(
					builder.lower(root.get(Clinica_.CLIN_CD_DOCUMENTO)), "%" + clinicaFilter.getDocumento().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Long total(ClinicaFilter clinicaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Clinica> root = criteria.from(Clinica.class);
		
		Predicate[] predicates = criarRestricoes(clinicaFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
 		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
		
	}


}
