import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ServicioGUIAdministrador extends JFrame {
    private JPanel pnlServicio;
    private JTable tblInquilinos4;
    private JComboBox cmbServicioBásico;
    private JComboBox cmbMétodoPago;
    private JComboBox cmbPlazos;
    private JButton btnPagar;
    private JButton btnVolver;
    private JLabel lblPlazos;
    private JLabel lblMétodoPago;
    private JLabel lblServicioBásico;
    Servicio servicio = new Servicio();

    public ServicioGUIAdministrador() {
        int valorServicios = 20;
        this.lblPlazos.setVisible(false);
        this.cmbPlazos.setVisible(false);

        inquilinosIngresados();

        btnVolver.addActionListener(e -> {
            MenuPrincipalAdministrador menuPrincipalAdministrador = new MenuPrincipalAdministrador();
            menuPrincipalAdministrador.crearFrame();
            dispose();
        });

        btnPagar.addActionListener(e -> {
            int fila = tblInquilinos4.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String nombre = (String) tblInquilinos4.getValueAt(fila, 0);
                String apellido = (String) tblInquilinos4.getValueAt(fila, 1);
                String cédula = (String) tblInquilinos4.getValueAt(fila, 2);
                String torre = (String) tblInquilinos4.getValueAt(fila, 3);
                String departamento = (String) tblInquilinos4.getValueAt(fila, 4);
                String teléfono = (String) tblInquilinos4.getValueAt(fila, 5);
                String métodoDePago = (String) cmbMétodoPago.getSelectedItem();
                String plazos = (String) cmbPlazos.getSelectedItem();
                String servicioBásico = (String) cmbServicioBásico.getSelectedItem();
                boolean cuotasConInterés = false;
                boolean verificación = this.lblPlazos.isVisible();

                if (verificación){
                    if (cmbPlazos.getSelectedIndex() == 2) {
                        cuotasConInterés = true;
                    }
                }
                servicio.pagarServicio(nombre, apellido, cédula, torre, departamento, teléfono, métodoDePago, plazos, servicioBásico, valorServicios, verificación, cuotasConInterés);
            }
        });

        cmbMétodoPago.addActionListener(e -> {
            if (cmbMétodoPago.getSelectedIndex() == 1) {
                setVisibleTipoPago(true);
            } else if (cmbMétodoPago.getSelectedIndex() == 2) {
                setVisibleTipoPago(false);
            }
        });
    }

    public void setVisibleTipoPago(boolean veredicto) {
        if (!veredicto) {
            this.lblPlazos.setVisible(false);
            this.cmbPlazos.setVisible(false);
        } else {
            this.lblPlazos.setVisible(true);
            this.cmbPlazos.setVisible(true);
        }
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlServicio);
        setVisible(true);
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
        tblInquilinos4.setModel(tablaInquilinos);
    }
}
