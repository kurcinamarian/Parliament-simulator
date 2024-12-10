package parties;

/**
 * Trieda nedemokraticka_strana predstavuje nedemokratickú politickú stranu a dedí od triedy strana.
 */
public class nedemokraticka_strana extends strana{
    /**
     * Konštruktor triedy nedemokraticka_strana.
     *
     * @param a Hodnota pre zvýšenie daní.
     * @param b Hodnota pre podporu umelcov.
     * @param c Hodnota pre dávky chudobným.
     * @param d Hodnota pre zvýšenie mzdy.
     * @param e Hodnota pre väčšiu slobodu.
     * @param f Hodnota pre výstavbu novej trate.
     * @param x Boolovská hodnota pre typ strany (demokratická alebo nie).
     */
    public nedemokraticka_strana(int a, int b, int c, int d, int e, int f, boolean x) {
        super(a, b, c, d, e, f, x);
    }
    /**
     * Metóda na výpis informácií o nedemokratickej strane.
     *
     * @return Textový reťazec s informáciami o nedemokratickej strane.
     */
    public String vypis(){
        String report = "";
        report = report + " - strana: " + this.zvysenie_dani + "-" + this.podpora_umelcom + "-" +
                this.davky_chudobnym + "-" + this.zvysenie_mzdy + "-" + this.vacsia_sloboda + "-" +
                this.vystavba_novej_trate+  "\n(" + this.clenovia + " clenov - Nedemokraticka strana)";
        return report;
    }
}
