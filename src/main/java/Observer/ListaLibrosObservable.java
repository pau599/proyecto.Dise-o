/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import DTO.LibroDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class ListaLibrosObservable extends Sujeto {
    
    private List<LibroDTO> libros = new ArrayList<>();

    public void agregarLibro(LibroDTO libro) {
        libros.add(libro);
        notificarObservadores();
    }

    public void eliminarLibro(LibroDTO libro) {
        libros.remove(libro);
        notificarObservadores();
    }

    public List<LibroDTO> getLibros() {
        return libros;
    }
}
