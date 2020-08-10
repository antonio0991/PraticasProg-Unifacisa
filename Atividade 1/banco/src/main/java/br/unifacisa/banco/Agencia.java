package br.unifacisa.banco;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Agencia {
	@Id
	private int numero;
	private String gerente;
	private String telefone;
}
