package modelo;
public class ContratoDto 
{
    private String codiCont;
    private String fechCont;
    private String fechInicCont ;
    private String fechFincont ;
    private String estCont;
    private String descCont;

    public ContratoDto() {
    }

    public ContratoDto(String codiCont, String fechCont, String fechInicCont, String fechFincont, String estCont, String descCont) {
        this.codiCont = codiCont;
        this.fechCont = fechCont;
        this.fechInicCont = fechInicCont;
        this.fechFincont = fechFincont;
        this.estCont = estCont;
        this.descCont = descCont;
    }  
    
    public String getCodiCont() {
        return codiCont;
    }

    public void setCodiCont(String codiCont) {
        this.codiCont = codiCont;
    }

    public String getFechCont() {
        return fechCont;
    }

    public void setFechCont(String fechCont) {
        this.fechCont = fechCont;
    }

    public String getFechInicCont() {
        return fechInicCont;
    }

    public void setFechInicCont(String fechInicCont) {
        this.fechInicCont = fechInicCont;
    }

    public String getFechFincont() {
        return fechFincont;
    }

    public void setFechFincont(String fechFincont) {
        this.fechFincont = fechFincont;
    }

    public String getEstCont() {
        return estCont;
    }

    public void setEstCont(String estCont) {
        this.estCont = estCont;
    }

    public String getDescCont() {
        return descCont;
    }

    public void setDescCont(String descCont) {
        this.descCont = descCont;
    }

    @Override
    public String toString() {
        return "ContratoDto{" + "codiCont=" + codiCont + ", fechCont=" + fechCont + ", fechInicCont=" + fechInicCont + ", fechFincont=" + fechFincont + ", estCont=" + estCont + ", descCont=" + descCont + '}';
    }

    
    
}
