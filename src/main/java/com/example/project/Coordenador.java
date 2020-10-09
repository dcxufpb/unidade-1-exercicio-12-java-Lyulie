package com.example.project;

public class Coordenador {
    private String nome;
    private String cpf;
    private int idade;

    public Coordenador(
        String nome, 
        String cpf, 
        int idade
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void validarCamposObrigatoriosCoordenador() {
        if(Departamento.isNullEmpty(this.nome)) {
            throw new RuntimeException("O nome do coordenador é obrigatório");
        }

        if(Departamento.isNullEmpty(this.cpf)) {
            throw new RuntimeException("O CPF do coordenador é obrigatório.");
        }
    }

    public String dados_coordenador() {

        validarCamposObrigatoriosCoordenador();

        String _idade = this.idade == 0? "" : "\nIdade: " + this.idade;
        String _cpf = "\nCPF: " + this.cpf;

        String output;
        output = "Coordenação:\n";
        output += this.nome;
        output += _idade;
        output += _cpf;

        return output;
    }



}