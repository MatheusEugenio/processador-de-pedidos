package core.domain.model;

import core.domain.model.user.Age;
import core.domain.model.user.Cpf;
import core.domain.model.user.Name;
import infra.util.Dateformatter;

import java.time.LocalDate;

public class Cliente {

    private Name nome;
    private Cpf cpf;
    private LocalDate dataNascimento;
    private Age idade;
    private Double saldo;

    public Cliente(Name nome, Cpf cpf, Age idade, String dataNascimento, double depositoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = LocalDate.parse(dataNascimento, Dateformatter.formatter);
        this.idade = idade;
        this.saldo = depositoInicial;
    }

    public String getNome() {return nome.getNome();}
}
