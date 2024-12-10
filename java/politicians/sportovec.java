package politicians;

/**
 * Trieda sportovec predstavuje poslanca typu športovec a dedí od triedy poslanec.
 */
public class sportovec extends poslanec
{
    /**
     * Konštruktor triedy sportovec.
     */
    public sportovec(){
        super();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre športovca.
     */
    public void set_values(){
        this.zvysenie_dani = 20+(int)(Math.random()*20);
        this.podpora_umelcom = 70+(int)(Math.random()*30);
        this.davky_chudobnym = 60+(int)(Math.random()*40);
        this.zvysenie_mzdy = 50+(int)(Math.random()*30);
        this.vacsia_sloboda = 80+(int)(Math.random()*20);
        this.vystavba_novej_trate = 30+(int)(Math.random()*50);
        this.demokrat = true;
    }
}
