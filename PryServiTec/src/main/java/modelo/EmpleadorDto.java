
package modelo;
public class EmpleadorDto 
{
    private String codiEmpl;
    private String dniRucEmpl;
    private String nombEmpl;
    private String teleEmp;
    private String emailEmpl;

    public EmpleadorDto() {
    }

    public EmpleadorDto(String codiEmpl, String dniRucEmpl, String nombEmpl, String teleEmp, String emailEmpl) {
        this.codiEmpl = codiEmpl;
        this.dniRucEmpl = dniRucEmpl;
        this.nombEmpl = nombEmpl;
        this.teleEmp = teleEmp;
        this.emailEmpl = emailEmpl;
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

    public String getTeleEmp() {
        return teleEmp;
    }

    public void setTeleEmp(String teleEmp) {
        this.teleEmp = teleEmp;
    }

    public String getEmailEmpl() {
        return emailEmpl;
    }

    public void setEmailEmpl(String emailEmpl) {
        this.emailEmpl = emailEmpl;
    }

    @Override
    public String toString() {
        return "EmpleadorDto{" + "codiEmpl=" + codiEmpl + ", dniRucEmpl=" + dniRucEmpl + ", nombEmpl=" + nombEmpl + ", teleEmp=" + teleEmp + ", emailEmpl=" + emailEmpl + '}';
    }



}
