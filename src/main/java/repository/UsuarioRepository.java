/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.UsuarioDTO;
import java.util.List;

/**
 *
 * @author paula
 */
interface UsuarioRepository {
    
    void agregarUsuario(UsuarioDTO usuario);
    
    void actualizarUsuario(UsuarioDTO usuario);
    
    void eliminarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO buscarPorId(int id);
    
    List<UsuarioDTO> obtenerTodos();
    
}
