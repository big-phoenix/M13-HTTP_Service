package com.empleados.spring.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.thymeleaf.expression.Arrays;

import com.empleados.spring.EmpleadosWebApplication;
import com.empleados.spring.model.Empleado;
import com.empleados.spring.model.Empleado.Puesto;




public class BaseDatos {

	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	Puesto[] puestos = Puesto.values();
	
		
	public BaseDatos() {
		
		empleados.add(new Empleado(1, "pepe", puestos[0].getPuesto(),0));
		empleados.add(new Empleado(2, "laura", puestos[0].getPuesto(),0));
		empleados.add(new Empleado(3, "Francisco", puestos[1].getPuesto(),0));
		empleados.add(new Empleado(4, "Eva", puestos[1].getPuesto(),0));
		
		for (Empleado empleado : empleados) {
			if(empleado.getFaena()==puestos[0].getPuesto()) empleado.setSalario(1500);
			if(empleado.getFaena()==puestos[1].getPuesto()) empleado.setSalario(1900);
			
		}
		
	}
	

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public Empleado getEmpleado(int id) {
		return empleados.get(id-1);
	}
	
	
	public void inserta(Empleado empleado) {
		
		Double salarioEmpleado = 0.0;
		String fa = empleado.getFaena().toUpperCase();
		empleado.setFaena(fa);
		int id = empleados.size();
		empleado.setId(id+1);
		
		
		for(int i=0;i<puestos.length;i++) {
			if(fa.equals(puestos[i].getPuesto())) {
				
				Iterator<Empleado> empl = empleados.iterator();
				while(empl.hasNext()) {
					Empleado emp = empl.next();
					if(emp.getFaena().equals(empleado.getFaena())) {
						salarioEmpleado = emp.getSalario();
						break;
					}
				}
				empleado.setSalario(salarioEmpleado);
				empleados.add(empleado);
			} 
		
		}
	}
	
	public void inserta2(Empleado empleado) {
		empleados.add(empleado);
	}
	
	
	public void borrar(int id) {
		Iterator<Empleado> empleado = empleados.iterator();
		while(empleado.hasNext()) {
			Empleado emp = empleado.next();
			if(emp.getId()==id) {
				empleado.remove();
				break;
			}
		}
	}
	
	public void editar(Empleado empleado) {
		Iterator<Empleado> it = empleados.iterator();
		while(it.hasNext()) {
			Empleado li = it.next();
			if(li.getId()==empleado.getId()) {
				
				li.setNombre(empleado.getNombre());
				li.setFaena(empleado.getFaena());
				li.setSalario(empleado.getSalario());
	
				break;
			}
		}
	}
	
	
	public ArrayList<Empleado> faena(String faena) {
		
		Iterator<Empleado> it = empleados.iterator();
		ArrayList<Empleado> empFaena =  new ArrayList<Empleado>();
		String fa = faena.toUpperCase();
				
		while(it.hasNext()) {
			Empleado li = it.next();
			
				if(fa.equals(li.getFaena())) {
					empFaena.add(li);
				}
				
		}
		
		return empFaena;
		
	}
	
	
	
}
