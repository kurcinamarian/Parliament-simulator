package parties;

/**
 * Trieda demokraticka_strana predstavuje demokratickú politickú stranu a dedí od triedy strana.
 */
public class demokraticka_strana extends strana{
    /**
     * Konštruktor triedy demokraticka_strana.
     *
     * @param a Hodnota pre zvýšenie daní.
     * @param b Hodnota pre podporu umelcov.
     * @param c Hodnota pre dávky chudobným.
     * @param d Hodnota pre zvýšenie mzdy.
     * @param e Hodnota pre väčšiu slobodu.
     * @param f Hodnota pre výstavbu novej trate.
     * @param x Boolovská hodnota pre typ strany (demokratická alebo nie).
     */
    public demokraticka_strana(int a, int b, int c, int d, int e, int f, boolean x) {
        super(a, b, c, d, e, f, x);
    }
    /**
     * Metóda na výpis informácií o demokratickej strane.
     *
     * @return Textový reťazec s informáciami o demokratickej strane.
     */
    public String vypis(){
        String report = "";
        report = report + " - strana: " + this.zvysenie_dani + "-" + this.podpora_umelcom + "-" +
                this.davky_chudobnym + "-" + this.zvysenie_mzdy + "-" + this.vacsia_sloboda + "-" +
                this.vystavba_novej_trate+  "\n(" + this.clenovia + " clenov - Demokraticka strana)";
        return report;
    }
}
