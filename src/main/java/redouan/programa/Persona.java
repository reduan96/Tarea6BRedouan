/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redouan.programa;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author redu2
 */
public class Persona {

    //Atributos de la clase persona
    private String nombre;
    private String apellidos;
    private Nif nif;

    //Constructor de la clase persona
    public Persona(String nombre, String apellidos, Nif nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }

    //Hashcode y equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellidos);
        hash = 59 * hash + Objects.hashCode(this.nif);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.nif, other.nif)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos="
                + apellidos + ", nif=" + nif + '}';
    }

    //Método renovar el dni que devuelve la proxima fecha de renovación
    public void renovarNif(LocalDate fechaSolicitud) {

        this.nif.renovar(fechaSolicitud);
    }
}
