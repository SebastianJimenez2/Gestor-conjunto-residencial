import javax.swing.*;

public class VideoDeSeguridad {
    public void solicitarVideo(String idCámara,
                               String torre,
                               String piso,
                               String sector,
                               String fecha) {
        if (torre.equals("-") && piso.equals("-")){
            JOptionPane.showMessageDialog(null,
                    "Usted ha solicitado el video de la cámara " + idCámara + " ubicada en el sector " + sector +
                            " del día: " + fecha + ".\n" +
                            "Favor esperar aprobación.");
        }else {
            JOptionPane.showMessageDialog(null,
                    "Usted ha solicitado el video de la cámara " + idCámara + " ubicada en la torre " + torre + " " +
                            "piso " + piso + " del día " + fecha + ". " +
                            "Favor esperar aprobación.");

        }
    }
}
