package strategy;

import politicians.*;
import strategy.create;

/**
 * Trieda create_random implementuje rozhranie create a slúži na vytvorenie parlamentu podľa poskytnutých parametrov a jeho dotvorenie pomocou náhodných zamestnancov.
 */
public class create_random implements create {
    /**
     * Metóda setup() vytvára parlament pomocou poskytnutých parametrov a jeho dotvorenie pomocou náhodných zamestnancov.
     *
     * @param Poslanci       Pole poslancov, do ktorého sa majú vytvoriť noví poslanci.
     * @param nSportovcov    Počet poslancov, ktorí sú športovci.
     * @param nFarmarov      Počet poslancov, ktorí sú farmári.
     * @param nOtrokov       Počet poslancov, ktorí sú otroci.
     * @param nMestanov      Počet poslancov, ktorí sú mestania.
     * @param nUmelcov       Počet poslancov, ktorí sú umelci.
     */
    public void setup(poslanec[] Poslanci, int nSportovcov, int nFarmarov, int nOtrokov, int nMestanov, int nUmelcov){
        for (int i = 0; i<nSportovcov; ++i){
            Poslanci[i] = new sportovec();
        }
        for (int i = nSportovcov; i<nSportovcov+nFarmarov; ++i){
            Poslanci[i] = new farmar();
        }
        for (int i = nSportovcov+nFarmarov; i<nSportovcov+nFarmarov+nOtrokov; ++i){
            Poslanci[i] = new otrok();
        }
        for (int i = nSportovcov+nFarmarov+nOtrokov; i<nSportovcov+nFarmarov+nOtrokov+nMestanov; ++i){
            Poslanci[i] = new mestan();
        }
        for (int i = nSportovcov+nFarmarov+nOtrokov+nMestanov; i<nSportovcov+nFarmarov+nOtrokov+nMestanov+nUmelcov; ++i){
            Poslanci[i] = new umelec();
        }
        for (int i = nSportovcov+nFarmarov+nOtrokov+nMestanov+nUmelcov; i<150; ++i){
            int random;
            random = 1+(int)(Math.random()*4.999);
            if(random == 1){
                Poslanci[i] = new sportovec();
            }
            else if(random == 2){
                Poslanci[i] = new farmar();
            }
            else if(random == 3){
                Poslanci[i] = new otrok();
            }
            else if(random == 4){
                Poslanci[i] = new mestan();
            }
            else if(random == 5){
                Poslanci[i] = new umelec();
            }
        }

    }
}
