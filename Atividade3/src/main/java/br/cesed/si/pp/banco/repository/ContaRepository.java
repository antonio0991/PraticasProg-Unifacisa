package br.cesed.si.pp.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.cesed.si.pp.banco.model.Conta;

@RepositoryRestResource(collectionResourceRel = "contas", path = "contas")
public interface ContaRepository extends CrudRepository<Conta, Long>{

}