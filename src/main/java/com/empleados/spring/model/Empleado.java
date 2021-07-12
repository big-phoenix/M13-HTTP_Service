package com.empleados.spring.model;

import org.apache.logging.log4j.util.StringBuilderFormattable;

public class Empleado {

	private int id;
	
	private String nombre;
	private String faena;
	private double salario;
	
	public enum Puesto{
		
		PEON("PEON"),JEFE("JEFE");
		
		private String puesto;

		private Puesto(String puesto) {
			this.puesto = puesto;
		}
		
		public String getPuesto() {
			return puesto;
		}
		
	}
	
	public Empleado() {
		
	}
	
	public Empleado(int id, String nombre, String faena, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.faena = faena;
		this.salario = salario;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFaena() {
		return faena;
	}
	public void setFaena(String faena) {
		this.faena = faena;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", faena=" + faena + ", salario=" + salario + "]";
	}
	
	
	
	
}
