package com.gestaolixoeletronico.service;

import com.gestaolixoeletronico.entities.PontoColeta;
import com.gestaolixoeletronico.repository.PontoColetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoColetaService {
    private final PontoColetaRepository repository;

    public PontoColetaService(PontoColetaRepository repository) {
        this.repository = repository;
    }

    public List<PontoColeta> listarTodos() {
        return repository.findAll();
    }

    public Optional<PontoColeta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<PontoColeta> buscarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public PontoColeta salvar(PontoColeta pontoColeta) {
        return repository.save(pontoColeta);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
