package politicians;

import java.io.Serializable;

/**
 * Trieda poslanec predstavuje poslanca a implementuje serializáciu.
 */
public class poslanec implements Serializable
{
    //Premenné pre parametre poslanca
    protected int zvysenie_dani;
    protected int podpora_umelcom;
    protected int davky_chudobnym;
    protected int zvysenie_mzdy;
    protected int vacsia_sloboda;
    protected int vystavba_novej_trate;
    protected Boolean demokrat;
    protected int strana;

    /**
     * Konštruktor triedy poslanec.
     */
    public poslanec(){
        set_values();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre poslanca.
     */
    public void set_values(){
        this.zvysenie_dani = (int)(Math.random()*100);
        this.podpora_umelcom = (int)(Math.random()*100);
        this.davky_chudobnym = (int)(Math.random()*100);
        this.zvysenie_mzdy = (int)(Math.random()*100);
        this.vacsia_sloboda = (int)(Math.random()*100);
        this.vystavba_novej_trate = (int)(Math.random()*100);
        this.demokrat = true;
    }
    /**
     * Metóda na vykonanie hlasovania poslanca.
     *
     * @param zvysenie_dani         Hodnota pre zvýšenie daní.
     * @param podpora_umelcom       Hodnota pre podporu umelcov.
     * @param davky_chudobnym       Hodnota pre dávky chudobným.
     * @param zvysenie_mzdy         Hodnota pre zvýšenie mzdy.
     * @param vacsia_sloboda        Hodnota pre väčšiu slobodu.
     * @param vystavba_novej_trate  Hodnota pre výstavbu novej trate.
     * @return                      Hodnota hlasovania (1 ak súhlasí, 0 ak nesúhlasí).
     */
    public int hlasovanie(int zvysenie_dani, int podpora_umelcom, int davky_chudobnym,
                           int zvysenie_mzdy, int vacsia_sloboda, int vystavba_novej_trate){
        if (!this.demokrat){
            return 0;
        }
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
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * Metóda na získanie súčtu hodnôt parametrov poslanca.
     *
     * @return Súčet hodnôt parametrov.
     */
    public int getSum(){
        return this.zvysenie_dani + this.podpora_umelcom +
                this.davky_chudobnym + this.zvysenie_mzdy + this.vacsia_sloboda +
                this.vystavba_novej_trate;
    }

    /**
     * Metóda na výpis informácií o poslancovi.
     *
     * @return Textový reťazec s informáciami o poslancovi.
     */
    public String vypis(){
        return switch (this.strana){
            case 0 -> "."+ this.getClass().getSimpleName() + ": "+ this.zvysenie_dani + "-" + this.podpora_umelcom + "-" +
                    this.davky_chudobnym + "-" + this.zvysenie_mzdy + "-" + this.vacsia_sloboda + "-" +
                    this.vystavba_novej_trate;
            default-> "." + this.getClass().getSimpleName() + ": "+ this.zvysenie_dani + "-" + this.podpora_umelcom + "-" +
                    this.davky_chudobnym + "-" + this.zvysenie_mzdy + "-" + this.vacsia_sloboda + "-" +
                    this.vystavba_novej_trate + "(" + this.strana + ". strana)";
        };
    }

    /**
     * Metóda na nastavenie premennej reprezentujecej, príslušnosť poslanca k demokratickej strane.
     *
     * @param x Boolovská hodnota reprezentujúca príslušnosť poslanca k demokratickej strane.
     */
    public void setDemokrat(boolean x){this.demokrat = x;}
    /**
     * Metóda na nastavenie príslušnosti poslanca k politickéj strane.
     *
     * @param a Index politickej strany.
     */
    public void setParty(int a){
        this.strana = a+1;
    }
}
