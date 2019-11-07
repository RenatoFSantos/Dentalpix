package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.ClinicaDentista;
import com.midilabs.dentech.api.repository.clinica_dentista.ClinicaDentistaRepositoryQuery;

public interface ClinicaDentistaRepository extends JpaRepository<ClinicaDentista, Long>, ClinicaDentistaRepositoryQuery {

}
