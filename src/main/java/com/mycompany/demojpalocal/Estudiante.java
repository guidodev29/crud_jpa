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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String carnet;
    private String nombres;
    private String apellidos;

    public Estudiante( String carnet, String nombres, String apellidos) {
        
        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
}
