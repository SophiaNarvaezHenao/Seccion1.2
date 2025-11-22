// Java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vault vaultPIN = new Vault("PIN", "1234");
        Vault vaultBiometric = new Vault("BIOMETRICO", "huella_digital");
        Vault vaultKey = new Vault("LLAVE", "llave_maestra");
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a tu super mega caja fuerte!");
        while (true) {
            System.out.println("Seleccione el método de seguridad para abrir la caja fuerte (PIN, BIOMETRICO, LLAVE):");
            String metodo = sc.nextLine().toUpperCase();
            Vault vault = null;
            switch (metodo) {
                case "PIN":
                    vault = vaultPIN;
                    break;
                case "BIOMETRICO":
                    vault = vaultBiometric;
                    break;
                case "LLAVE":
                    vault = vaultKey;
                    break;
                default:
                    System.out.println("Método de seguridad no reconocido. Intente de nuevo.");
                    continue;
            }

            int intentos = 0;
            boolean accesoConcedido = false;
            while (intentos < 3 && !accesoConcedido) {
                System.out.println("Ingrese la credencial:");
                String credencial = sc.nextLine();
                accesoConcedido = vault.abrir(credencial);
                intentos++;
                if (!accesoConcedido) {
                    System.out.println("Credencial incorrecta. Intento " + intentos + " de 3.");
                }
            }
            if (accesoConcedido) {
                System.out.println("Acceso concedido. La caja fuerte se ha abierto.");
            } else {
                System.out.println("Demasiados intentos fallidos. La caja fuerte se ha bloqueado.");
            }
            break;
        }
    }
}