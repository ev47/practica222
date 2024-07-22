/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoEventos;

import javax.swing.JOptionPane;

/**
 *
 * @author edgva
 */
public class log {
    private String usuario;
    private String password;
    private static String[] usuarios = new String[100];
    private static String[] contraseñas = new String[100];
    private static int count = 0;

    public log() {}

    public log(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void adminUser(String Usuario, String password) {
        if (Usuario.equalsIgnoreCase("admin") && password.equalsIgnoreCase("supersecreto")) {
            Usuario=usuario;
            password=this.password;
            JOptionPane.showMessageDialog(null, "Bienvenido User");
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas, favor ingresar los datos correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean ingreso(String Usuario, String password) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(Usuario)) {
                if (contraseñas[i].equals(password)) {
                    this.usuario = Usuario;
                    this.password = password;
                    String mensaje = "Bienvenido " + Usuario;
                    JOptionPane.showMessageDialog(null, mensaje);
                    return true;
                } else {
                    String mensaje = "Password incorrecto";
                    JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Ingreso denegado, favor poner usuario y password correctos", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean registrarUsuario(String Usuario, String password) {
        for (int i = 0; i < count; i++) {
            if (usuarios[i].equalsIgnoreCase(Usuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, favor elegir otro Nombre de Usuario");
                return false;
            }
        }
        if (count < usuarios.length) {
            usuarios[count] = Usuario;
            contraseñas[count] = password;
            count++;
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente: " + Usuario);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ya no se pueden registrar más usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}


