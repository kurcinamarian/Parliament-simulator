package politicians;

/**
 * Trieda farmar predstavuje poslanca typu farmár a dedí od triedy poslanec.
 */
public class farmar extends poslanec
{
    /**
     * Konštruktor triedy farmar.
     */
    public farmar(){
        super();
    }
    /**
     * Metóda na nastavenie náhodných hodnôt pre parametre farmára.
     */
    public void set_values(){
        this.zvysenie_dani = (int)(Math.random()*30);
        this.podpora_umelcom = (int)(Math.random()*30);
        this.davky_chudobnym = 70+(int)(Math.random()*30);
        this.zvysenie_mzdy = 60+(int)(Math.random()*40);
        this.vacsia_sloboda = (int)(Math.random()*100);
        this.vystavba_novej_trate = 10+(int)(Math.random()*60);
        this.demokrat = true;
    }
}
