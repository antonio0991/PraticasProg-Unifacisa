package br.unifacisa.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Employees {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cpf;
	private String nome;
	private double salario;
}

