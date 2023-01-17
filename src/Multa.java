import javax.swing.*;

public class Multa {
    public void enviarNotificación(String nombre,
                                   String apellido,
                                   String cédula,
                                   String torre,
                                   String departamento,
                                   String motivoMulta,
                                   String fechaLímitePago) {

        JOptionPane.showMessageDialog(null,"Notificación enviada con éxito!");
        JOptionPane.showMessageDialog(null,
                "Mensaje enviado: \n" +
                        "Señor(a) " + nombre + " " + apellido + " con cédula de identidad " + cédula + " propietario " +
                        "(o arrendatario) del departamento: " + torre + " " + departamento + ", se le notifica que ha " +
                        "sido multado(a) por el siguiente motivo: " +
                        "\n\n" + motivoMulta + "\n\n" +
                        "Se le recuerda que tiene hasta " + fechaLímitePago + " para cancelar dicho valor.");
    }


    public void pagarMulta(String númeroDeMulta,
                           String motivoMulta,
                           String valor,
                           String datosTarjeta,
                           String métodoDePago, boolean verificación) {
        if(verificación){
            JOptionPane.showMessageDialog(null,
                    "Pago Realizado con éxito: \n" +
                            "ID Multa: " + númeroDeMulta + "\n" +
                            "Motivo de la multa: " + motivoMulta + "\n" +
                            "Valor pagado: " + valor +  "\n" +
                            "Método de Pago: " + métodoDePago + "\n" +
                            "Pago realizado mediante la siguiente tarjeta: \n\n" + datosTarjeta);
        } else {
            JOptionPane.showMessageDialog(null, "Pago exitoso");
        }
    }
}
