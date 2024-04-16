package com.jltg.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@NotEmpty(message = "{persona.nombres.notEmpty}")
	@Size(min = 3, max = 70, message = "{persona.nombres.size}")
	@Pattern(regexp = "[a-zA-Z ]+", message = "{persona.nombres.pattern}")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@NotEmpty(message = "{persona.apellidos.notEmpty}")
	@Size(min = 3, max = 70, message = "{persona.apellidos.size}")
	@Pattern(regexp = "[a-zA-Z ]+", message = "{persona.apellidos.pattern}")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
