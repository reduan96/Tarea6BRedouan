/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redouan.programa;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author redu2
 */
public class Hospital {
    
    //Atributos de la clase hospital con la lista de pacientes y empleados
    private String nombre;
    private String direccion;
    private int numeroCamas;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Empleado> listaEmpleados;

    //Constructor de la clase hospital
    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.listaPacientes = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.direccion);
        hash = 43 * hash + this.numeroCamas;
        hash = 43 * hash + Objects.hashCode(this.listaPacientes);
        hash = 43 * hash + Objects.hashCode(this.listaEmpleados);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hospital other = (Hospital) obj;
        if (this.numeroCamas != other.numeroCamas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.listaPacientes, other.listaPacientes)) {
            return false;
        }
        if (!Objects.equals(this.listaEmpleados, other.listaEmpleados)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Hospital{" + "nombre=" + nombre + ", direccion=" + 
                direccion + ", numeroCamas=" + numeroCamas + ", listaPacientes="
                + listaPacientes + ", listaEmpleados=" + listaEmpleados + '}';
    }
    
    //Método que añade un objeto empleado a la lista de empleados
    public void contratarEmpleado(Empleado e){
        
        this.listaEmpleados.add(e);
        System.out.println("Añadido al empleado " + e.getNombre() + e.getApellidos()
        + " con exito a la base de datos del hospital");
    }
    
    //Método que añade un objeto paciente a la lista de pacientes
    public void ingresarPaciente(Paciente p){
        
        this.listaPacientes.add(p);
        System.out.println("Añadido al paciente " + p.getNombre() + p.getApellidos()
        + " con exito a la base de datos del hospital");
    }
}
