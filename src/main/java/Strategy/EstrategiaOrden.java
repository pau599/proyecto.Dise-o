/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Strategy;

import DTO.LibroDTO;
import java.util.List;

/**
 *
 * @author paula
 */
public interface EstrategiaOrden {
    
    List<LibroDTO> ordenar(List<LibroDTO> libros);
}
