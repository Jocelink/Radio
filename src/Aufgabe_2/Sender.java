package Aufgabe_2;

public class Sender {

    private String name;

    private double frequenz;

    private boolean aufSendung;


    public Sender(String pName, double pFrequenz){
        this.name = pName;
        this.frequenz = pFrequenz;
        this.aufSendung = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public double getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(double pFrequenz) {
        this.frequenz = pFrequenz;
    }

    public boolean getAufSendung() {
        return aufSendung;
    }

    public void setAufSendung(boolean pAufSendung) {
        this.aufSendung = pAufSendung;
    }

    public void turnOFF(){
        if(this.aufSendung == true){
            this.aufSendung = false;
            System.out.println("Sender sendet nun nicht mehr");
        }else {
            System.out.println("Sender ist schon aktuell nicht auf Sendung");
        }

    }
    public void turnON(){
        if(this.aufSendung == false){
            this.aufSendung = true;
            System.out.println("Der Sender sendet nun");
        }else {
            System.out.println("Der Sender schon aktuell auf Sendung");
        }
    }
}

