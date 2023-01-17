import javax.swing.*;

public class MenuPrincipalInquilino extends JFrame{
    private JPanel pnlInquilino;
    private JButton btnPagarMultas;
    private JButton btnPagarAlicuotas;
    private JButton btnCamaras;
    private JButton btnSolicitarInstalaciones;
    private JButton btnCerrarSesionInquilino;

    public MenuPrincipalInquilino(){
        btnCerrarSesionInquilino.addActionListener(e -> {
            InterfazLogin interfazLogin = new InterfazLogin();
            interfazLogin.crearFrame();
            dispose();
        });

        btnPagarMultas.addActionListener(e -> {
            MultaGUIInquilino multaGUIInquilino = new MultaGUIInquilino();
            multaGUIInquilino.crearFrame();
            dispose();
        });
        btnPagarAlicuotas.addActionListener(e -> {
            AlícuotaGUIInquilino alícuotaGUIInquilino = new AlícuotaGUIInquilino();
            alícuotaGUIInquilino.crearFrame();
            dispose();
        });
        btnCamaras.addActionListener(e -> {
            VideosDeSeguridadGUIInquilino videosDeSeguridadGUIInquilino = new VideosDeSeguridadGUIInquilino();
            videosDeSeguridadGUIInquilino.crearFrame();
            dispose();
        });
        btnSolicitarInstalaciones.addActionListener(e -> {
            InstalaciónGUIInquilino instalaciónGUIInquilino = new InstalaciónGUIInquilino();
            instalaciónGUIInquilino.crearFrame();
            dispose();
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlInquilino);
        setVisible(true);
    }
}
