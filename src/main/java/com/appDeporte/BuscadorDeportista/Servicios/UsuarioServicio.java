/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appDeporte.BuscadorDeportista.Servicios;

import com.appDeporte.BuscadorDeportista.Entidades.Usuario;
import com.appDeporte.BuscadorDeportista.Enumeraciones.Deporte;
import com.appDeporte.BuscadorDeportista.Enumeraciones.Rol;
import com.appDeporte.BuscadorDeportista.Repositorios.UsuarioRepositorio;
import com.appDeporte.BuscadorDeportista.Excepciones.MiException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Transactional
    public void registrar(String username, String nombre, String apellido, String email, String password, Integer edad, String sobreMi, Deporte deporte, Rol rol) throws MiException{
       
    validar(nombre, apellido, email, password, edad, sobreMi, deporte, rol);
       
    Usuario usuario = new Usuario();
    usuario.setUsername(username);
    usuario.setNombre(nombre);
    usuario.setApellido(apellido);
    usuario.setEmail(email);
    usuario.setEdad(edad);
    usuario.setPassword(password);
    usuario.setSobreMi(sobreMi);
    usuario.setDeporte(Deporte.HANDBALL);
    usuario.setRol(Rol.JUGADOR);
    usuarioRepositorio.save(usuario);
    }

private void validar(String nombre, String apellido, String email, String password, Integer edad, String sobreMi, Deporte deporte, Rol rol) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MiException("el email no puede ser nulo o estar vacio");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
        if (edad == null) {
            throw new MiException("la edad no puede ser nulo o estar vacío");
        }
        if (sobreMi.isEmpty() || sobreMi == null) {
            throw new MiException("Sobre mi no puede ser nulo o estar vacío");
        }
        if (deporte == null) {
            throw new MiException("el deporte no puede ser nulo o estar vacío");
        }
        if ( rol == null) {
            throw new MiException("el rol no puede ser nulo o estar vacío");
        }
        
}

   
}
/* private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Integer edad;
    private String sobreMi;
   @Enumerated(EnumType.STRING)
    private Deporte deporte;
   @Enumerated(EnumType.STRING)
   private Rol rol;*/