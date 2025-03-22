package com.gestaolixoeletronico.repository;

import com.gestaolixoeletronico.entities.PontoColeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
    List<PontoColeta> findByUsuarioId(Long usuarioId);
}
