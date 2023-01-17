import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Objects;

public class TécnicoGUIAdministrador extends JFrame {
    private JPanel pnlTécnico;
    private JTable tblTecnicos;
    private JTextPane txtProblema;
    private JComboBox cmbTipoProblema;
    private JTextField txtFechaVisita;
    private JButton btnNotificarTecnico;
    private JButton btnVolver;
    private JLabel lblProblema;
    private JLabel lblTipoProblema;
    private JLabel lblFechaVisita;
    private JTextField txtValorPagar;
    private JLabel lblValorPagar;

    public TécnicoGUIAdministrador() {
        técnicosIngresados();
        btnNotificarTecnico.addActionListener(e -> {
            Técnico técnico = new Técnico();
            int fila = tblTecnicos.getSelectedRow();
            int id_tipoProblema = 0;
            if(fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String nombre = (String) tblTecnicos.getValueAt(fila, 0);
                String apellido = (String) tblTecnicos.getValueAt(fila, 1);
                String profesión = (String) tblTecnicos.getValueAt(fila, 2);
                String teléfono = (String) tblTecnicos.getValueAt(fila, 3);
                String correoElectrónico = (String) tblTecnicos.getValueAt(fila, 4);
                String problema = txtProblema.getText();
                String fechaVisita = txtFechaVisita.getText();
                String valorPagar = txtValorPagar.getText();
                String tipoProblema = Objects.requireNonNull(cmbTipoProblema.getSelectedItem()).toString();

                if(cmbTipoProblema.getSelectedIndex()==1){
                    id_tipoProblema = 1;
                }else if (cmbTipoProblema.getSelectedIndex()==2){
                    id_tipoProblema = 2;
                }
                técnico.generarNotificación(nombre, apellido, profesión, problema, fechaVisita, valorPagar, id_tipoProblema);
            }
        });

        btnVolver.addActionListener(e -> {
            MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
            menuPrincipalAdministrador.crearFrame();
            dispose();
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlTécnico);
        setVisible(true);
    }

    private void técnicosIngresados() {
        String[] DatosTécnico1 = {"Leon", "Ceres", "Plomero", "3456546", "leon@hotmail.com"};
        String[] DatosTécnico2 = {"Mario", "Tablas", "Carpintero", "5675677", "mario@hotmail.com"};
        String[] DatosTécnico3 = {"Jose", "Fino", "Electricista", "7897896", "jose@hotmail.com"};
        String[] DatosTécnico4 = {"Gilberto", "Flores", "Maestro constructor", "1222546", "gilberto@hotmail.com"};

        DefaultTableModel mtblTécnicos = new DefaultTableModel();
        mtblTécnicos.addColumn("Nombre");
        mtblTécnicos.addColumn("Apellido");
        mtblTécnicos.addColumn("Profesión");
        mtblTécnicos.addColumn("Teléfono");
        mtblTécnicos.addColumn("Correo Electrónico");

        mtblTécnicos.addRow(DatosTécnico1);
        mtblTécnicos.addRow(DatosTécnico2);
        mtblTécnicos.addRow(DatosTécnico3);
        mtblTécnicos.addRow(DatosTécnico4);
        tblTecnicos.setModel(mtblTécnicos);
    }
}
