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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paula
 */
public class LibroRepositoryDB implements LibroRepository {
    
    public void agregarLibro(LibroDTO libro) {
        String sql = "INSERT INTO libros (titulo, autor, año, genero, fechaLectura, usuarioId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAño());
            stmt.setString(4, libro.getGenero());
            stmt.setString(5, libro.getFechaLectura());
            stmt.setInt(6, libro.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarLibro(LibroDTO libro) {
        String sql = "UPDATE libros SET autor=?, año=?, genero=?, fechaLectura=? WHERE titulo=? AND usuarioId=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getAutor());
            stmt.setInt(2, libro.getAño());
            stmt.setString(3, libro.getGenero());
            stmt.setString(4, libro.getFechaLectura());
            stmt.setString(5, libro.getTitulo());
            stmt.setInt(6, libro.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibro(LibroDTO libro) {
        String sql = "DELETE FROM libros WHERE titulo=? AND usuarioId=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setInt(2, libro.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LibroDTO> obtenerTodos() {
        List<LibroDTO> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libros.add(new LibroDTO(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("año"),
                        rs.getString("genero"),
                        rs.getString("fechaLectura"),
                        rs.getInt("usuarioId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
    
    public List<LibroDTO> obtenerTodosPorUsuario(int usuarioId) {
    List<LibroDTO> libros = new ArrayList<>();
    String sql = "SELECT * FROM libros WHERE usuarioId = ?";
    try (Connection conn = dataBaseConfig.getInstance().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, usuarioId);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                libros.add(new LibroDTO(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("año"),
                        rs.getString("genero"),
                        rs.getString("fechaLectura"),
                        rs.getInt("usuarioId")
                ));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return libros;
}

    public List<LibroDTO> buscarPorTitulo(String titulo) {
        List<LibroDTO> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE titulo LIKE ?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + titulo + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    libros.add(new LibroDTO(
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("año"),
                            rs.getString("genero"),
                            rs.getString("fechaLectura"),
                            rs.getInt("usuarioId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<LibroDTO> filtrarPorAutor(String autor) {
        List<LibroDTO> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE autor LIKE ?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + autor + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    libros.add(new LibroDTO(
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("año"),
                            rs.getString("genero"),
                            rs.getString("fechaLectura"),
                            rs.getInt("usuarioId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<LibroDTO> filtrarPorGenero(String genero) {
        List<LibroDTO> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE genero LIKE ?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + genero + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    libros.add(new LibroDTO(
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("año"),
                            rs.getString("genero"),
                            rs.getString("fechaLectura"),
                            rs.getInt("usuarioId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<LibroDTO> filtrarPorAño(int año) {
        List<LibroDTO> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros WHERE año=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, año);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    libros.add(new LibroDTO(
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("año"),
                            rs.getString("genero"),
                            rs.getString("fechaLectura"),
                            rs.getInt("usuarioId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
}