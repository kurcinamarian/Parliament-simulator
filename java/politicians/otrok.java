package politicians;
/**
 * Trieda otrok predstavuje poslanca typu otrok a dedí od triedy poslanec.
 */
public class otrok extends poslanec
{
    /**
     * Konštruktor triedy otrok.
     */
    public otrok(){
        super();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre otroka.
     */
    public void set_values(){
        this.zvysenie_dani = (int)(Math.random()*20);
        this.podpora_umelcom = (int)(Math.random()*30);
        this.davky_chudobnym = 80+(int)(Math.random()*20);
        this.zvysenie_mzdy = 80+(int)(Math.random()*20);
        this.vacsia_sloboda = 80+(int)(Math.random()*20);
        this.vystavba_novej_trate = (int)(Math.random()*50);
        this.demokrat = true;
    }
}
