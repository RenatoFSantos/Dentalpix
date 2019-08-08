package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.Clinica;
import com.midilabs.dentech.api.repository.clinica.ClinicaRepositoryQuery;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>, ClinicaRepositoryQuery {

}
