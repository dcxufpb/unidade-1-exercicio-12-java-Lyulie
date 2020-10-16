package com.example.project;

public class Loja {

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, Endereco endereco, String telefone,
                String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static boolean isNullEmpty(String text) {
		try{
			int k = text.length();
		} catch (NullPointerException npe) {
			return true;
		}
		return text.isEmpty();
	}

    public String dadosLoja() {
        // Implemente aqui
        validarCamposObrigatorios();

        String _telefone = isNullEmpty(getTelefone())? "" : "Tel " + getTelefone();
        _telefone = (!_telefone.isEmpty() && !isNullEmpty(endereco.getCep()))? " " + _telefone : _telefone;
		
		String _observacao = isNullEmpty(getObservacao())? "" : getObservacao();				
		String _cnpj = "CNPJ: " + getCnpj();
		String _inscricao_estadual = "IE: " + getInscricaoEstadual();

		String output = getNomeLoja() + "\n";
        output += endereco.dadosEndereco();
        output += _telefone + "\n";
		output += _observacao + "\n";
		output += _cnpj + "\n";
		output += _inscricao_estadual + "\n";

		return output.replace("\n", System.lineSeparator());
    }
    
    public void validarCamposObrigatorios() {

        if(isNullEmpty(getNomeLoja()))
			throw new RuntimeException("O campo nome da loja é obrigatório");
		
		if(isNullEmpty(getCnpj()))
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
	
		if(isNullEmpty(getInscricaoEstadual()))
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
    }
}