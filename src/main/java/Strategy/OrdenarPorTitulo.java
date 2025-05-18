/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import DTO.LibroDTO;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author paula
 */
public class OrdenarPorTitulo implements EstrategiaOrden {

    @Override
    public List<LibroDTO> ordenar(List<LibroDTO> libros) {
        return libros.stream()
                .sorted(Comparator.comparing(LibroDTO::getTitulo))
                .collect(Collectors.toList());
    }
}
