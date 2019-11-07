package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.Responsavel;
import com.midilabs.dentech.api.repository.responsavel.ResponsavelRepositoryQuery;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>, ResponsavelRepositoryQuery {

}
