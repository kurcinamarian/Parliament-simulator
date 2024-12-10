package politicians;

/**
 * Trieda umelec predstavuje poslanca typu umelec a dedí od triedy poslanec.
 */
public class umelec extends poslanec
{
    /**
     * Konštruktor triedy umelec.
     */
    public umelec(){
        super();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre umelca.
     */
    public void set_values(){
        this.zvysenie_dani = 10+(int)(Math.random()*20);
        this.podpora_umelcom = 70+(int)(Math.random()*30);
        this.davky_chudobnym = 60+(int)(Math.random()*40);
        this.zvysenie_mzdy = 60+(int)(Math.random()*30);
        this.vacsia_sloboda = 90+(int)(Math.random()*10);
        this.vystavba_novej_trate = (int)(Math.random()*50);
        this.demokrat = true;
    }
}
