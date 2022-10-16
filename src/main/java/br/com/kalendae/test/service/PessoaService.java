package br.com.kalendae.test.service;

import java.util.List;

import br.com.kalendae.test.dto.PessoaDto;
import br.com.kalendae.test.exception.RegistroNaoEncontradoException;

public interface PessoaService {

	public List<PessoaDto> listarTodos();
	public PessoaDto recuperarPorId(Long id) throws RegistroNaoEncontradoException;
	public PessoaDto inserir(PessoaDto pessoaDto);
	public void atualizar(PessoaDto pessoaDto) throws RegistroNaoEncontradoException;
	public void remover(Long id) throws RegistroNaoEncontradoException;
}
