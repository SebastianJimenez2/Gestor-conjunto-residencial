import javax.swing.*;

public class Instalación {
    String[][] reservaciones = new String[1000][2];
    int contador = 0;

    public void generarComprobante(String nombre,
                                   String apellido,
                                   String cédula,
                                   String torre,
                                   String departamento,
                                   String teléfono,
                                   String instalación,
                                   String horario) {
        boolean instalaciónOcupada = false;
        if (reservaciones[0][0] != null) {
            for (int i = 0; i < contador; i++) {
                if (reservaciones[i][0].equals(instalación)) {
                    if (reservaciones[i][1].equals(horario)) {
                        instalaciónOcupada = true;
                    }
                }
            }
            if (!instalaciónOcupada) {
                JOptionPane.showMessageDialog(null,
                        "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                                "Cédula: " + cédula + "\n" +
                                "Torre: " + torre + "\n" +
                                "Departamento: " + departamento + "\n" +
                                "Teléfono: " + teléfono + "\n" +
                                "Instalación: " + instalación + "\n" +
                                "Horario: " + horario + "\n");
                reservaciones[contador][0] = instalación;
                reservaciones[contador][1] = horario;
                contador++;
            } else {
                JOptionPane.showMessageDialog(null, "Instalación ya reservada");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                            "Cédula: " + cédula + "\n" +
                            "Torre: " + torre + "\n" +
                            "Departamento: " + departamento + "\n" +
                            "Teléfono: " + teléfono + "\n" +
                            "Instalación: " + instalación + "\n" +
                            "Horario: " + horario + "\n");
            reservaciones[0][0] = instalación;
            reservaciones[0][1] = horario;
            contador++;
        }
    }

    public void solicitarInstalación(String instalación, String fecha, String motivo) {
        JOptionPane.showMessageDialog(null,
                "Usted ha solicitado la siguiente instalación \n" +
                        "Instalación: " + instalación + "\n" +
                        "Fecha reserva: " + fecha + "\n" +
                        "Motivo: " + motivo + "\n" +
                        "Favor esperar aprobación.");
    }
}
