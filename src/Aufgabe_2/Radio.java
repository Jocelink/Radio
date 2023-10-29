package Aufgabe_2;

public class Radio {

    private String name;
    private boolean isOn;
    private int volume;

    public Radio(String pName) {
        this.name = pName;
        this.isOn = false;
        this.volume = 50;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean pIsOn) {
        this.isOn = pIsOn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int pVolume) {
        this.volume = pVolume;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String pName){
        this.name = pName;
    }



    public void status() {
        System.out.println("-----------------");
        System.out.println(this.isOn);
        System.out.println(this.volume);
        System.out.println("-----------------");
    }

    public void volumeUp(int pValue){
        if(this.volume + pValue >= 0 && this.volume + pValue <= 100 && pValue > 0){
            this.volume = this.volume + pValue;
        }else{
            System.out.println("Invalid value / Out of area");
        }

    }
    public void volumeDown(int pValue){
        if(this.volume - pValue >= 0 && this.volume - pValue <= 100 && pValue > 0){
            this.volume = this.volume - pValue;
        }else {
            System.out.println("Invalid value / Out of area");
        }

    }

    public void turnOFF(){
        this.isOn = false;
        System.out.println("Radio ist ausgeschaltet");
    }
    public void turnON(){
        this.isOn = true;
        System.out.println("Radio ist nun eingeschaltet");
    }





}