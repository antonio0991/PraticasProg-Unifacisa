package br.cesed.si.pp.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.pp.banco.model.Conta;
import br.cesed.si.pp.banco.model.Conta;
import br.cesed.si.pp.banco.repository.ContaRepository;

@Service @Validated
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	public Conta salvarConta(Conta novaConta) {
		
		long cpfNovaConta = novaConta.getCpf();
		
		//TODO verificar base de dados do SERASA por dívida
		
		return repository.save(novaConta);
	}
	
	public Conta buscarContaPorId(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Conta> listarTodasContas(){
		return (List<Conta>) repository.findAll();
	}
	
	public void deletarContaPorId(long id) {
		repository.deleteById(id);
	}
}
