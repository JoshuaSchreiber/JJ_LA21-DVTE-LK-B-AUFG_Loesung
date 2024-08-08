import java.util.Date;

public class Impfung {
    private Date impfTermin;

    public Impfung(Date impfTermin){
        this.impfTermin = impfTermin;
    }

    public Date getImpfTermin() {
        return impfTermin;
    }

    public void setImpfTermin(Date impfTermin) {
        this.impfTermin = impfTermin;
    }
}
