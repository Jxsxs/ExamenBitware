package com.examen.rest.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "clientes")
@JsonIgnoreProperties({"contraseña"})
public class Cliente {

	@Id
	private int id;
	private String Nombre_Usuario;
	private String Contraseña;
	private String nombre;
	private String Apellidos;
	private String correoElectronico;
	private int Edad;
	private double Estatura;
	private double Peso;
	private double IMC;
	private double GEB;
	private double ETA;
	private Date Fecha_Creacion;
	private Date Fecha_Actualizacion;

	public Cliente(int id, String Nombre_Usuario, String Contraseña, String nombre, String Apellidos,
			String correoElectronico, int Edad, double Estatura, double Peso, double IMC, double GEB, double ETA,
			Date Fecha_Creacion, Date Fecha_Actualizacion) {
		super();
		this.id = id;
		this.Nombre_Usuario = Nombre_Usuario;
		this.Contraseña = Contraseña;
		this.nombre = nombre;
		this.Apellidos = Apellidos;
		this.correoElectronico = correoElectronico;
		this.Edad = Edad;
		this.Estatura = Estatura;
		this.Peso = Peso;
		this.IMC = IMC;
		this.GEB = GEB;
		this.ETA = ETA;
		this.Fecha_Creacion = Fecha_Creacion;
		this.Fecha_Actualizacion = Fecha_Actualizacion;
	}

	public int getCliente_ID() {
		return id;
	}

	public void setCliente_ID(int id) {
		this.id = id;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String Nombre_Usuario) {
		this.Nombre_Usuario = Nombre_Usuario;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		this.Contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		this.Apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		this.Edad = edad;
	}

	public double getEstatura() {
		return Estatura;
	}

	public void setEstatura(double estatura) {
		this.Estatura = estatura;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		this.Peso = peso;
	}

	public double getIMC() {
		return IMC;
	}

	public void setIMC(double iMC) {
		this.IMC = iMC;
	}

	public double getGEB() {
		return GEB;
	}

	public void setGEB(double gEB) {
		this.GEB = gEB;
	}

	public double getETA() {
		return ETA;
	}

	public void setETA(double eTA) {
		this.ETA = eTA;
	}

	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		this.Fecha_Creacion = fecha_Creacion;
	}

	public Date getFecha_Actualizacion() {
		return Fecha_Actualizacion;
	}

	public void setFecha_Actualizacion(Date fecha_Actualizacion) {
		this.Fecha_Actualizacion = fecha_Actualizacion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", Nombre_Usuario=" + Nombre_Usuario + ", Contraseña=" + Contraseña + ", nombre="
				+ nombre + ", Apellidos=" + Apellidos + ", correoElectronico=" + correoElectronico + ", Edad=" + Edad
				+ ", Estatura=" + Estatura + ", Peso=" + Peso + ", IMC=" + IMC + ", GEB=" + GEB + ", ETA=" + ETA
				+ ", Fecha_Creacion=" + Fecha_Creacion + ", Fecha_Actualizacion=" + Fecha_Actualizacion + "]";
	}

	
}
