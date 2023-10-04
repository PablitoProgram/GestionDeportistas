
package com.appDeporte.BuscadorDeportista.Entidades;

import com.appDeporte.BuscadorDeportista.Enumeraciones.Deporte;
import com.appDeporte.BuscadorDeportista.Enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Integer edad;
    private String sobreMi;
   @Enumerated(EnumType.STRING)
    private Deporte deporte;
   @Enumerated(EnumType.STRING)
   private Rol rol;
}
