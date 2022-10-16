package br.com.kalendae.test.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PessoaDto implements Serializable {

	private static final long serialVersionUID = -4486839834585602579L;
	
	private Long id;
	private String nome;
	private String email;
	
}
