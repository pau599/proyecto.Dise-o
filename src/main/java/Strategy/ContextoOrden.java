/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import DTO.LibroDTO;
import java.util.List;

/**
 *
 * @author paula
 */
public class ContextoOrden {
     private EstrategiaOrden estrategia;

    public void setEstrategia(EstrategiaOrden estrategia) {
        this.estrategia = estrategia;
    }

    public List<LibroDTO> ordenarLibros(List<LibroDTO> libros) {
        return estrategia.ordenar(libros);
    }
}
