package com.midilabs.dentech.api.repository.clinica_dentista;

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

import com.midilabs.dentech.api.model.vo.ClinicaDentista;
import com.midilabs.dentech.api.model.vo.ClinicaDentista_;
import com.midilabs.dentech.api.model.vo.Clinica_;

public class ClinicaDentistaRepositoryImpl implements ClinicaDentistaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager; 

	@Override
	public Page<ClinicaDentista> listarDentistasPorClinica(Long id, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ClinicaDentista> criteria = builder.createQuery(ClinicaDentista.class);
		Root<ClinicaDentista> root = criteria.from(ClinicaDentista.class);
		
		Predicate[] predicates = criarRestricoes(id, builder, root);
		
		criteria.select(root);
		criteria.where(predicates);
		
		
		TypedQuery<ClinicaDentista> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(id));

	}

	@Override
	public Page<ClinicaDentista> listarClinicasPorDentista(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Predicate[] criarRestricoes(Long id, CriteriaBuilder builder, Root<ClinicaDentista> root) {
		List<Predicate> predicates = new ArrayList<>();
		// --- where clinica.id = id
		predicates.add(builder.equal(root.get(ClinicaDentista_.CLINICA).get(Clinica_.ID), id));
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Long total(Long id) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);	
		Root<ClinicaDentista> root = criteria.from(ClinicaDentista.class);
		
		Predicate[] predicates = criarRestricoes(id, builder, root);
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
