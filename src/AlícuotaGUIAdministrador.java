import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AlícuotaGUIAdministrador extends JFrame {
    private JPanel pnlAlicuotas;
    private JTable tblInquilinos;
    private JCheckBox chckTerraza;
    private JButton btnGenerarAlicuota;
    private JButton btnVolver;
    private JComboBox cmbMes;
    private JTextField txtValor;

    public AlícuotaGUIAdministrador() {
        inquilinosIngresados();

        btnVolver.addActionListener(e -> {
            MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
            menuPrincipalAdministrador.crearFrame();
            dispose();
        });

        btnGenerarAlicuota.addActionListener(e -> {
            Alícuota alícuota = new Alícuota();
            int fila = tblInquilinos.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String nombre = (String) tblInquilinos.getValueAt(fila, 0);
                String apellido = (String) tblInquilinos.getValueAt(fila, 1);
                String cédula = (String) tblInquilinos.getValueAt(fila, 2);
                String torre = (String) tblInquilinos.getValueAt(fila, 3);
                String departamento = (String) tblInquilinos.getValueAt(fila, 4);
                String teléfono = (String) tblInquilinos.getValueAt(fila, 5);
                String mes = (String) cmbMes.getSelectedItem();
                int valorAlicuota = Integer.parseInt(txtValor.getText());
                boolean terraza = chckTerraza.isSelected();

                alícuota.generarComprobante(nombre, apellido, cédula, torre, departamento, teléfono, mes, valorAlicuota, terraza);
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
        tblInquilinos.setModel(tablaInquilinos);
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlAlicuotas);
        setVisible(true);
    }
}
