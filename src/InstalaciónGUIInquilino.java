import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstalaciónGUIInquilino extends JFrame{
    private JPanel pnlInstalaciónInquilino;
    private JComboBox cmbInstalación;
    private JTextField txtFecha;
    private JLabel lblInstalación;
    private JLabel lblFecha;
    private JLabel lblMotivo;
    private JTextPane txtMotivo;
    private JButton btnSolicitar;
    private JButton btnVolver;

    public InstalaciónGUIInquilino() {
        btnVolver.addActionListener(e -> {
            MenuPrincipalInquilino menuPrincipalInquilino = new MenuPrincipalInquilino();
            menuPrincipalInquilino.crearFrame();
            dispose();
        });

        btnSolicitar.addActionListener(e -> {
            Instalación instalaciónInquilino = new Instalación();

            String instalación = (String) cmbInstalación.getSelectedItem();
            String fecha = txtFecha.getText();
            String motivo = txtMotivo.getText();

            instalaciónInquilino.solicitarInstalación(instalación, fecha, motivo);
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlInstalaciónInquilino);
        setVisible(true);
    }
}
