package br.com.kalendae.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kalendae.test.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}