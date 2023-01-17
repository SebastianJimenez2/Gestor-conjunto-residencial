import javax.swing.*;

public class Alícuota {
    int valorAgregado = 20;

    public void generarComprobante(String nombre,
                                   String apellido,
                                   String cédula,
                                   String torre,
                                   String departamento,
                                   String teléfono,
                                   String mes,
                                   int valorAlicuota,
                                   boolean terraza) {
        if (terraza) {
            int nuevoValor = valorAlicuota + valorAgregado;
            JOptionPane.showMessageDialog(null,
                    "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                            "Cédula: " + cédula + "\n" +
                            "Torre: " + torre + "\n" +
                            "Departamento: " + departamento + "\n" +
                            "Teléfono: " + teléfono + "\n" +
                            "Mes: " + mes + "\n" +
                            "Valor a pagar: " + nuevoValor + "\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                            "Cédula: " + cédula + "\n" +
                            "Torre: " + torre + "\n" +
                            "Departamento: " + departamento + "\n" +
                            "Teléfono: " + teléfono + "\n" +
                            "Mes: " + mes + "\n" +
                            "Valor a pagar: " + valorAlicuota + "\n");
        }
    }

    public void pagarAlícuota(String mes,
                              String métodoDePago,
                              String datosTarjeta,
                              boolean verificación,
                              String valor) {
        if(verificación){
            JOptionPane.showMessageDialog(null,
                    "Pago Realizado con éxito: \n" +
                            "Mes de alícuota cancelado: " + mes + "\n" +
                            "Valor pagado: " + valor +  "\n" +
                            "Método de Pago: " + métodoDePago + "\n" +
                            "Pago realizado mediante la siguiente tarjeta: \n\n" + datosTarjeta);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Pago Realizado con éxito: \n" +
                            "Mes de alícuota cancelado: " + mes + "\n" +
                            "Método de Pago: " + métodoDePago + "\n");
        }
    }
}
