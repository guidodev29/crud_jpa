package com.mycompany.demojpalocal;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudiante implements Serializable{

    public Estudiante() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public Estudiante( String id, String carnet, String nombres, String apellidos) {
        this.id = id;
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    private String carnet;
    private String nombres;
    private String apellidos;

    public void setNombre(String mateo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
