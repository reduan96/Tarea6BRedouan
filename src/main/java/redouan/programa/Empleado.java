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
public abstract class Empleado extends Persona{
    
    //Atributos de la clase abstracta empleado, hija de la clase persona
    private String numSS;
    private double salario;

    //Constructor de la clase empleado
    public Empleado(String numSS, double salario, String nombre, 
            String apellidos, Nif nif) {
        super(nombre, apellidos, nif);
        this.numSS = numSS;
        this.salario = salario;
    }

    //Getters y Setters
    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.numSS);
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
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
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.numSS, other.numSS)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Empleado{" + "numSS=" + numSS + ", salario=" + salario + '}';
    }
    
    //Método abstracto que se desarrollará en las clases hijas y al ser abstracto,
    //no posee cuerpo.
    public abstract double calcularIRPF();
}
