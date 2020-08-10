package br.unifacisa.banco;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta")//O path é o /conta em site.com/conta
public interface ContaRepository extends PagingAndSortingRepository<Conta, Integer>{

}
