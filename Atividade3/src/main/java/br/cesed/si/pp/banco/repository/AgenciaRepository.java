package br.cesed.si.pp.banco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.cesed.si.pp.banco.model.Agencia;

@RepositoryRestResource(collectionResourceRel = "agencias", path = "agencias")
public interface AgenciaRepository extends CrudRepository<Agencia, Integer>{

}