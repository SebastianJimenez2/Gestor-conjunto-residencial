import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MultaGUIAdministrador extends JFrame{
    private JPanel pnlMulta;
    private JTable tblInquilinos3;
    private JTextPane txtMotivoMulta;
    private JButton btnEnviarNoti;
    private JLabel lblMotivoMulta;
    private JLabel lblCantidadAPagar;
    private JTextField txtCantidadAPagar;
    private JTextField txtFechaLímite;
    private JLabel lblFechaLímite;
    private JButton btnVolver;

    public MultaGUIAdministrador() {
        inquilinosIngresados();

        btnVolver.addActionListener(e -> {
            MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
            menuPrincipalAdministrador.crearFrame();
            dispose();
        });
        btnEnviarNoti.addActionListener(e -> {
            Multa multa = new Multa();
            int fila = tblInquilinos3.getSelectedRow();
            if(fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String nombre = (String) tblInquilinos3.getValueAt(fila, 0);
                String apellido = (String) tblInquilinos3.getValueAt(fila, 1);
                String cédula = (String) tblInquilinos3.getValueAt(fila, 2);
                String torre = (String) tblInquilinos3.getValueAt(fila, 3);
                String departamento = (String) tblInquilinos3.getValueAt(fila, 4);
                String motivoMulta = txtMotivoMulta.getText();
                String fechaLímitePago = txtFechaLímite.getText();

                multa.enviarNotificación(nombre, apellido, cédula, torre, departamento, motivoMulta, fechaLímitePago);
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
        tblInquilinos3.setModel(tablaInquilinos);
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlMulta);
        setVisible(true);
    }
}
