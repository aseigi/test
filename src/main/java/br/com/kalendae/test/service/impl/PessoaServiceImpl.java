package br.com.kalendae.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.kalendae.test.dto.PessoaDto;
import br.com.kalendae.test.entity.Pessoa;
import br.com.kalendae.test.exception.RegistroNaoEncontradoException;
import br.com.kalendae.test.repository.PessoaRepository;
import br.com.kalendae.test.repository.mapper.PessoaMapper;
import br.com.kalendae.test.service.PessoaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

	private final PessoaRepository pessoaRepository;
	private final PessoaMapper pessoaMapper;
	
	@Override
	public List<PessoaDto> listarTodos() {
		return pessoaRepository.findAll().stream()
				.map(p -> pessoaMapper.toDto(p))
				.collect(Collectors.toList());
	}

	@Override
	public PessoaDto recuperarPorId(Long id) throws RegistroNaoEncontradoException {
		return pessoaRepository.findById(id)
				.map(p -> pessoaMapper.toDto(p))
				.orElseThrow(RegistroNaoEncontradoException::new);
	}

	@Override
	public PessoaDto inserir(PessoaDto pessoaDto) {
		Pessoa pessoa = pessoaRepository.save(pessoaMapper.toEntity(pessoaDto));
		return pessoaMapper.toDto(pessoa);
	}

	@Override
	public void atualizar(PessoaDto pessoaDto) throws RegistroNaoEncontradoException {
		pessoaRepository.findById(pessoaDto.getId())
			.ifPresentOrElse(p -> {
				p.setNome(pessoaDto.getNome());
				p.setEmail(pessoaDto.getEmail());
				pessoaRepository.save(p);
			},
				() ->  new RegistroNaoEncontradoException()
			);
	}

	@Override
	public void remover(Long id) throws RegistroNaoEncontradoException {
		pessoaRepository.findById(id)
			.ifPresentOrElse(p -> pessoaRepository.delete(p), () ->  new RegistroNaoEncontradoException());
	}

}
