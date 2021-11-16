package de.stellarbytestudios.blutalkoholrechner;

public class Alkdaten {

    private final String geschlecht;
    private final int gewicht;

    private final int bier;
    private final int wein;
    private final int korn;
    private final int vodka;
    private final int whiskey;

    public Alkdaten(String geschlecht, int gewicht, int bier, int wein, int korn, int vodka, int whiskey) {
        this.geschlecht = geschlecht;
        this.gewicht = gewicht;
        this.bier = bier;
        this.wein = wein;
        this.korn = korn;
        this.vodka = vodka;
        this.whiskey = whiskey;
    }

    public String getDaten(){
        String out = "<h1>" +  "Du hast Folgende Werte eingegeben:" + "<br>" + "</h1>"
                + "Geschlecht: " + geschlecht + "<br>"
                + "Gewicht: " + gewicht + "<br> <br>"
                + "Bier: " + bier + "<br>"
                + "Wein: " + wein + "<br>"
                + "Korn: " + korn + "<br>"
                + "Vodka: " + vodka + "<br>"
                + "Whiskey: " + whiskey + "<br>"
        ;

        return out;
    }

    public double getPromille(){
        double widmark;
        double alkohlmenge = bier * 0.05  + wein * 0.12 + korn * 0.32 + vodka * 0.4 + whiskey * 0.43;
        double redukFak = 0.7;

        if (geschlecht.equals("Weiblich")){
            redukFak = 0.6;
        }

        widmark = alkohlmenge / (gewicht * redukFak);

        widmark = ((int)(widmark * 1000)) / 1000.0;

        return widmark;

    }
    public String alkZustand(){
        double widmark;
        double alkohlmenge = bier * 0.05  + wein * 0.12 + korn * 0.32 + vodka * 0.4 + whiskey * 0.43;
        double redukFak = 0.7;

        if (geschlecht.equals("Weiblich")){
            redukFak = 0.6;
        }

        widmark = alkohlmenge / (gewicht * redukFak);

        String out = "<h1>" +  "Dein Ausgerechneter Promillewert ist:" + "</h1>" + "<br>" + "<h2>" + widmark + "</h2>";

        return out;
    }
}
