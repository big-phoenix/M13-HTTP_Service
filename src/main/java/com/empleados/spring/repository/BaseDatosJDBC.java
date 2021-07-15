package com.empleados.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.empleados.spring.model.Empleado;
import com.empleados.spring.model.Empleado.Puesto;

public class BaseDatosJDBC {
	
	private Connection conexion;
	Puesto[] puestos = Puesto.values();

	public BaseDatosJDBC() {
		
		try {
			String conex="jdbc:mysql://localhost:3306/empleados";
			this.conexion = DriverManager.getConnection(conex,"root","");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<Empleado> getEmpleados() {
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		try {
			
			String sql = " select * from empleados";
			
			Statement s = conexion.createStatement();
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Empleado emp = new Empleado(rs.getInt(1), rs.getString(2), 
						                     rs.getString(3), rs.getDouble(4));
				
				empleados.add(emp);
			}
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
		return empleados;
	}

	
	public Empleado getEmpleado(int id) {
		
		Empleado empleado = null;
		
		try {
			
			String sql = " select * from empleados where id="+id;
			
			Statement s = conexion.createStatement();
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			
			empleado = new Empleado(rs.getInt(1), rs.getString(2), 
                    				rs.getString(3), rs.getDouble(4));
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
		return empleado;
	}
	
	
	
	public void inserta(Empleado empleado) {
		
		String sql = " select faena, salario from empleados";
		String query = " insert into empleados (id,nombre,faena,salario)"
				+ " values (?,?,?,?)";

		Double salarioEmpleado = 0.0;
		String fa = empleado.getFaena().toUpperCase();
		empleado.setFaena(fa);
		
		try {
			
		Statement s = conexion.createStatement();
		s.execute(sql);
		ResultSet rs = s.getResultSet();
		
		for(int i=0;i<puestos.length;i++) {
			if(fa.equals(puestos[i].getPuesto())) {
				
				
				while(rs.next()) {
					if(rs.getString(1).equals(empleado.getFaena())) {
						salarioEmpleado = rs.getDouble(2);
						break;
					}
				}
				empleado.setSalario(salarioEmpleado);
			} 
		
		}
		
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
		////----------------------------------------------------------////
		
		
		try {
			
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			preparedStatement.setInt(1, empleado.getId());
			preparedStatement.setString(2, empleado.getNombre());
			preparedStatement.setString(3, empleado.getFaena());
			preparedStatement.setDouble(4, empleado.getSalario());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
public void inserta2(Empleado empleado) {
		
		String query = " insert into empleados (id,nombre,faena,salario)"
				+ " values (?,?,?,?)";
	
		
		try {
			
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			preparedStatement.setInt(1, empleado.getId());
			preparedStatement.setString(2, empleado.getNombre());
			preparedStatement.setString(3, empleado.getFaena());
			preparedStatement.setDouble(4, empleado.getSalario());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	public void borrar(int id) {
		
		String sql = " delete from empleados where id="+id;
		
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	public void editar(Empleado empleado) {
		
		String sql = " update empleados set nombre=?, faena=?, salario=?"
						+ " where id=?";
		
		
		try {
			PreparedStatement preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(2, empleado.getFaena());
			preparedStatement.setDouble(3, empleado.getSalario());
			preparedStatement.setInt(4, empleado.getId());
			System.out.print(preparedStatement.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
	}
	
	
	public ArrayList<Empleado> faena(String faena) {
		
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		System.out.print(faena);
		
		try {
			
			String sql = " select * from empleados where faena='"+faena+"'";
			
			Statement s = conexion.createStatement();
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			
			while(rs.next()) {
				Empleado emp = new Empleado(rs.getInt(1), rs.getString(2), 
						                     rs.getString(3), rs.getDouble(4));
				
				empleados.add(emp);
			}
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
		return empleados;
		
	}
	
	
}
