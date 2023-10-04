/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appDeporte.BuscadorDeportista.Enumeraciones;

/**
 *
 * @author User
 */
public enum Deporte {
    FUTBOL("Futbol"),
    HANDBALL("Handball"),
    VOLEY("Voley"),
    BASQUET("Basquet");

    private String nombre;

    Deporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
}
