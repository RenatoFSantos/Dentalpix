package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.Dentista;
import com.midilabs.dentech.api.repository.dentista.DentistaRepositoryQuery;

public interface DentistaRepository extends JpaRepository<Dentista, Long>, DentistaRepositoryQuery {

}
