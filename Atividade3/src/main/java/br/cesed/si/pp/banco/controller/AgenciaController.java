package br.cesed.si.pp.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.si.pp.banco.model.Agencia;
import br.cesed.si.pp.banco.service.AgenciaService;

@RestController @RequestMapping("/api/v1")
public class AgenciaController {

	
	@Autowired
	private AgenciaService service;
	
	@PostMapping("/agencia")
	public ResponseEntity<Agencia> criarNovaAgencia(@RequestBody Agencia novaAgencia) {
		if(service.buscarAgenciaPorId(novaAgencia.getNumero()) == null) {
			Agencia agenciaCriada = service.salvarAgencia(novaAgencia);
			return new ResponseEntity<Agencia>(agenciaCriada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Agencia>(novaAgencia, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/agencia")
	public ResponseEntity<Agencia> consultarAgencia(@RequestBody int id){
		
		Agencia agenciaObtida = service.buscarAgenciaPorId(id);
		
		if(agenciaObtida != null) {
			return new ResponseEntity<Agencia>(agenciaObtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Agencia>(agenciaObtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/agencia")
	public ResponseEntity<List<Agencia>> listarAgencias(){
	
		List<Agencia> entities = service.listarTodasAgencias();
		
		return new ResponseEntity<List<Agencia>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/agencia")
	public ResponseEntity<Agencia> deletarAgenciaPorId(int id){
		
		Agencia agenciaObtida = service.buscarAgenciaPorId(id);
		if(agenciaObtida != null) {
			service.deletarAgenciaPorId(id);
			return new ResponseEntity<Agencia>(agenciaObtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Agencia>(agenciaObtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/agencia")
	public ResponseEntity<Agencia> atualizarAgencia(Agencia agencia){
		if(service.atualizarAgencia(agencia) != null) {
			return new ResponseEntity<Agencia>(agencia, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Agencia>(agencia, HttpStatus.NOT_FOUND);
		}
	}
}
