package br.cesed.si.pp.banco.model;

import javax.persistence.*;
import lombok.*;

@Entity @Getter @Setter
public class Agencia {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	
	@Column(length = 50)
	private String gerente;	
}