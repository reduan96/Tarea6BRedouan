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
public class Nif {

    //Atributos de la clase Nif
    private long numero;
    private char letra;
    private LocalDate fechaCaducidad;

    //Constructor de la clase Nif que al crearlo también te clacula la letra del
    //mismo automaticamente.
    public Nif(long numero) {

        this.numero = numero;
        this.fechaCaducidad = LocalDate.now();
        this.letra = calcularLetra(numero);
    }

    //Getters y Setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    //Hashcode y equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.numero ^ (this.numero >>> 32));
        hash = 13 * hash + this.letra;
        hash = 13 * hash + Objects.hashCode(this.fechaCaducidad);
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
        final Nif other = (Nif) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.letra != other.letra) {
            return false;
        }
        if (!Objects.equals(this.fechaCaducidad, other.fechaCaducidad)) {
            return false;
        }
        return true;
    }

    //Método toString
    @Override
    public String toString() {
        return "Nif{" + "numero=" + numero + ", letra=" + letra
                + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    //Método privado que calcula la letra en el propio constructor del nif
    private char calcularLetra(long numero) {

        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";

        int resultado = (int) numero % 23;

        return letrasDni.charAt(resultado);
    }

    //Método público que devuelve la pròxima fecha de renovación del dni
    public LocalDate renovar(LocalDate fechaSolicitud) {

        this.fechaCaducidad = fechaSolicitud.plusYears(10);
        return this.fechaCaducidad;
    }
}
