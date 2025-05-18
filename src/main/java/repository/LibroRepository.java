/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.LibroDTO;
import java.util.List;

/**
 *
 * @author paula
 */
interface LibroRepository {
    
     void agregarLibro(LibroDTO libro);
     
    void actualizarLibro(LibroDTO libro);
    
    void eliminarLibro(LibroDTO libro);
    
    List<LibroDTO> obtenerTodos();
    
    List<LibroDTO> buscarPorTitulo(String titulo);
    
    List<LibroDTO> filtrarPorAutor(String autor);

    List<LibroDTO> filtrarPorGenero(String genero);
    
    List<LibroDTO> filtrarPorAño(int año);
}
    
