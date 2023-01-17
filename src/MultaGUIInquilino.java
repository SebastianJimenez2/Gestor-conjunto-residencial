import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MultaGUIInquilino extends JFrame {
    private JPanel pnlMultaInquilino;
    private JTable tblMultas;
    private JComboBox cmbMétodoPago;
    private JTextPane txtDatosTarjeta;
    private JButton btnPagar;
    private JButton btnVolver;
    private JButton btnSubirComprobante;
    private JLabel lblMetodoPago;
    private JLabel lblDatosTarjeta;
    private JLabel lblSubirComprobante;

    public MultaGUIInquilino() {
        lblDatosTarjeta.setVisible(false);
        txtDatosTarjeta.setVisible(false);
        lblSubirComprobante.setVisible(false);
        btnSubirComprobante.setVisible(false);

        multasPorDefecto();

        btnVolver.addActionListener(e -> {
            MenuPrincipalInquilino menuPrincipalInquilino = new MenuPrincipalInquilino();
            menuPrincipalInquilino.crearFrame();
            dispose();
        });

        btnPagar.addActionListener(e -> {
            Multa multa = new Multa();
            int fila = tblMultas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String númeroDeMulta = (String) tblMultas.getValueAt(fila, 0);
                String motivoMulta = (String) tblMultas.getValueAt(fila, 1);
                String valor = (String) tblMultas.getValueAt(fila, 3);
                String métodoDePago = (String) cmbMétodoPago.getSelectedItem();
                String datosTarjeta = txtDatosTarjeta.getText();

                boolean verificación = cmbMétodoPago.getSelectedIndex() == 1;

                multa.pagarMulta(númeroDeMulta, motivoMulta, valor, datosTarjeta, métodoDePago, verificación);
            }
        });

        cmbMétodoPago.addActionListener(e -> {
            if (cmbMétodoPago.getSelectedIndex() == 0) {
                lblDatosTarjeta.setVisible(false);
                lblSubirComprobante.setVisible(false);
                btnSubirComprobante.setVisible(false);
                txtDatosTarjeta.setVisible(false);
            } else if (cmbMétodoPago.getSelectedIndex() == 1) {
                lblDatosTarjeta.setVisible(true);
                lblSubirComprobante.setVisible(false);
                btnSubirComprobante.setVisible(false);
                txtDatosTarjeta.setVisible(true);
            } else if (cmbMétodoPago.getSelectedIndex() == 2) {
                lblSubirComprobante.setVisible(true);
                lblDatosTarjeta.setVisible(false);
                txtDatosTarjeta.setVisible(false);
                btnSubirComprobante.setVisible(true);
            }
        });

        btnSubirComprobante.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Comprobante subido con éxito");
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlMultaInquilino);
        setVisible(true);
    }

    public void multasPorDefecto() {
        String[] multa1 = {"1", "Tirar basura por la ventana", "12/12/23", "10"};
        String[] multa2 = {"2", "No recoger las necesidades de su animal", "11/11/23", "25"};
        String[] multa3 = {"3", "Usar instalaciones sin permiso previo", "10/10/23", "50"};

        DefaultTableModel tablaMultas = new DefaultTableModel();
        tablaMultas.addColumn("N°");
        tablaMultas.addColumn("Motivo Multa");
        tablaMultas.addColumn("Fecha Límite de Pago");
        tablaMultas.addColumn("Valor");
        tablaMultas.addRow(multa1);
        tablaMultas.addRow(multa2);
        tablaMultas.addRow(multa3);
        tblMultas.setModel(tablaMultas);
    }
}
