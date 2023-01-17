import javax.swing.*;

public class AlícuotaGUIInquilino extends JFrame {
    private JPanel pnlAlícuotasInquilino;
    private JComboBox cmbMesAlicuota;
    private JComboBox cmbMétodoDePago;
    private JTextPane txtDatosTarjeta;
    private JButton btnSubirComprobante;
    private JButton btnPagar;
    private JButton btnVolver;
    private JLabel lblMesAlicuota;
    private JLabel lblMétodoDePago;
    private JLabel lblDatosTarjeta;
    private JLabel lblSubirComprobante;
    private JTextField txtValorAPagar;
    private JLabel lblValorAPagar;

    public AlícuotaGUIInquilino() {
        lblDatosTarjeta.setVisible(false);
        txtDatosTarjeta.setVisible(false);
        lblValorAPagar.setVisible(false);
        txtValorAPagar.setVisible(false);
        lblSubirComprobante.setVisible(false);
        btnSubirComprobante.setVisible(false);

        btnVolver.addActionListener(e -> {
            MenuPrincipalInquilino menuPrincipalInquilino = new MenuPrincipalInquilino();
            menuPrincipalInquilino.crearFrame();
            dispose();
        });

        btnPagar.addActionListener(e -> {
            Alícuota alícuotaInquilino = new Alícuota();
            String mes = (String) cmbMesAlicuota.getSelectedItem();
            String métodoDePago = (String) cmbMétodoDePago.getSelectedItem();
            String datosTarjeta = txtDatosTarjeta.getText();
            String valor = txtValorAPagar.getText();

            boolean verificación = cmbMétodoDePago.getSelectedIndex() == 1;

            alícuotaInquilino.pagarAlícuota(mes, métodoDePago, datosTarjeta, verificación, valor);
        });

        cmbMétodoDePago.addActionListener(e -> {
            if (cmbMétodoDePago.getSelectedIndex() == 0) {
                lblDatosTarjeta.setVisible(false);
                lblSubirComprobante.setVisible(false);
                btnSubirComprobante.setVisible(false);
                txtDatosTarjeta.setVisible(false);
                lblValorAPagar.setVisible(false);
                txtValorAPagar.setVisible(false);
            } else if (cmbMétodoDePago.getSelectedIndex() == 1) {
                lblDatosTarjeta.setVisible(true);
                lblValorAPagar.setVisible(true);
                txtValorAPagar.setVisible(true);
                lblSubirComprobante.setVisible(false);
                btnSubirComprobante.setVisible(false);
                txtDatosTarjeta.setVisible(true);
            } else if (cmbMétodoDePago.getSelectedIndex() == 2) {
                lblSubirComprobante.setVisible(true);
                lblValorAPagar.setVisible(false);
                txtValorAPagar.setVisible(false);
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
        add(pnlAlícuotasInquilino);
        setVisible(true);
    }
}
