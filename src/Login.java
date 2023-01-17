import javax.swing.*;

public class Login {
    public boolean verificarCredenciales(String contraseñaIngresada, String usuarioIngresado, int identificador) {
        boolean verificación = false;
        String usuarioAdministrador = "admin";
        String contraseñaAdministrador = "admin";
        String usuarioInquilino = "JorgeC402";
        String contraseñaInquilino = "123456";

        if (identificador == 1) {
            if (usuarioIngresado.equals(usuarioAdministrador) && contraseñaIngresada.equals(contraseñaAdministrador)) {
                MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
                menuPrincipalAdministrador.crearFrame();
                verificación = true;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
            }
        } else if (identificador == 2) {
            if (usuarioIngresado.equals(usuarioInquilino) && contraseñaIngresada.equals(contraseñaInquilino)) {
                MenuPrincipalInquilino menuPrincipalInquilino = new MenuPrincipalInquilino();
                menuPrincipalInquilino.crearFrame();
                verificación = true;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
            }
        }
        return verificación;
    }
}
