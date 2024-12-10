package strategy;

import politicians.poslanec;

/**
 * Rozhranie create definuje metódu setup(), ktorá slúži na vytvorenie parlamentu.
 */
public interface create {
    /**
     * Metóda setup() slúži na vytvorenie parlamentu.
     *
     * @param Poslanci Pole poslancov, do ktorého sa majú vytvoriť noví poslanci.
     * @param nSportovcov Počet poslancov, ktorí sú športovci.
     * @param nFarmarov Počet poslancov, ktorí sú farmári.
     * @param nOtrokov Počet poslancov, ktorí sú otroci.
     * @param nMestanov Počet poslancov, ktorí sú mestania.
     * @param nUmelcov Počet poslancov, ktorí sú umelci.
     */
    void setup(poslanec[] Poslanci,int nSportovcov,int nFarmarov,int nOtrokov,int nMestanov,int nUmelcov);
}
