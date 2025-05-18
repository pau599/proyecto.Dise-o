/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author paula
 */
public abstract class FuenteExternaCSV implements FuenteExternaLibros{
    
     public List<String> obtenerLibros() {
        // Simulación: cada línea representa un libro en formato CSV
        return Arrays.asList(
            "El Quijote;Miguel de Cervantes;1605;Novela;2023-01-01",
            "Cien años de soledad;Gabriel García Márquez;1967;Realismo mágico;2023-02-15"
        );
    }
}
