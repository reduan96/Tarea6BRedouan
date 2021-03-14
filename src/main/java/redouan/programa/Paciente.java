/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redouan.programa;

import java.util.Objects;

/**
 *
 * @author redu2
 */
public class Paciente extends Persona{
    
    //Atributos de la clase paciente(extendida de la clase persona)
    private String numHistorial;

    //Constructor de paciente incluyendo el supe.(constructor de persona)
    public Paciente(String numHistorial, String nombre, String apellidos, 
            Nif nif) {
        super(nombre, apellidos, nif);
        this.numHistorial = numHistorial;
    }

    //Getters y Setters
    public String getNumHistorial() {
        return numHistorial;
    }

    public void setNumHistorial(String numHistorial) {
        this.numHistorial = numHistorial;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.numHistorial);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.numHistorial, other.numHistorial)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Paciente{" + "numHistorial=" + numHistorial + '}';
    }
    
    //Método tomar medicina
    public void tomarMedicina(String medicina){
        
        System.out.println("paciente " + this.getNombre() + this.getApellidos()
        + " ha tomado " + medicina);
    }
}
