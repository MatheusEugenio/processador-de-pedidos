package core.model;

import core.model.dateformatter.Dateformatter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Produto> produtos;
    private int idade;

    public Cliente(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = LocalDate.parse(dataNascimento, Dateformatter.formatter);
        this.idade = 0;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (this.produtos != null) {
            this.produtos.add(produto);
        }

        throw new IllegalArgumentException("O produto não pode ser nulo!");
    }

    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public int getIdade() {return idade;}
}
