package br.unifacisa.banco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//A classe Conta representa a estrutura da tabela
@Data @Entity //Banco de dados CONTA com 4 colunas: numeroConta, numeroAgencia, titular e saldo.
public class Conta {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)//Identificador único da conta
	private int numero;
	private String titular;
	private double saldo;
	
}
