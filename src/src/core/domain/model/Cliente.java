package core.domain.model;

import infra.util.Dateformatter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private Long cpf;
    private LocalDate dataNascimento;
    private int idade;
    private Double saldo;

    public Cliente(String nome, Long cpf,int idade, String dataNascimento, double depositoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = LocalDate.parse(dataNascimento, Dateformatter.formatter);
        this.idade = idade;
        this.saldo = depositoInicial;
    }

    public Double getSaldo() {return saldo;}
    public void setSaldo(Double saldo) {this.saldo = saldo;}
    public String getNome() {return nome;}
    public Long getCpf() {return cpf;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public int getIdade() {return idade;}
}
