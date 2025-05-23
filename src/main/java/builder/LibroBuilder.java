/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import DTO.LibroDTO;

/**
 *
 * @author paula
 */
public class LibroBuilder {
    
    private String titulo;
    private String autor;
    private int año;
    private String genero;
    private String fechaLectura;
    private int usuarioId;
    private int idLibro = 0; 

    public LibroBuilder setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
        return this;
    }

    public LibroDTO build() {
        return new LibroDTO(titulo, autor, año, genero, fechaLectura, usuarioId, idLibro);
    }

    public LibroBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public LibroBuilder setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LibroBuilder setAño(int año) {
        this.año = año;
        return this;
    }

    public LibroBuilder setGenero(String genero) {
        this.genero = genero;
        return this;
    }
    
     public LibroBuilder setFechaLectura(String fechaLectura) {
        this.fechaLectura = fechaLectura;
        return this;
    }
}
