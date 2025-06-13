package Procesos;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

public class Notifiacion {
    public static void main(String[] args) {
        if (args.length < 2) return;
        System.out.println("[Email] Enviado a " + args[0] + ": " + args[1]);
    }
}
