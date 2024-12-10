package politicians;
/**
 * Trieda mestan predstavuje poslanca typu mešťan a dedí od triedy poslanec.
 */
public class mestan extends poslanec
{
    /**
     * Konštruktor triedy mestan.
     */
    public mestan(){
        super();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre mešťana.
     */
    public void set_values(){
        this.zvysenie_dani = (int)(Math.random()*50);
        this.podpora_umelcom = (int)(Math.random()*30);
        this.davky_chudobnym = 10+(int)(Math.random()*30);
        this.zvysenie_mzdy = 10+(int)(Math.random()*30);
        this.vacsia_sloboda = (int)(Math.random()*20);
        this.vystavba_novej_trate = 50+(int)(Math.random()*50);
        this.demokrat = true;
    }
}
