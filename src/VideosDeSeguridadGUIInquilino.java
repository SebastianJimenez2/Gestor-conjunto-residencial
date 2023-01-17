import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VideosDeSeguridadGUIInquilino extends JFrame{
    private JPanel pnlVideosDeSeguridadInquilino;
    private JTable tblCámaras;
    private JTextField txtFecha;
    private JTextPane txtMotivo;
    private JButton btnSolicitar;
    private JButton btnVolver;
    private JLabel lblFecha;
    private JLabel lblMotivo;

    public VideosDeSeguridadGUIInquilino(){
        cámarasDelConjunto();
        btnVolver.addActionListener(e -> {
            MenuPrincipalInquilino menuPrincipalInquilino = new MenuPrincipalInquilino();
            menuPrincipalInquilino.crearFrame();
            dispose();
        });

        btnSolicitar.addActionListener(e -> {
            int fila = tblCámaras.getSelectedRow();
            if(fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un registro");
            } else {
                String IDCámara = (String) tblCámaras.getValueAt(fila, 0);
                String torre = (String) tblCámaras.getValueAt(fila, 1);
                String piso = (String) tblCámaras.getValueAt(fila, 2);
                String sector = (String) tblCámaras.getValueAt(fila, 3);
                String fecha = txtFecha.getText();

                VideoDeSeguridad videoDeSeguridad = new VideoDeSeguridad();
                videoDeSeguridad.solicitarVideo(IDCámara, torre, piso, sector, fecha);
            }

        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlVideosDeSeguridadInquilino);
        setVisible(true);
    }

    public void cámarasDelConjunto(){
        String[] cámara1 = {"AB123", "Torre C", "1", "-"};
        String[] cámara2 = {"AC156", "Torre A", "2", "-"};
        String[] cámara3 = {"AD189", "Torre B", "3", "-"};
        String[] cámara4 = {"AE213", "Torre D", "4", "-"};
        String[] cámara5 = {"AF246", "-", "-", "Canchas"};
        String[] cámara6 = {"AG279", "-", "-", "Pasillo Entrada"};

        DefaultTableModel tablaCámaras = new DefaultTableModel();
        tablaCámaras.addColumn("ID Cámara");
        tablaCámaras.addColumn("Torre");
        tablaCámaras.addColumn("Piso");
        tablaCámaras.addColumn("Sector");
        tablaCámaras.addRow(cámara1);
        tablaCámaras.addRow(cámara2);
        tablaCámaras.addRow(cámara3);
        tablaCámaras.addRow(cámara4);
        tablaCámaras.addRow(cámara5);
        tablaCámaras.addRow(cámara6);
        tblCámaras.setModel(tablaCámaras);
    }
}
