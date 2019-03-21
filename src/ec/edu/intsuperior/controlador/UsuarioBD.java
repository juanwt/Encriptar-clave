/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan WT
 */
public class UsuarioBD {
         //Inserta un nuevo Registro
    public static void guardar(Usuario obj) throws SQLException {
        Connection cnn = Conexion.getConexion();
        PreparedStatement ps = null;
        
        String sql;

        sql="INSERT INTO usuario (usuario, clave)VALUES (?,?)";
        try {
            ps=cnn.prepareStatement(sql);
            ps.setString(1,obj.getUsuario());
            ps.setString(2,obj.getClave());
            
            int n=ps.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null,"Registrado con exito", "Grabar Registro",JOptionPane.INFORMATION_MESSAGE);
            }
            
            cnn.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se logro grabar el Registro..."+ex, "Grabar Registro",JOptionPane.ERROR_MESSAGE);
        }
    }
  
}
