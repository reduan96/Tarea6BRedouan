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
public class Administrativo extends Empleado{

    //Atributos de la clase Administrativo
    private GrupoAdmin grupo;

    //Constructor de la clase admin con su super de la clase empleado
    public Administrativo(GrupoAdmin grupo, String numSS, double salario, 
            String nombre, String apellidos, Nif nif) {
        super(numSS, salario, nombre, apellidos, nif);
        this.grupo = grupo;
    }

    
    //Getters y Setters
    public GrupoAdmin getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoAdmin grupo) {
        this.grupo = grupo;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.grupo);
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
        final Administrativo other = (Administrativo) obj;
        if (this.grupo != other.grupo) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Administrativo{" + "grupo=" + grupo + '}';
    }
    
    //Método de registración de documentación
    public void registrarDocumento(){
        
        System.out.println("Registrando documentación...");
    }
    
    //Método que calcula el IRPF del administrativo según al grupo que pertenezca
    @Override
    public double calcularIRPF() {
        
        if(this.getGrupo().equals(grupo.GRUPOA)){
            
            return this.getSalario() * 0.18;
        }else{
            
            return this.getSalario() * 0.16;
        }
    }
}
