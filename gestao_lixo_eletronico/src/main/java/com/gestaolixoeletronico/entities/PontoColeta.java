package com.gestaolixoeletronico.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pontos_coleta")
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String endereco;
    private String numero;
    private String bairro;
    private String diasFuncionamento;
    private String horarioAbertura;
    private String horarioFechamento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public PontoColeta() {
    }

    public PontoColeta(String name, String endereco, String numero, String bairro, String diasFuncionamento, String horarioAbertura, String horarioFechamento, Usuario usuario) {
        this.name = name;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.diasFuncionamento = diasFuncionamento;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
