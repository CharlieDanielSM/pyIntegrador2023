
package modelo;

/* 🚀 Developed by NelsonJGP */
public class Especialidad {
    private String codiEspe;
    private String nombEspe;
    private double precBaseEspe;
    private String descEspe;

    public Especialidad() {
    }

    public Especialidad(String codiEspe, String nombEspe, double precBaseEspe, String descEspe) {
        this.codiEspe = codiEspe;
        this.nombEspe = nombEspe;
        this.precBaseEspe = precBaseEspe;
        this.descEspe = descEspe;
    }

    public String getCodiEspe() {
        return codiEspe;
    }

    public void setCodiEspe(String codiEspe) {
        this.codiEspe = codiEspe;
    }

    public String getNombEspe() {
        return nombEspe;
    }

    public void setNombEspe(String nombEspe) {
        this.nombEspe = nombEspe;
    }

    public double getPrecBaseEspe() {
        return precBaseEspe;
    }

    public void setPrecBaseEspe(double precBaseEspe) {
        this.precBaseEspe = precBaseEspe;
    }

    public String getDescEspe() {
        return descEspe;
    }

    public void setDescEspe(String descEspe) {
        this.descEspe = descEspe;
    }

    
}
