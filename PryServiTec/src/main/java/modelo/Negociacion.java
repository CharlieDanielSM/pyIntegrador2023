
package modelo;

import java.sql.Date;

/* 🚀 Developed by NelsonJGP */
public class Negociacion {
    private String codiNego;
    private java.sql.Date fechNego;
    private String estaNego;
    private double montNego;
    private String descNego;
    private String codiTrab;
    private String codiCli;

    public Negociacion() {
    }

    public Negociacion(String codiNego, Date fechNego, String estaNego, double montNego, String descNego, String codiTrab, String codiCli) {
        this.codiNego = codiNego;
        this.fechNego = fechNego;
        this.estaNego = estaNego;
        this.montNego = montNego;
        this.descNego = descNego;
        this.codiTrab = codiTrab;
        this.codiCli = codiCli;
    }

    public String getCodiNego() {
        return codiNego;
    }

    public void setCodiNego(String codiNego) {
        this.codiNego = codiNego;
    }

    public java.sql.Date getFechNego() {
        return fechNego;
    }

    public void setFechNego(java.sql.Date fechNego) {
        this.fechNego = fechNego;
    }

    public String getEstaNego() {
        return estaNego;
    }

    public void setEstaNego(String estaNego) {
        this.estaNego = estaNego;
    }

    public double getMontNego() {
        return montNego;
    }

    public void setMontNego(double montNego) {
        this.montNego = montNego;
    }

    public String getDescNego() {
        return descNego;
    }

    public void setDescNego(String descNego) {
        this.descNego = descNego;
    }

    public String getCodiTrab() {
        return codiTrab;
    }

    public void setCodiTrab(String codiTrab) {
        this.codiTrab = codiTrab;
    }

    public String getCodiCli() {
        return codiCli;
    }

    public void setCodiCli(String codiCli) {
        this.codiCli = codiCli;
    }

    
}
