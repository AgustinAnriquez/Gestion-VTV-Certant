package com.agustin.vtv.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "duenio")
@PrimaryKeyJoinColumn(referencedColumnName = "dnipersona")
public class Duenio extends Persona{
    
	@NotNull(message = "tipo no puede ser nulo")
	@Pattern(regexp ="([c][o][m][u][n]|[e][x][e][n][t][o])", message="Estado solo puede ser comun/exento (ingrese todo en minusculas)")
    private String tipo; 

    public Duenio() {}
    
	public Duenio(String dnipersona, String nombre, String apellido, String tipo) {
		super(dnipersona, nombre, apellido);
		this.tipo = tipo;
	}

	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

	

    
}
