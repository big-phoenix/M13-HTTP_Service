package com.empleados.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.empleados.spring.model.Empleado;
import com.empleados.spring.repository.*;

@Controller
@RequestMapping("")
public class Controlador {
	
	//BaseDatos bd = new BaseDatos();
	BaseDatosJDBC bd = new BaseDatosJDBC();

	@GetMapping("/demo1")
	public String index2(Model model) {
						
		return "demo";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		
		List<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados",empleados);
		model.addAttribute("boton", "A?adir Empleado");
		model.addAttribute("action", "/insertar");
						
		return "index";
	}
	
	
	@PostMapping("/insertar")
	public String insertar(Empleado empleado, Model model) {
		bd.inserta(empleado);
		ArrayList<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "A?adir Empleado");
		model.addAttribute("action", "/insertar");
		model.addAttribute("empleado", null);
		
		return "index";
	}
	
	@PostMapping("/insertar2")
	public String insertar2(Empleado empleado, Model model) {
		bd.inserta2(empleado);
		ArrayList<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "A?adir Empleado");
		model.addAttribute("action", "/insertar");
		model.addAttribute("empleado", null);
		
		return "index";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable int id, Model model) {
		bd.borrar(id);
		ArrayList<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "A?adir Empleado");
		model.addAttribute("action", "/insertar");
		
		return "index";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Empleado empleado = bd.getEmpleado(id);
		ArrayList<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("empleado", empleado);
		model.addAttribute("boton", "Editar Empleado");
		model.addAttribute("action", "/editar");
		
		return "index";
	}
	
	@PostMapping("/editar")
	public String editar2(Empleado empleado, Model model) {
		bd.editar(empleado);
		ArrayList<Empleado> empleados = bd.getEmpleados();
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Editar Empleado");
		model.addAttribute("action", "/insertar2");
		
		return "index";
	}
	
	
	@PostMapping("/faena")
	public String faena(String faena, Model model) {
	
		ArrayList<Empleado> empleados = bd.faena(faena);
		model.addAttribute("empleados", empleados);
		model.addAttribute("boton", "Editar Empleado");
		model.addAttribute("action", "/insertar");
		
		return "index";
	}
	
}
