package com.jltg.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;

	@NotEmpty(message = "El campo nombre no puede estar vacio")
	@Size(min = 3, max = 60, message = "El campo nombre debe tener minimo 3 caracteres y maximo 60")
	@Column(name = "nombre", nullable = false, length = 60)
	private String nombre;

	@NotEmpty(message = "El campo marca no puede estar vacio")
	@Size(min = 3, max = 60, message = "El campo marca debe tener minimo 3 caracteres y maximo 40")
	@Column(name = "marca", nullable = false, length = 40)
	private String marca;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
