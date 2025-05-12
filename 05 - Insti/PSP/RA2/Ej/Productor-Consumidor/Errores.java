import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Errores {
    private List<String> mensajes;

    public Errores(){
        this.mensajes = new ArrayList<>();
    }

    private List<String> generacionMensajes(){
          String[] Errors = {
                "Error",
                "Log",
                "File",
                "Creation",
                "Pressure",
                "High",
                "Low",
                "Control",
                "Successive",
                "Missed",
                "Perf",
                "Out",
                "Of",
                "Bags",
                "Not",
                "Opened",
                "Heatbar",
                "Enagaging",
                "Print",
                "Length",
                "Sealbar",
                "Close",
                "Start",
                "Jammed",
                "Closing",
                "Jamming",
                "Opening",
                "Temperature",
                "Heat",
                "Wire",
                "Disabled",
                "Drive",
                "Motion",
                "Homing",
                "Timeout",
                "Descending",
                "Tension",
                "Web",
                "Break",
                "Threading",
                "Controller",
                "Clamped",
                "Ribbon",
                "Out",
                "Label",
                "Not",
                "Configured",
                "Dry",
                "Printhead",
                "Feeder"};

        StringBuilder error = new StringBuilder();
        Random rnd = new Random();

        for (int i=0; i<20;i++){
            int type = rnd.nextInt(2);
            if (type == 1){
                error.append("Error ");
            }else{
                error.append("Success in ");
            }
            for (int j = 0; j < rnd.nextInt(4,12); j++) {
                error.append(Errors[rnd.nextInt(Errors.length)] + " ");
            }
            this.mensajes.add(String.valueOf(error));
            error = new StringBuilder();
        }

        return this.mensajes;
    }
    public static void main(String[] args) {
        Errores foo = new Errores();
        foo.generacionMensajes().iterator().forEachRemaining(
            mensajes ->  System.out.println(mensajes)
        );
    }
}
