package br.cesed.si.pp.banco.model;

import javax.persistence.*;
import lombok.*;

@Entity @Getter @Setter
public class Conta {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long numero;
	
	@Column(length = 50)
	private String titular;
	
	@Column(unique = true)
	private long cpf;
	
	@Column(precision = 2)
	private double saldo;
	
	@Column(precision = 2)
	private double limiteCredito;
	
	@Column(precision = 2)
	private double creditoUsado;

	private int agencia;
	
}