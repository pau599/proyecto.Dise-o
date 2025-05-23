/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import DTO.UsuarioDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import repository.FavoritosRepositoryDB;
import repository.LibroRepositoryDB;
import repository.UsuarioRepositoryDB;


/**
 *
 * @author Carolina
 */
public class VentanaConfiguracion extends javax.swing.JFrame {
    private UsuarioDTO usuario; 
    private UsuarioRepositoryDB usuarioRepo = new UsuarioRepositoryDB(); 

    

    /**
     * Creates new form VentanaPreferencia
     */
    public VentanaConfiguracion(UsuarioDTO usuario) {
        this.usuario = usuario;
          initComponents();
    }
    

  
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("GastroBot");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("CONFIGURACIONES");

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnEliminarCuenta.setText("Eliminar cuenta");
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(jLabel3))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addComponent(btnCerrarSesion)
                .addGap(71, 71, 71)
                .addComponent(btnEliminarCuenta)
                .addGap(52, 52, 52)
                .addComponent(btnVolver)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        VentanaInicioSesion configuraciones = new VentanaInicioSesion();
    configuraciones.setVisible(true);
    this.dispose();
    
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        // TODO add your handling code here:
         int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar tu cuenta?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        try {
             FavoritosRepositoryDB favoritosRepo = new FavoritosRepositoryDB();
             LibroRepositoryDB libroRepo = new LibroRepositoryDB();
                favoritosRepo.eliminarFavoritosPorUsuario(usuario.getUsuarioId()); 
                libroRepo.eliminarLibrosPorUsuario(usuario.getUsuarioId());
                usuarioRepo.eliminarUsuario(usuario); 
                JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente.");

                VentanaInicioSesion inicio = new VentanaInicioSesion();
                inicio.setVisible(true);
                this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar cuenta: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    Inicio ventana = new Inicio();
    ventana.setVisible(true);
    this.dispose(); 
    }//GEN-LAST:event_btnVolverActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
