package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoTO extends RepresentationModel<VehiculoTO> implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private Integer id;
	
	
	private String placa;
	

	private String modelo;
	
	
	private String fabrica;
	
	
	private String anio;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getFabrica() {
		return fabrica;
	}


	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
