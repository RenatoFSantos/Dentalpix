package com.midilabs.dentech.api.repository.paciente;

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

import com.midilabs.dentech.api.model.vo.Paciente;
import com.midilabs.dentech.api.model.vo.Paciente_;
import com.midilabs.dentech.api.repository.filter.PacienteFilter;

public class PacienteRepositoryImpl implements PacienteRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Paciente> filtrar(PacienteFilter pacienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Paciente> criteria = builder.createQuery(Paciente.class);
		Root<Paciente> root = criteria.from(Paciente.class);
		
		// --- Criando as restrições
		Predicate[] predicates = criarRestricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		
 		// --- Executando a Query
		TypedQuery<Paciente> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pacienteFilter));
	}

	private Predicate[] criarRestricoes(PacienteFilter pacienteFilter, CriteriaBuilder builder, Root<Paciente> root) {
		List<Predicate> predicates = new ArrayList<>();
		// where nome like "%conteudo procurado%"
		if(!StringUtils.isEmpty(pacienteFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Paciente_.PACI_NM_PACIENTE)), "%" + pacienteFilter.getNome().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(pacienteFilter.getCelular())) {
			predicates.add(builder.like(
					builder.lower(root.get(Paciente_.PACI_DS_CELULAR)), "%" + pacienteFilter.getCelular().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(pacienteFilter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get(Paciente_.PACI_DS_EMAIL)), "%" + pacienteFilter.getEmail().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Paciente> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
		
	}

	private Long total(PacienteFilter pacienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Paciente> root = criteria.from(Paciente.class);
		
		Predicate[] predicates = criarRestricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}


}
