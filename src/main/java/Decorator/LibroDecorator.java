/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author paula
 */
public abstract class LibroDecorator implements Libro {
    protected Libro libro;

    public LibroDecorator(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String getDescripcion() {
        return libro.getDescripcion();
    }
}
