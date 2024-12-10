package parties;

import java.io.Serializable;

/**
 * Trieda strana predstavuje politickú stranu a implementuje serializáciu.
 */
public class strana implements Serializable {
    //premenne
    protected int zvysenie_dani;
    protected int podpora_umelcom;
    protected int davky_chudobnym;
    protected int zvysenie_mzdy;
    protected int vacsia_sloboda;
    protected int vystavba_novej_trate;
    protected int clenovia;
    protected Boolean demokrat;
    /**
     * Konštruktor triedy strana.
     *
     * @param a Hodnota pre zvýšenie daní.
     * @param b Hodnota pre podporu umelcov.
     * @param c Hodnota pre dávky chudobným.
     * @param d Hodnota pre zvýšenie mzdy.
     * @param e Hodnota pre väčšiu slobodu.
     * @param f Hodnota pre výstavbu novej trate.
     * @param x Boolovská hodnota pre typ strany (demokratická alebo nie).
     */
    public strana(int a,int b,int c,int d,int e,int f, boolean x){
        set_values(a,b,c,d,e,f,x);
    }
    /**
     * Metóda na nastavenie hodnôt politických preferencií strany.
     *
     * @param a Hodnota pre zvýšenie daní.
     * @param b Hodnota pre podporu umelcov.
     * @param c Hodnota pre dávky chudobným.
     * @param d Hodnota pre zvýšenie mzdy.
     * @param e Hodnota pre väčšiu slobodu.
     * @param f Hodnota pre výstavbu novej trate.
     * @param x Boolovská hodnota pre typ strany (demokratická alebo nie).
     */
    public void set_values(int a,int b,int c,int d,int e,int f,boolean x){
        this.zvysenie_dani = a;
        this.podpora_umelcom = b;
        this.davky_chudobnym = c;
        this.zvysenie_mzdy = d;
        this.vacsia_sloboda = e;
        this.vystavba_novej_trate = f;
        this.demokrat = x;
        clenovia = 0;
    }
    /**
     * Metóda na hlasovanie strany.
     *
     * @param zvysenie_dani Hodnota pre zvýšenie daní v návrhu zákona.
     * @param podpora_umelcom Hodnota pre podporu umelcov v návrhu zákona.
     * @param davky_chudobnym Hodnota pre dávky chudobným v návrhu zákona.
     * @param zvysenie_mzdy Hodnota pre zvýšenie mzdy v návrhu zákona.
     * @param vacsia_sloboda Hodnota pre väčšiu slobodu v návrhu zákona.
     * @param vystavba_novej_trate Hodnota pre výstavbu novej trate v návrhu zákona.
     * @return Počet hlasov strany za návrh zákona.
     */
    public int hlasovanie(int zvysenie_dani, int podpora_umelcom, int davky_chudobnym,
                          int zvysenie_mzdy, int vacsia_sloboda, int vystavba_novej_trate){
        int pocet = 0;
        if(this.zvysenie_dani >= zvysenie_dani){
            pocet++;
        }
        if(this.podpora_umelcom >= podpora_umelcom){
            pocet++;
        }
        if(this.davky_chudobnym >= davky_chudobnym){
            pocet++;
        }
        if(this.zvysenie_mzdy >= zvysenie_mzdy){
            pocet++;
        }
        if(this.vacsia_sloboda >= vacsia_sloboda){
            pocet++;
        }
        if(this.vystavba_novej_trate >= vystavba_novej_trate){
            pocet++;
        }
        if (pocet>3) {
            return clenovia;
        }
        else{
            return 0;
        }
    }
    /**
     * Metóda na výpis politických preferencií strany.
     *
     * @return Textový reťazec s politickými preferenciami strany.
     */
    public String vypis(){
        String report = "";
        report = report + " - strana: " + this.zvysenie_dani + "-" + this.podpora_umelcom + "-" +
                this.davky_chudobnym + "-" + this.zvysenie_mzdy + "-" + this.vacsia_sloboda + "-" +
                this.vystavba_novej_trate+  "\n(" + this.clenovia + " clenov)";
        return report;
    }
    /**
     * Metóda na získanie informácie, či je strana demokratická alebo nie.
     *
     * @return Boolovská hodnota true, ak je strana demokratická, inak false.
     */
    public Boolean getDemokrat(){ return demokrat; }
    /**
     * Metóda na pridanie nového člena do strany.
     */
    public void newMember(){
        this.clenovia++;
    }
    /**
     * Metóda na resetovanie počtu členov strany.
     */
    public void reset(){
        this.clenovia = 0;
    }
    /**
     * Metóda na získanie súčtu hodnôt politických preferencií strany.
     *
     * @return Súčet hodnôt politických preferencií.
     */
    public int getSum(){
        return this.zvysenie_dani + this.podpora_umelcom +
                this.davky_chudobnym + this.zvysenie_mzdy + this.vacsia_sloboda +
                this.vystavba_novej_trate;
    }
}
