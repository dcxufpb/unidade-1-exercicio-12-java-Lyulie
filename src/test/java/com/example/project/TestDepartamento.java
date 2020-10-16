package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDepartamento {

    private void rodarTestarRetorno(
        String expected, 
        Departamento departamento
    ) {
		// action
		String retorno = departamento.dadosDepartamento();
		// assertion
		assertEquals(expected, retorno);
	}

	private void verificarCampoObrigatorio(
        String mensagemEsperada, 
        Departamento departamento
    ) {
		try {
            departamento.dadosDepartamento();
            assertEquals("RuntimeException", "pass");
		} catch (RuntimeException e) {
            assertEquals(mensagemEsperada, e.getMessage());
		}
	}

    private String NOME_DEPARTAMENTO = "Departamento 1";
    private String SIGLA = "Sigla 1";
    private String LOCALIZACAO = "1.1111111, 1.1111111";
    private String NOME_COORDENADOR = "Nome 1";
    private int IDADE = 11;
    private String CPF = "111.111.111-11";

    private String breakLine = System.lineSeparator();
    
    private String TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO = NOME_DEPARTAMENTO + 
        ", " + SIGLA + breakLine +
        "Coordenadas: " + LOCALIZACAO + breakLine +
        "Coordenação:" + breakLine +
        NOME_COORDENADOR + breakLine +
        "Idade: "+ IDADE + breakLine +
        "CPF: " + CPF;
    
    private String TEXTO_ESPERADO_SEM_SIGLA = NOME_DEPARTAMENTO + breakLine +
        "Coordenadas: " + LOCALIZACAO + breakLine +
        "Coordenação:" + breakLine +
        NOME_COORDENADOR + breakLine +
        "Idade: "+ IDADE + breakLine +
        "CPF: " + CPF;
    
    private String TEXTO_ESPERADO_SEM_IDADE = NOME_DEPARTAMENTO + 
        ", " + SIGLA + breakLine +
        "Coordenadas: " + LOCALIZACAO + breakLine +
        "Coordenação:" + breakLine +
        NOME_COORDENADOR + breakLine +
        "CPF: " + CPF;
    
    private String TEXTO_ESPERADO_SEM_SIGLA_SEM_IDADE = NOME_DEPARTAMENTO + breakLine +
        "Coordenadas: " + LOCALIZACAO + breakLine +
        "Coordenação:" + breakLine +
        NOME_COORDENADOR + breakLine +
        "CPF: " + CPF;


    private Coordenador coordenadorCompleto = new Coordenador(
        NOME_COORDENADOR, 
        CPF, 
        IDADE
    );

    private Departamento departamentoCompleto = new Departamento(
        NOME_DEPARTAMENTO, 
        SIGLA, 
        LOCALIZACAO, 
        coordenadorCompleto
    );
    
    @Test
    public void departamentoCompleto(){
        rodarTestarRetorno(TEXTO_ESPERADO_DEPARTAMENTO_COMPLETO, departamentoCompleto);
    }

    /**
     * Testar Campos Obrigatórios
     * @Departamento nome, localizacao
     * @Coordenador nome, cpf
     */

    private String MSG_ERR_NOME_DEPARTAMENTO = "O nome do departamento é obrigatório.";
    private String MSG_ERR_LOCALIZACAO = "A localização do departamento é obrigatória.";
    private String MSG_ERR_NOME_COORDENADOR = "O nome do coordenador é obrigatório";
    private String MSG_ERR_CPF = "O CPF do coordenador é obrigatório.";

    @Test
    public void validarNomeDepartamento(){

        Departamento departamentoNomeVazio = departamentoCompleto;
        departamentoNomeVazio.setNome("");
        verificarCampoObrigatorio(MSG_ERR_NOME_DEPARTAMENTO, departamentoNomeVazio);

        Departamento departamentoNomeNulo = departamentoCompleto;
        departamentoNomeNulo.setNome(null);
        verificarCampoObrigatorio(MSG_ERR_NOME_DEPARTAMENTO, departamentoNomeNulo);
    }

    @Test
    public void validarLocalizacao(){

        Departamento departamentoLocalizacaoVazia = departamentoCompleto;
        departamentoLocalizacaoVazia.setLocalizacao("");
        verificarCampoObrigatorio(MSG_ERR_LOCALIZACAO, departamentoLocalizacaoVazia);

        Departamento departamentoLocalizacaoNula = departamentoCompleto;
        departamentoLocalizacaoNula.setLocalizacao(null);
        verificarCampoObrigatorio(MSG_ERR_LOCALIZACAO, departamentoLocalizacaoNula);
    }

    @Test
    public void validarNomeCoordenador(){
        Coordenador coordenadorNomeVazio = coordenadorCompleto;
        coordenadorNomeVazio.setNome("");

        Departamento departamentoA = departamentoCompleto;
        departamentoA.setCoordenador(coordenadorNomeVazio);

        verificarCampoObrigatorio(MSG_ERR_NOME_COORDENADOR, departamentoA);

        Coordenador coordenadorNomeNulo = coordenadorCompleto;
        coordenadorNomeNulo.setNome(null);

        Departamento departamentoB = departamentoCompleto;
        departamentoB.setCoordenador(coordenadorNomeNulo);

        verificarCampoObrigatorio(MSG_ERR_NOME_COORDENADOR, departamentoB);
    }

    @Test
    public void validarCpfCoordenador(){
        Coordenador coordenadorCpfVazio = coordenadorCompleto;
        coordenadorCpfVazio.setCpf("");

        Departamento departamentoA = departamentoCompleto;
        departamentoA.setCoordenador(coordenadorCpfVazio);

        verificarCampoObrigatorio(MSG_ERR_CPF, departamentoA);

        Coordenador coordenadorCpfNulo = coordenadorCompleto;
        coordenadorCpfNulo.setCpf(null);

        Departamento departamentoB = departamentoCompleto;
        departamentoB.setCoordenador(coordenadorCpfNulo);

        verificarCampoObrigatorio(MSG_ERR_CPF, departamentoB);
    }

    /**
     * Testar Campos Opcionais
     * @Departamento sigla
     * @Coordenador idade
     */

    @Test
    public void validarSigla(){

        Departamento departamentoSiglaVazia = departamentoCompleto;
        departamentoSiglaVazia.setSigla("");
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA, departamentoSiglaVazia);

        Departamento departamentoSiglaNula = departamentoCompleto;
        departamentoSiglaNula.setSigla(null);
        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA, departamentoSiglaNula);
    }

    @Test
    public void validarIdade(){

        Coordenador coordenadorIdadeVazia = coordenadorCompleto;
        coordenadorIdadeVazia.setIdade(0);

        Departamento departamento = departamentoCompleto;
        departamento.setCoordenador(coordenadorIdadeVazia);

        rodarTestarRetorno(TEXTO_ESPERADO_SEM_IDADE, departamento);
    }

    @Test
    public void validarSiglaIdade(){

        Coordenador coordenadorIdadeVazia = coordenadorCompleto;
        coordenadorIdadeVazia.setIdade(0);

        Departamento departamentoSemSigla = departamentoCompleto;
        departamentoSemSigla.setSigla("");
        departamentoSemSigla.setCoordenador(coordenadorIdadeVazia);

        rodarTestarRetorno(TEXTO_ESPERADO_SEM_SIGLA_SEM_IDADE, departamentoSemSigla);
    }
}

