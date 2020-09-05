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

import br.cesed.si.pp.banco.model.Conta;
import br.cesed.si.pp.banco.model.Conta;
import br.cesed.si.pp.banco.service.ContaService;
import br.cesed.si.pp.banco.service.ContaService;

public class ContaController {

	@Autowired
	private ContaService Cservice;
	
	private ContaService Aservice;
	
	@PostMapping("/conta")
	public ResponseEntity<Conta> criarNovaConta(@RequestBody Conta novaConta) {
		if(Cservice.buscarContaPorId(novaConta.getNumero()) == null && Aservice.buscarContaPorId(novaConta.getNumero()) != null) {
			Conta contaCriada = Cservice.salvarConta(novaConta);
			return new ResponseEntity<Conta>(contaCriada, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Conta>(novaConta, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/conta")
	public ResponseEntity<Conta> consultarConta(@RequestBody int id){
		
		Conta contaObtida = Cservice.buscarContaPorId(id);
		
		if(contaObtida != null) {
			return new ResponseEntity<Conta>(contaObtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Conta>(contaObtida, HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/conta")
	public ResponseEntity<List<Conta>> listarContas(){
	
		List<Conta> entities = Cservice.listarTodasContas();
		
		return new ResponseEntity<List<Conta>>(entities, HttpStatus.OK);
	}
	
	@DeleteMapping("/conta")
	public ResponseEntity<Conta> deletarContaPorId(int id){
		
		Conta contaObtida = Cservice.buscarContaPorId(id);
		if(contaObtida != null) {
			Cservice.deletarContaPorId(id);
			return new ResponseEntity<Conta>(contaObtida, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Conta>(contaObtida, HttpStatus.NO_CONTENT); 
		}	
	}
	
	@PutMapping("/conta")
	public ResponseEntity<Conta> atualizarConta(Conta conta){
		if(Cservice.atualizarConta(conta) != null) {
			return new ResponseEntity<Conta>(conta, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Conta>(conta, HttpStatus.NOT_FOUND);
		}
	}
}