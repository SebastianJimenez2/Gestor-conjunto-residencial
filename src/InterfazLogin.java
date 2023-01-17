import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazLogin extends JFrame {
    private JPanel pnlLogin;
    private JButton btnLogin;
    private JTextField txtUsername;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JPasswordField fldContraseña;
    private JButton salirButton;
    private JComboBox cmbOpciones;

    public InterfazLogin() {
        this.setTitle("Login");
        btnLogin.addActionListener(e -> {
            Login login = new Login();
            String contraseñaIngresada = new String(fldContraseña.getPassword());
            String usuarioIngresado = txtUsername.getText();
            if (cmbOpciones.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion");
            } else {
                if(login.verificarCredenciales(contraseñaIngresada, usuarioIngresado, cmbOpciones.getSelectedIndex())){
                    dispose();
                }
            }
        });

        salirButton.addActionListener(e -> {
            System.exit(0);
        });


        fldContraseña.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnLogin.doClick();
                }
            }
        });
    }

    public void crearFrame() {
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        add(pnlLogin);
        setVisible(true);
    }
}
