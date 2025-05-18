/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author paula
 */
public class LibroFavorito extends LibroDecorator {
    
    public LibroFavorito(Libro libro) {
        super(libro);
    }

    @Override
    public String getDescripcion() {
        return libro.getDescripcion() + " [Favorito]";
    }
}
