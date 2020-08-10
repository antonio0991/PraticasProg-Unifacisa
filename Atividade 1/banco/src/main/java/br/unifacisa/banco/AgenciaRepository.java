package br.unifacisa.banco;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "agencia", path = "agencia")
public interface AgenciaRepository extends PagingAndSortingRepository<Agencia, Integer>{

}
