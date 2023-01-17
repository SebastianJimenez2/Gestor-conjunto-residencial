import javax.swing.*;

public class MenuPrincipalAdministrador extends JFrame {
    private JPanel pnlMenuPrincipal;
    private JButton btnAlicuotas;
    private JButton btnServicios;
    private JButton btnTécnico;
    private JButton btnMultas;
    private JButton btnInstalaciones;
    private JButton btnCerrarSesion;

    public MenuPrincipalAdministrador(){

        btnCerrarSesion.addActionListener(e -> {
            InterfazLogin interfazLogin = new InterfazLogin();
            interfazLogin.crearFrame();
            dispose();
        });

        btnAlicuotas.addActionListener(e -> {
            AlícuotaGUIAdministrador alícuotaGUIAdministrador = new AlícuotaGUIAdministrador();
            alícuotaGUIAdministrador.crearFrame();
            dispose();
        });

        btnServicios.addActionListener(e -> {
            ServicioGUIAdministrador servicioGUIAdministrador = new ServicioGUIAdministrador();
            servicioGUIAdministrador.crearFrame();
            dispose();
        });

        btnMultas.addActionListener(e -> {
            MultaGUIAdministrador multaGUIAdministrador = new MultaGUIAdministrador();
            multaGUIAdministrador.crearFrame();
            dispose();
        });

        btnTécnico.addActionListener(e -> {
            TécnicoGUIAdministrador técnicoGUIAdministrador = new TécnicoGUIAdministrador();
            técnicoGUIAdministrador.crearFrame();
            dispose();
        });

        btnInstalaciones.addActionListener(e -> {
            InstalaciónGUIAdministrador instalaciónGUIAdministrador = new InstalaciónGUIAdministrador();
            instalaciónGUIAdministrador.crearFrame();
            dispose();
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlMenuPrincipal);
        setVisible(true);
    }
}
