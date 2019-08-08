package com.midilabs.dentech.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.midilabs.dentech.api.model.vo.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
