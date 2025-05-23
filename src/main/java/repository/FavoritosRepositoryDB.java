/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DTO.LibroDTO;
import Singleton.dataBaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class FavoritosRepositoryDB {
    public void agregarFavorito(int usuarioId, int libroId) {
        String sql = "INSERT INTO Favoritos (usuarioId, libroId) VALUES (?, ?)";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, libroId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public List<LibroDTO> obtenerFavoritosPorUsuario(int usuarioId) {
        List<LibroDTO> favoritos = new ArrayList<>();
        String sql = "SELECT l.* FROM libros l JOIN Favoritos f ON l.IdLibro = f.libroId WHERE f.usuarioId = ?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    favoritos.add(new LibroDTO(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("año"),
                        rs.getString("genero"),
                        rs.getString("fechaLectura"),
                        rs.getInt("usuarioId"),
                        rs.getInt("IdLibro")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoritos;
    }

    public void eliminarFavoritosPorUsuario(int usuarioId) {
    String sql = "DELETE FROM Favoritos WHERE usuarioId = ?";
    try (Connection conn = dataBaseConfig.getInstance().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, usuarioId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
