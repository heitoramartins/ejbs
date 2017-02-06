package com.ejb.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="carro")
public class Carro implements AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
				
	@Column(name="marca")
	private String marca;
		
	@ManyToOne
	@JoinColumn(name="fk_modelo")
	private Modelo modelo;
	
	@Column(name="placa")
	private String placa;
	
	@Transient
	private BigDecimal valor;
	
	@Transient
	public boolean isGM(){
		return modelo.getDescricao().equals("GM"); 
	}
	@Transient
	public boolean isFord(){
		return modelo.getDescricao().equals("FORD");
	}
	@Transient
	public boolean isOutras(){
		return !modelo.getDescricao().equals("FORD")
				&& !modelo.getDescricao().equals("GM");
	}
								
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
		
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", valor=" + valor
				+ "]";
	}

	

		
	

}
