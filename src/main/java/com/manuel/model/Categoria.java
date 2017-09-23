/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manuel.model;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
/**
 *
 * @author manuel
 */



@Entity
@Table(name= "categoria")
public class Categoria implements Serializable {
   
    @Id
   private int codigo;
   @Column(name = "nombre")
   private String nombre;
    @Column(name = "estado")
   private int estado;

    public Categoria() {
        this.codigo = 0;
        this.nombre = "";
        this.estado = 0;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
   
}
