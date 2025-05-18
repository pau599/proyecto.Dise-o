/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import DTO.UsuarioDTO;
import Singleton.dataBaseConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UsuarioRepositoryDB implements UsuarioRepository {

    public void agregarUsuario(UsuarioDTO usuario) {
        String sql = "INSERT INTO usuario (nombreUsuario, correo, contraseña) VALUES (?, ?, ?)";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(UsuarioDTO usuario) {
        String sql = "UPDATE usuario SET nombreUsuario=?, correo=?, contraseña=? WHERE usuarioId=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContraseña());
            stmt.setInt(4, usuario.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(UsuarioDTO usuario) {
        String sql = "DELETE FROM usuario WHERE usuarioId=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuario.getUsuarioId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UsuarioDTO buscarPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE usuarioId=?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsuarioDTO(
                        rs.getInt("usuarioId"),
                        rs.getString("nombreUsuario"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new UsuarioDTO(
                    rs.getInt("usuarioId"),
                    rs.getString("nombreUsuario"),
                    rs.getString("correo"),
                    rs.getString("contraseña")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public UsuarioDTO buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM usuario WHERE correo = ?";
        try (Connection conn = dataBaseConfig.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UsuarioDTO(
                        rs.getInt("usuarioId"),
                        rs.getString("nombreUsuario"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}