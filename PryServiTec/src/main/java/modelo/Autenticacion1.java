
package modelo;

import modelo.Usuario;

/* 🚀 Developed by NelsonJGP */
public class Autenticacion1 {
    private boolean usuarioValido;
    private boolean contraseñaValida;
    private Usuario2 usuario; // El objeto Usuario autenticado

    public Autenticacion1(boolean usuarioValido, boolean contraseñaValida, Usuario2 usuario) {
        this.usuarioValido = usuarioValido;
        this.contraseñaValida = contraseñaValida;
        this.usuario = usuario;
    }

    public boolean isUsuarioValido() {
        return usuarioValido;
    }

    public boolean isContraseñaValida() {
        return contraseñaValida;
    }

    public Usuario2 getUsuario() {
        return usuario;
    }
}