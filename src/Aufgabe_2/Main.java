package Aufgabe_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio("Radio");
        Radio radioOMA = new Radio("Radio_Oma");
        Radio radioWohnzimmer = new Radio("Radio_Wohnzimmer");
        Radio radioKueche = new Radio("Radio_Kueche");

        Radio[] radioListe = new Radio[10];
        radioListe[0] = radio;
        radioListe[1] = radioOMA;
        radioListe[2] = radioWohnzimmer;
        radioListe[3] = radioKueche;

        Sender hitRadio = new Sender("HitRadio", 100.5);
        Sender nachrichten = new Sender("Nachrichten", 67.8);
        Sender wdr5 = new Sender("WDR5", 34.9);
        Sender wdr3 = new Sender("WDR3", 134.8);


        Sender[] senderListe = new Sender[10];
        senderListe[0] = hitRadio;
        senderListe[1] = nachrichten;
        senderListe[2] = wdr5;
        senderListe[3] = wdr3;



        //Programm
        boolean on = true;
        while(on){
            if (MainMenu() == 1) {
                while(radioProcess(radioMenu(), radioListe)){
                    //Ja hier solls leer sein
                }
            } else {
                while(senderProcess(senderMenu(), senderListe)){
                    //Ja hier solls leer sein
                }
            }

        }



    }
        //Radio Liste Ausgeben
    public static void radioListeAusgeben(Radio[] pArray){
        System.out.println("------RADIO-LISTE------");
        String mode;
        for (int i = 0; i < pArray.length; i++) {
            if(pArray[i] != null){
                if(pArray[i].getIsOn()){
                    mode = "AN";
                }else{
                    mode = "AUS";
                }
                System.out.println("["+(i+1)+"] "+pArray[i].getName() +"  [STATUS :"+mode +"| LAUTSTÄRKE: "+ pArray[i].getVolume()+"]");
            }else {
                break;
            }

        }
    }
    //Sender Liste Ausgeben
    public static void senderListeAusgeben(Sender[] pArray){
        System.out.println("------SENDER-LISTE------");
        String mode;
        for (int i = 0; i < pArray.length; i++) {
            if(pArray[i] != null){
                if(pArray[i].getAufSendung()){
                    mode = "JA";
                }else{
                    mode = "NEIN";
                }
                System.out.println("["+(i+1)+"] "+pArray[i].getName() +"  [AUF SENDUNG :"+mode +"| FREQUENZ: "+ pArray[i].getFrequenz()+"]");
            }else {
                break;
            }

        }
    }
        //Radio Menü Aktionen
    public static int radioMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------RADIO-MANAGER-------");
        System.out.println("[1] Radio Liste Anzeigen");
        System.out.println("[2] Radio Verwalten");
        System.out.println("[3] Zurück zum Hauptmenü");



        System.out.println("Gib deine Wahl an: ");
        return scanner.nextInt();
    }

        //Switch Anweisung für das Radio Menü
    public static boolean radioProcess(int pChoice, Radio[] pListe){
        switch(pChoice){
            case 1:{
                radioListeAusgeben(pListe);
                break;
            }
            case 2:{
                System.out.println("-------VERWALTUNG-------");
                radioListeAusgeben(pListe);
                RadioVerwalten(pListe);

                break;
            }
            case 3:{

                return false;

            }
        }
        return true;


    }

    //Die Aktionen welche mit einem Radio durchgeführt werden können
    public static void RadioVerwalten(Radio[] pListe){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches Radio willst du Verwalten: ");
        int radioManageChoice = scanner.nextInt();
        System.out.println("[1] Umbenennen");
        System.out.println("[2] Lauter");
        System.out.println("[3] Leise");
        System.out.println("[4] Ausschalten");
        System.out.println("[5] Anschalten");
        System.out.println("Was willst du machen: ");

        int actionChoice = scanner.nextInt();
        switch(actionChoice){
            case 1:{
                System.out.println("Gebe den neuen Namen an: ");
                scanner.nextLine();
                String newName = scanner.nextLine();
                pListe[radioManageChoice -1].setName(newName);
                System.out.println("Name geändert ("+newName+")");
                break;
            }
            case 2:{
                System.out.println("Um wie viel soll es lauter gemacht werden: ");
                pListe[radioManageChoice -1].volumeUp(scanner.nextInt());
                System.out.println("Lautstärke: "+ pListe[radioManageChoice -1].getVolume());
                break;
            }
            case 3:{
                System.out.println("Um wie viel soll es leiser gemacht werden: ");
                pListe[radioManageChoice -1].volumeDown(scanner.nextInt());
                System.out.println("Lautstärke: "+ pListe[radioManageChoice -1].getVolume());
                break;

            }
            case 4:{
                pListe[radioManageChoice -1].turnOFF();
                break;

            }
            case 5:{
                pListe[radioManageChoice -1].turnON();
                break;

            }

        }


    }

    //Hauptmenü
    public static int MainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----MAIN-MENU-----");
        System.out.println("[1] Radios Verwalten");
        System.out.println("[2] Sender Verwalten (passwort geschützt)");
        System.out.println("Was willst du tun");
        int mainMenuChoice = scanner.nextInt();
        switch (mainMenuChoice){
            case 1:{
                return 1;

            }
            case 2:{
                if(passwortAbfrage()){
                    return 2;
                }else{
                    System.out.println("Zugang Verweigert!");
                    break;
                }
            }
        }
        //Default
        return 0;

    }

    //Passwort für Sender Verwaltung wird abgefragt
    public static boolean passwortAbfrage(){
        Scanner scanner = new Scanner(System.in);
        boolean access;
        System.out.println("Gebe deinen Benutzernamen an: ");
        String userName = scanner.nextLine();
        System.out.println("Gebe dein Passwort an: ");
        String password = scanner.nextLine();

        if(userName.equals("Admin") && password.equals("Admin")){
            access = true;
        }else {
            access = false;
        }
        return access;
    }

    public static int senderMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------Sender-------");
        System.out.println("[1] Sender Liste Anzeigen");
        System.out.println("[2] Sender Verwalten");
        System.out.println("[3] Zurück zum Hauptmenü");



        System.out.println("Gib deine Wahl an: ");
        return scanner.nextInt();
    }

    public static boolean senderProcess(int pChoice ,Sender[] pListe){
        switch (pChoice){
            case 1:{
                senderListeAusgeben(pListe);
                break;
            }
            case 2:{
                senderListeAusgeben(pListe);
                senderManager(pListe);

                break;
            }
            case 3:{
                return false;
            }

        }

        return true;
    }
    public static void senderManager(Sender[] pListe){
        Scanner scanner = new Scanner(System.in);
        boolean on = true;
        while (on){
            System.out.println("-----VERWALTUNG-----");
            System.out.println("[1] Sender Umbennen");
            System.out.println("[2] Frequenz ändern");
            System.out.println("[3] Sender Ausschalten");
            System.out.println("[4] Sender Einschalten");
            System.out.println("[5] Verwaltung beenden");
            System.out.print("Was willst du tun: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:{
                    System.out.println("Welchen Sender willst du Umbennen: ");
                    int senderChange = scanner.nextInt();
                    System.out.println("Wie lautet der neue Name: ");
                    scanner.nextLine();
                    String newName = scanner.nextLine();
                    pListe[senderChange-1].setName(newName);
                    System.out.println("Der neue Name ist nun: " + pListe[senderChange-1].getName());
                    break;
                }
                case 2:{
                    System.out.println("Bei welchem Sender willst dui die Frequenz ändern: ");
                    int senderChange = scanner.nextInt();
                    System.out.println("Wie soll die neue Frequenz heissen (0,0 bis 200,0: ");
                    double newFrequence = scanner.nextInt();
                    if (newFrequence >= 0 && newFrequence <200){
                        pListe[senderChange-1].setFrequenz(newFrequence);
                        System.out.println("Die Frequenz von "+pListe[senderChange-1].getName()+" ist nun: "+ pListe[senderChange-1].getFrequenz());
                    }else {
                        System.out.println("Unzulässige Frequenz!");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Welchen Sender willst du ausschalten");
                    int senderChange = scanner.nextInt();
                    pListe[senderChange-1].turnOFF();
                    System.out.println(pListe[senderChange-1].getName()+ " Sendet nun nicht mehr!");
                    break;
                }
                case 4:{
                    System.out.println("Welchen Sender willst du anschalten");
                    int senderChange = scanner.nextInt();
                    pListe[senderChange-1].turnON();
                    System.out.println(pListe[senderChange-1].getName()+ " Sendet nun!");
                    break;

                }
                case 5:{
                    on = false;
                    break;

                } default: on = false;

            }

        }


    }



}
