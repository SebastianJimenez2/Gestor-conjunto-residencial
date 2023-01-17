import javax.swing.*;

public class Técnico {
    private int valorAgregado = 100;
    public void generarNotificación(String nombre,
                                    String apellido,
                                    String profesión,
                                    String problema,
                                    String fechaVisita,
                                    String valorPagar,
                                    int id_tipoProblema) {
        if (id_tipoProblema==1){
            JOptionPane.showMessageDialog(null, "Buen día estimado técnico: " + nombre + " " + apellido
                    + "\nSe requiere encarecidamente sus conocimientos en: " + profesión + ". El dia: " + fechaVisita
                    + ".\nEsto debido a que surgió un problema con el siguiente detalle: " + problema + ". Esto requiere un MANTENIMIENTO urgente."
                    + "\nPor este trabajo se le pagará: $ " + valorPagar + "\nMuchas Gracias por su atención. Lindo dia. ");
        }else if(id_tipoProblema==2){
            int valorTotal = valorAgregado + Integer.parseInt(valorPagar);
            JOptionPane.showMessageDialog(null, "Buen día estimado técnico: " + nombre + " " + apellido
                    + "\nSe requiere encarecidamente sus conocimientos en: " + profesión + ". El dia: " + fechaVisita
                    + ".\nEsto debido a que surgió un problema con el siguiente detalle: " + problema + ". Esto requiere un REEMPLAZO DE PIEZAS urgente."
                    + "\nPor este trabajo se le pagará: $ " + valorTotal + "\nMuchas Gracias por su atención. Lindo dia. ");
        }
    }
}
