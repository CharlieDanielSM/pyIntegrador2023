/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Adria
 */
public class empleador {
    private String codiEmpl;
    private String dniRucEmpl;
    private String nombEmpl;
    private String teleEmpl;
    private String emailEmpl;
    private String fk_codigoTipoeEmpl;
    private String fk_codiUsa;

    public empleador() {
    }

    public empleador(String codiEmpl, String dniRucEmpl, String nombEmpl, String teleEmpl, String emailEmpl, String fk_codigoTipoeEmpl, String fk_codiUsa) {
        this.codiEmpl = codiEmpl;
        this.dniRucEmpl = dniRucEmpl;
        this.nombEmpl = nombEmpl;
        this.teleEmpl = teleEmpl;
        this.emailEmpl = emailEmpl;
        this.fk_codigoTipoeEmpl = fk_codigoTipoeEmpl;
        this.fk_codiUsa = fk_codiUsa;
    }

    public String getFk_codiUsa() {
        return fk_codiUsa;
    }

    public void setFk_codiUsa(String fk_codiUsa) {
        this.fk_codiUsa = fk_codiUsa;
    }

    public String getCodiEmpl() {
        return codiEmpl;
    }

    public void setCodiEmpl(String codiEmpl) {
        this.codiEmpl = codiEmpl;
    }

    public String getDniRucEmpl() {
        return dniRucEmpl;
    }

    public void setDniRucEmpl(String dniRucEmpl) {
        this.dniRucEmpl = dniRucEmpl;
    }

    public String getNombEmpl() {
        return nombEmpl;
    }

    public void setNombEmpl(String nombEmpl) {
        this.nombEmpl = nombEmpl;
    }

    public String getTeleEmpl() {
        return teleEmpl;
    }

    public void setTeleEmpl(String teleEmpl) {
        this.teleEmpl = teleEmpl;
    }

    public String getEmailEmpl() {
        return emailEmpl;
    }

    public void setEmailEmpl(String emailEmpl) {
        this.emailEmpl = emailEmpl;
    }

    public String getFk_codigoTipoeEmpl() {
        return fk_codigoTipoeEmpl;
    }

    public void setFk_codigoTipoeEmpl(String fk_codigoTipoeEmpl) {
        this.fk_codigoTipoeEmpl = fk_codigoTipoeEmpl;
    }
    
}

