/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appDeporte.BuscadorDeportista.Controladores;

import com.appDeporte.BuscadorDeportista.Enumeraciones.Deporte;
import com.appDeporte.BuscadorDeportista.Enumeraciones.Rol;
import com.appDeporte.BuscadorDeportista.Excepciones.MiException;
import com.appDeporte.BuscadorDeportista.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index() {

        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "usuario_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre,@RequestParam String apellido,@RequestParam String username, @RequestParam String email, @RequestParam String password,@RequestParam Integer edad,@RequestParam String sobreMi,  ModelMap modelo) {

        try {
            usuarioServicio.registrar(username, nombre, apellido, email, password, edad, sobreMi, Deporte.VOLEY, Rol.ClUB);

            modelo.put("exito", "Usuario exitosimente registrado");
            

            return "index.html";
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);

            return "registro.html";
        }

    }
}
