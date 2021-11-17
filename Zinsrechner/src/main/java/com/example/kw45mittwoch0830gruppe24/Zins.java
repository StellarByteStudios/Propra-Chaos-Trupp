package com.example.kw45mittwoch0830gruppe24;


import java.util.ArrayList;
import java.util.List;

public record Zins (double anfangskapital, int laufzeit, double zinssatz, boolean tabelle) {

    public double endkapitalBerechnen() {

        double endkapital = anfangskapital*Math.pow(1+zinssatz,laufzeit);
        endkapital = (int)(endkapital * 100) / 100.0;
        return endkapital;
    }

    public List<Zeile> tabelleBerechnen(){
        List<Zeile> zeilen = new ArrayList<Zeile>();
        double anfangswert = anfangskapital;
        double zinsen;
        double endkapital;

        for (int i = 1; i <= laufzeit; i++) {
            endkapital = anfangswert*(1+zinssatz);
            endkapital = (int)(endkapital * 100) / 100.0;
            zinsen = anfangswert*zinssatz;
            zinsen = (int)(zinsen * 100) / 100.0;
            zeilen.add(new Zeile(i, anfangswert, zinsen, endkapital));
            anfangswert = endkapital;
            anfangswert = (int)(anfangswert * 100) / 100.0;
        }
        return zeilen;
    }
}
