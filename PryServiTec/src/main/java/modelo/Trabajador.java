
package modelo;

/* 🚀 Developed by NelsonJGP */
public class Trabajador {
    private String codiTrab;
    private String dniTrab;
    private String nombTrab;
    private String ApelTrab;
    private String teleTrab;
    private char sexoTrab;
    private String emailTrab;
    private String codiEspe; // Codigo Especialidad
    private String codiUsua; // Codigo Usuario

    public Trabajador() {
    }

    public Trabajador(String codiTrab, String dniTrab, String nombTrab, String ApelTrab, String teleTrab, char sexoTrab, String emailTrab, String codiEspe, String codiUsua) {
        this.codiTrab = codiTrab;
        this.dniTrab = dniTrab;
        this.nombTrab = nombTrab;
        this.ApelTrab = ApelTrab;
        this.teleTrab = teleTrab;
        this.sexoTrab = sexoTrab;
        this.emailTrab = emailTrab;
        this.codiEspe = codiEspe;
        this.codiUsua = codiUsua;
    }

    public String getCodiTrab() {
        return codiTrab;
    }

    public void setCodiTrab(String codiTrab) {
        this.codiTrab = codiTrab;
    }

    public String getDniTrab() {
        return dniTrab;
    }

    public void setDniTrab(String dniTrab) {
        this.dniTrab = dniTrab;
    }

    public String getNombTrab() {
        return nombTrab;
    }

    public void setNombTrab(String nombTrab) {
        this.nombTrab = nombTrab;
    }

    public String getApelTrab() {
        return ApelTrab;
    }

    public void setApelTrab(String ApelTrab) {
        this.ApelTrab = ApelTrab;
    }

    public String getTeleTrab() {
        return teleTrab;
    }

    public void setTeleTrab(String teleTrab) {
        this.teleTrab = teleTrab;
    }

    public char getSexoTrab() {
        return sexoTrab;
    }

    public void setSexoTrab(char sexoTrab) {
        this.sexoTrab = sexoTrab;
    }

    public String getEmailTrab() {
        return emailTrab;
    }

    public void setEmailTrab(String emailTrab) {
        this.emailTrab = emailTrab;
    }

    public String getCodiEspe() {
        return codiEspe;
    }

    public void setCodiEspe(String codiEspe) {
        this.codiEspe = codiEspe;
    }

    public String getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(String codiUsua) {
        this.codiUsua = codiUsua;
    }

    
}
