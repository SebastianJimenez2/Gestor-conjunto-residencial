import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InstalaciónGUIAdministrador extends JFrame {
    private JPanel pnlInstalación;
    private JTable tblInquilinos2;
    private JComboBox cmbInstalaciones;
    private JTextField txtHorario;
    private JButton btnReservar;
    private JButton btnVolver;
    private JLabel lblHorario;

    public InstalaciónGUIAdministrador() {
        Instalación instalación = new Instalación();
        inquilinosIngresados();

        btnVolver.addActionListener(e -> {
            MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
            menuPrincipalAdministrador.crearFrame();
            dispose();
        });
        btnReservar.addActionListener(e -> {
            int fila = tblInquilinos2.getSelectedRow();
            if(fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String nombre = (String) tblInquilinos2.getValueAt(fila, 0);
                String apellido = (String) tblInquilinos2.getValueAt(fila, 1);
                String cédula = (String) tblInquilinos2.getValueAt(fila, 2);
                String torre = (String) tblInquilinos2.getValueAt(fila, 3);
                String departamento = (String) tblInquilinos2.getValueAt(fila, 4);
                String teléfono = (String) tblInquilinos2.getValueAt(fila, 5);
                String mes = (String) cmbInstalaciones.getSelectedItem();
                String horario = txtHorario.getText();

                instalación.generarComprobante(nombre, apellido, cédula, torre, departamento, teléfono, mes, horario);
            }
        });
    }

    private void inquilinosIngresados() {
        String[] DatosInquilino1 = {"Juan", "Perez", "114256", "Torre C", "402", "2559025"};
        String[] DatosInquilino2 = {"Pedro", "Franco", "456789", "Torre A", "102", "2559078"};
        String[] DatosInquilino3 = {"Ruperto", "Regíl", "375697", "Torre B", "503", "2559096"};
        String[] DatosInquilino4 = {"Gilberto", "Estupiñan", "345786", "Torre C", "202", "2559045"};

        DefaultTableModel tablaInquilinos = new DefaultTableModel();
        tablaInquilinos.addColumn("Nombre");
        tablaInquilinos.addColumn("Apellido");
        tablaInquilinos.addColumn("Cédula");
        tablaInquilinos.addColumn("Torre");
        tablaInquilinos.addColumn("Departamento");
        tablaInquilinos.addColumn("Teléfono");
        tablaInquilinos.addRow(DatosInquilino1);
        tablaInquilinos.addRow(DatosInquilino2);
        tablaInquilinos.addRow(DatosInquilino3);
        tablaInquilinos.addRow(DatosInquilino4);
        tblInquilinos2.setModel(tablaInquilinos);
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlInstalación);
        setVisible(true);
    }
}
