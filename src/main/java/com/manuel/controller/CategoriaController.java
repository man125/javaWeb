/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manuel.controller;

import com.manuel.model.Categoria;
import com.manuel.session.CategoriaFacade;
import com.manuel.session.CategoriaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author manuel
 */
@Named("categoriaController")
@RequestScoped
public class CategoriaController implements Serializable{
    private Categoria categoria;
    
    @EJB
    private CategoriaFacadeLocal facade;
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
        
        System.out.println("aqui voy");
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public List<Categoria> listar(){           
            return this.facade.findAll();    
    }
    
    public void limpiar(){
        //mejorar con cni
        this.categoria = new Categoria();
    }
    
    public void eliminar(Categoria c){
        try{
            //pregintar confirmacion en el view
            facade.remove(c);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    
    public void registrar(){
        try{
            facade.create(categoria);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void modificar(){
         try{
            facade.edit(categoria);
            this.categoria = new Categoria();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
      // return "categoria";
    }
    
    public void edit(Categoria c){
        this.categoria = c;
        //return "editar";
    }
    
}
