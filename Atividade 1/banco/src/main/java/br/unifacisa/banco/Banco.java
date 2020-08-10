package br.unifacisa.banco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Banco {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int identification;
	private String nome;
	private String localSede;
}
