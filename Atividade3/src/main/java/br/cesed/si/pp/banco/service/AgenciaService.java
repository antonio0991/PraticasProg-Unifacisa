package br.cesed.si.pp.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.pp.banco.model.Agencia;
import br.cesed.si.pp.banco.repository.AgenciaRepository;

@Service @Validated
public class AgenciaService {

	@Autowired
	private AgenciaRepository repository;
	
	public Agencia salvarAgencia(Agencia novaAgencia) {
		
		return repository.save(novaAgencia);
		
	}
	
	public Agencia buscarAgenciaPorId(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Agencia> listarTodasAgencias(){
		return (List<Agencia>) repository.findAll();
	}
	
	public void deletarAgenciaPorId(int id) {
		repository.deleteById(id);
	}
	
	public Agencia atualizarAgencia(Agencia agencia) {
		Agencia existeAgencia = repository.findById(agencia.getNumero()).orElse(null);
		if(existeAgencia != null) {
			existeAgencia.setGerente(agencia.getGerente());
			return repository.save(agencia);
		}
		else {
			return null;
		}
	}

}
