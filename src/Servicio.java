import javax.swing.*;

public class Servicio {
    public void pagarServicio(String nombre,
                              String apellido,
                              String cédula,
                              String torre,
                              String departamento,
                              String teléfono,
                              String métodoDePago,
                              String plazos,
                              String servicioBásico,
                              int valorServicios,
                              boolean verificación,
                              boolean cuotasConInterés) {
        if (verificación) {
            if (cuotasConInterés) {
                float valorSeisMeses = (float) ((((valorServicios / 6) * 0.12) + valorServicios)) / 6;
                JOptionPane.showMessageDialog(null,
                        "COMPROBANTE DE PAGO" + "\n" +
                                "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                                "Método de pago: " + métodoDePago + " a " + plazos + "\n" +
                                "Servicio: " + servicioBásico + "\n" +
                                "Cédula: " + cédula + "\n" +
                                "Torre: " + torre + "\n" +
                                "Departamento: " + departamento + "\n" +
                                "Teléfono: " + teléfono + "\n" +
                                "Cuotas a pagar: " + valorSeisMeses + "\n");
            } else {
                float valorTresMeses = (float) valorServicios / 3;
                JOptionPane.showMessageDialog(null,
                        "COMPROBANTE DE PAGO" + "\n" +
                                "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                                "Método de pago: " + métodoDePago + " a " + plazos + "\n" +
                                "Servicio: " + servicioBásico + "\n" +
                                "Cédula: " + cédula + "\n" +
                                "Torre: " + torre + "\n" +
                                "Departamento: " + departamento + "\n" +
                                "Teléfono: " + teléfono + "\n" +
                                "Cuotas a pagar: " + valorTresMeses + "\n");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "COMPROBANTE DE PAGO" + "\n" +
                            "Nombre y Apellido: " + nombre + " " + apellido + "\n" +
                            "Método de pago: " + métodoDePago + "\n" +
                            "Servicio: " + servicioBásico + "\n" +
                            "Cédula: " + cédula + "\n" +
                            "Torre: " + torre + "\n" +
                            "Departamento: " + departamento + "\n" +
                            "Teléfono: " + teléfono + "\n" +
                            "Total pagado: " + valorServicios + "\n");
        }

    }
}
