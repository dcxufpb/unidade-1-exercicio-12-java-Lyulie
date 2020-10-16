package com.example.project;

public class Departamento {
    private String nome;
    private String sigla;
    private String localizacao;
    private Coordenador coordenador;
    
    public static boolean isNullEmpty(String text) {
		try{
			int k = text.length();
		} catch (NullPointerException npe) {
			return true;
		}
		return text.isEmpty();
	}

    public Departamento(
        String nome, 
        String sigla, 
        String localizacao, 
        Coordenador coordenador
    ) {
        this.nome = nome;
        this.sigla = sigla;
        this.localizacao = localizacao;
        this.coordenador = coordenador;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Coordenador getCoordenador() {
        return this.coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public void validarCamposObrigatoriosDepartamento() {
        if (isNullEmpty(this.nome)) {
            throw new RuntimeException("O nome do departamento é obrigatório.");
        }

        if (isNullEmpty(this.localizacao)) {
            throw new RuntimeException("A localização do departamento é obrigatória.");
        }
    }

    public String dadosDepartamento() {
        
        validarCamposObrigatoriosDepartamento();

        String _nome = isNullEmpty(this.sigla)? this.nome : this.nome + ", ";
        String _sigla = isNullEmpty(this.sigla)? "" : this.sigla;
        String _localizacao = "Coordenadas: " + this.localizacao;

        String output;
        output = _nome + _sigla + "\n";
        output += _localizacao + "\n";
        output += this.coordenador.dados_coordenador();

        return output.replace("\n", System.lineSeparator());
    }

    public static void main(String[] args) {
        Coordenador coord = new Coordenador("Jose", "2222222222", 11);
        Departamento dept = new Departamento("Dept de ciencias", "null", "-7.1466035, -34.9518106", coord);

        System.out.println(dept.dadosDepartamento());
    }


}