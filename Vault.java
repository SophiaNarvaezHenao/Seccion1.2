
public class Vault {
    private String metodoSeguridad;
    private Object credencialCorrecta;


    public Vault(String metodoSeguridad, Object credencialCorrecta) {
        this.metodoSeguridad = metodoSeguridad;
        this.credencialCorrecta = credencialCorrecta;
    }
    public boolean abrir(Object credencial) {
        switch (metodoSeguridad) {
            case "PIN":
            case "BIOMETRICO":
            case "LLAVE":
                return credencialCorrecta.equals(credencial);
            default:
                System.out.println("Método de seguridad no reconocido.");
                return false;
        }
    }
}
