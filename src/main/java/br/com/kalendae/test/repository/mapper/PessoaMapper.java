package br.com.kalendae.test.repository.mapper;

import org.mapstruct.Mapper;

import br.com.kalendae.test.dto.PessoaDto;
import br.com.kalendae.test.entity.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	PessoaDto toDto(Pessoa pessoa);
	Pessoa toEntity(PessoaDto pessoaDto);
}