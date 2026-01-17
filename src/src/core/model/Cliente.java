package core.model;

import core.model.tiposDeProduto.Produto;
import core.usecases.Dateformatter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private int idade;
    private List<Produto> produtos;

    public Cliente(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = LocalDate.parse(dataNascimento, Dateformatter.formatter);
        this.idade = 0;
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {return produtos;}
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public int getIdade() {return idade;}
}
