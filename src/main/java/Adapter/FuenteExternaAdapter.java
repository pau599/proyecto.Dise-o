package Adapter;

import DTO.LibroDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class FuenteExternaAdapter {
    private FuenteExternaLibros fuenteExterna;

    public FuenteExternaAdapter(FuenteExternaLibros fuenteExterna) {
        this.fuenteExterna = fuenteExterna;
    }

    public List<LibroDTO> obtenerLibrosAdaptados() {
        List<LibroDTO> libros = new ArrayList<>();
        for (String linea : fuenteExterna.obtenerLibros()) {
            String[] partes = linea.split(";");
            if (partes.length == 5) {
    LibroDTO libro = new LibroDTO(
        partes[0], // título
        partes[1], // autor
        Integer.parseInt(partes[2]), // año
        partes[3], // género
        partes[4], // fecha de lectura
        0,         // usuarioId por defecto
        0          // idLibro por defecto
    );
    libros.add(libro);
}
        }
        return libros;
    }
}
