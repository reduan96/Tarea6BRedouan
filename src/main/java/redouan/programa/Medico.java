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
public class Medico extends Empleado{
    
    private String especialidad;

    public Medico(String especialidad, String numSS, double salario, 
            String nombre, String apellidos, Nif nif) {
        super(numSS, salario, nombre, apellidos, nif);
        this.especialidad = especialidad;
    }

    //Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.especialidad);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.especialidad, other.especialidad)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + '}';
    }
    
    //Método que trata al paciente objeto pasado por parámetro y la medicina
    //a dar en objeto String
    public void tratar(Paciente p, String medicina){
        
        p.tomarMedicina(medicina);
    }
    
    //Método que calcula la retención del sueldo en base al tanto % que se indica
    @Override
    public double calcularIRPF() {
       
        return this.getSalario() * 0.21;
    }

}
