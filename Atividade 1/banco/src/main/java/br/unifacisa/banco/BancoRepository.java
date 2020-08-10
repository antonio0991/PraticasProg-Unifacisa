package br.unifacisa.banco;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "banco", path = "banco")
public interface BancoRepository extends PagingAndSortingRepository<Conta, Integer>{
	
}
