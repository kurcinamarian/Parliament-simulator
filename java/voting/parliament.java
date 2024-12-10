package voting;

import exceptions.NoParliament;
import politicians.poslanec;
import parties.*;
import strategy.create;
import java.io.Serializable;

/**
 * Trieda parliament predstavuje simuláciu parlamentu.
 */
public class parliament implements Serializable {
    private poslanec[] Poslanci;
    private Boolean parlament = false;
    private strana[] Strany;
    private int pocet_stran;

    /**
     * Metóda Create_Parliament slúži na vytvorenie parlamentu s určitým počtom poslancov rôznych typov a určenou stratégiou jeho dotvorenia.
     *
     * @param nSportovcov Počet poslancov, ktorí sú športovci.
     * @param nFarmarov Počet poslancov, ktorí sú farmári.
     * @param nOtrokov Počet poslancov, ktorí sú otroci.
     * @param nMestanov Počet poslancov, ktorí sú mestania.
     * @param nUmelcov Počet poslancov, ktorí sú umelci.
     * @param Create Implementácia rozhrania create pre dotvorenie parlamentu.
     * @return Informácia o úspešnom vytvorení parlamentu alebo chybovej správe.
     */
    public String Create_Parliament(int nSportovcov, int nFarmarov, int nOtrokov, int nMestanov, int nUmelcov, create Create) {
        if(nSportovcov + nFarmarov + nOtrokov + nMestanov + nUmelcov > 150){
            return "Pocet prevysuje 150.\n";
        }
        Poslanci = new poslanec[150];
        Strany = new strana[5];
        pocet_stran = 0;
        parlament = true;
        Create.setup(Poslanci, nSportovcov, nFarmarov, nOtrokov, nMestanov, nUmelcov);
        return "Parlament vytvoreny.\n";
    }

    /**
     * Metóda Create_Party slúži na vytvorenie novej politickej strany.
     *
     * @param a Hodnota parametra pre zvýšenie daní.
     * @param b Hodnota parametra pre podporu umelcov.
     * @param c Hodnota parametra pre dávky chudobným.
     * @param d Hodnota parametra pre zvýšenie mzdy.
     * @param e Hodnota parametra pre väčšiu slobodu.
     * @param f Hodnota parametra pre výstavbu novej trate.
     * @param demo Boolean hodnota, či je strana demokratická alebo nie.
     * @return Informácia o úspešnom vytvorení strany alebo chybovej správe.
     */
    public String Create_Party(int a, int b, int c, int d, int e, int f, Boolean demo){
        if(pocet_stran == 5){
            return "Nemozem vytvorit stranu\n";
        }
        //Ak parlament nebol vytvorený vypisanie exceptionu NoParliament
        Boolean chyba = false;
        try {
            if (!parlament) {
                throw new NoParliament();
            }
        } catch (NoParliament xxx) {
            chyba = true;
            xxx.alert();
        }
        if (!chyba) {
            for (int i = 0; i < pocet_stran; ++i) {
                Strany[i].reset();
            }
            if (demo) {
                Strany[pocet_stran] = new demokraticka_strana(a, b, c, d, e, f, true);
            } else {
                Strany[pocet_stran] = new nedemokraticka_strana(a, b, c, d, e, f, false);
            }
            pocet_stran++;
            for (int i = 0; i < 150; ++i) {
                int min = 0;
                int minOffset = Math.abs(Poslanci[i].getSum() - Strany[0].getSum());
                for (int j = 1; j < pocet_stran; ++j) {
                    int Offset = Math.abs(Poslanci[i].getSum() - Strany[j].getSum());
                    if (Offset < minOffset) {
                        min = j;
                    }
                }
                Strany[min].newMember();
                Poslanci[i].setParty(min);
                Poslanci[i].setDemokrat(Strany[min].getDemokrat());
            }
            return "Strana vytvorena\n";
        }
        return "";
    }

    /**
     * Metóda vymaz_strany slúži na vymazanie politických strán.
     *
     * @return Informácia o úspešnom vymazaní strán alebo chybovej správe.
     */
    public String vymaz_strany(){
        if(pocet_stran == 0) {
            return "Neexistujuce strany\n";
        }
        pocet_stran = 0;
        for(int i = 0; i<150; ++i){
            Poslanci[i].setParty(0);
        }
        return "Strany vymazane\n";
    }

    public parliament(){
    }

    /**
     * Metóda zahlasovanie_individualne vykoná hlasovanie poslancov na základe parametrov zákona.
     *
     * @param a Hodnota parametra pre zvýšenie daní.
     * @param b Hodnota parametra pre podporu umelcov.
     * @param c Hodnota parametra pre dávky chudobným.
     * @param d Hodnota parametra pre zvýšenie mzdy.
     * @param e Hodnota parametra pre väčšiu slobodu.
     * @param f Hodnota parametra pre výstavbu novej trate.
     * @return Informácia o tom, či bol zákon schválený alebo nie.
     */
    public String zahlasovanie_individualne(int a, int b, int c, int d, int e, int f){
        //Ak parlament nebol vytvorený vypisanie exceptionu NoParliament
        Boolean chyba = false;
        try {
            if (!parlament) {
                throw new NoParliament();
            }
        } catch (NoParliament xxx) {
            chyba = true;
            xxx.alert();
        }
        if (!chyba) {
            int hlasy = 0;
            String string = "";
            for (int i = 0; i < 150; ++i) {
                hlasy = hlasy + Poslanci[i].hlasovanie(a, b, c, d, e, f);
            }
            for (int i = 0; i < pocet_stran; ++i) {
                if (Strany[i] instanceof nedemokraticka_strana) {
                    hlasy = hlasy + Strany[i].hlasovanie(a, b, c, d, e, f);
                }
            }
            if (hlasy >= 75) {
                string = "Zakon schvaleny s " + hlasy + " hlasmi\n";
            } else {
                string = "Zakon neschvaleny s " + hlasy + " hlasmi\n";
            }
            return string;
        }
        return "";
    }

    /**
     * Metóda zahlasovanie_stranami vykoná hlasovanie strán na základe parametrov zákona.
     *
     * @param a Hodnota parametra pre zvýšenie daní.
     * @param b Hodnota parametra pre podporu umelcov.
     * @param c Hodnota parametra pre dávky chudobným.
     * @param d Hodnota parametra pre zvýšenie mzdy.
     * @param e Hodnota parametra pre väčšiu slobodu.
     * @param f Hodnota parametra pre výstavbu novej trate.
     * @return Informácia o tom, či bol zákon schválený alebo nie.
     */
    public String zahlasovanie_stranami(int a, int b, int c, int d, int e, int f){
        int hlasy = 0;
        String string = "";
        if(pocet_stran == 0){
            string = "Strany neexistuju\n";
            return string;
        }
        for(int i = 0; i < pocet_stran; ++i){
            hlasy = hlasy + Strany[i].hlasovanie(a,b,c,d,e,f);
        }
        if(hlasy >= 75){
            string = "Zakon schvaleny s "+ hlasy +" hlasmi\n";
        }
        else{
            string = "Zakon neschvaleny s "+ hlasy +" hlasmi\n";
        }
        return string;
    }

    /**
     * Metóda printParliament vypíše informácie o parlamente a jeho členoch.
     *
     * @return Textový reťazec s informáciami o parlamente.
     */
    public String printParliament() {
        //Ak parlament nebol vytvorený vypisanie exceptionu NoParliament
        Boolean chyba = false;
        try {
            if (!parlament) {
                throw new NoParliament();
            }
        } catch (NoParliament xxx) {
            chyba = true;
            xxx.alert();
        }
        if (!chyba) {
            StringBuilder report = new StringBuilder();
            for (int i = 0; i < pocet_stran; ++i) {
                report.append((i + 1)).append(Strany[i].vypis()).append("\n");
            }
            for (int i = 0; i < 150; ++i) {
                report.append((i + 1)).append(Poslanci[i].vypis()).append("\n");
            }
            return report.toString();
        }
        return "";
    }

    /**
     * Metóda saveInfo uloží informácie o parlamente do súboru.
     */
    public void saveInfo(){
        //Ak parlament nebol vytvorený vypisanie exceptionu NoParliament
        Boolean chyba = false;
        try {
            if (!parlament) {
                throw new NoParliament();
            }
        } catch (NoParliament xxx) {
            chyba = true;
            xxx.alert();
        }
        if (!chyba) {
            serialization serial = new serialization();
            serial.save(this);
        }
    }

    /**
     * Metóda loadInfo načíta informácie o parlamente zo súboru.
     */
    public void loadInfo(){
        serialization serial = new serialization();
        parliament parliament = serial.load();
        this.Strany = parliament.Strany;
        this.Poslanci = parliament.Poslanci;
        this.pocet_stran = parliament.pocet_stran;
    }
}
