package com.empleados.spring.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.empleados.spring.model.Empleado;
import com.empleados.spring.repository.BaseDatosJDBC;

@RestController
@RequestMapping("api/v1")
public class EmpleadosController {
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Empleado>> allEmpleados(){
		
		ResponseEntity<List<Empleado>> respuesta;
		BaseDatosJDBC bd = new BaseDatosJDBC();
		
		try {
			ResponseEntity<List<Empleado>> responseEntity = new ResponseEntity<List<Empleado>>(bd.getEmpleados(), HttpStatus.OK);
			respuesta=responseEntity;
		} catch (Exception e) {
			respuesta = new ResponseEntity<List<Empleado>>(HttpStatus.BAD_REQUEST);
		}
		
		return respuesta;
	}
	
	@GetMapping("/faena/{faena}")
	public ResponseEntity<List<Empleado>> faenaEmpleados(@PathVariable("faena") String faena){
		
		ResponseEntity<List<Empleado>> respuesta;
		BaseDatosJDBC bd = new BaseDatosJDBC();
		
		try {
			ResponseEntity<List<Empleado>> responseEntity = new ResponseEntity<List<Empleado>>(bd.faena(faena), HttpStatus.OK);
			respuesta=responseEntity;
		} catch (Exception e) {
			respuesta = new ResponseEntity<List<Empleado>>(HttpStatus.BAD_REQUEST);
		}
		
		return respuesta;
	}
	
}
