package MVC;

import GUI.voting_GUI;
import exceptions.NoInput;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import strategy.create_normal;
import strategy.create_random;
import voting.*;

/**
 * Trieda controller predstavuje ovládač udalostí pre systém hlasovania.
 */
public class controller implements EventHandler<ActionEvent>{
    private parliament model ;
    private voting_GUI view;
    /**
     * Konštruktor triedy controller.
     *
     * @param model Referencia na model parlamentu.
     * @param view Referencia na zobrazenie GUI.
     */
    public controller(parliament model, voting_GUI view){
        this.model = model;
        this.view = view;
    }
    /**
     * Metóda pre spracovanie udalostí.
     *
     * @param event Udalosť, ktorá má byť spracovaná.
     */
    public void handle(ActionEvent event){
        //Výroba parlamentu použitie stratégie podľa radio buttonu - návrhový vzor strategy
        if(event.getSource()==view.getCreateParliament()){
            //Ak textové polia neobsahujú všetky potrebné inputy vypisanie exceptionu NoInput
            Boolean chyba = false;
            try{
                if(view.getFarmari().isEmpty()||view.getMestania().isEmpty()||view.getOtroci().isEmpty()||
                        view.getSportovci().isEmpty()||view.getUmelci().isEmpty()){
                    throw new NoInput();
                }
            }
            catch (NoInput xxx){
                chyba = true;
                xxx.alert();
            }
            if(!chyba) {
                //použitie 1.stratégie
                if (view.getRadioButton1().isSelected()) {
                    view.printOutput(model.Create_Parliament(Integer.parseInt(view.getFarmari()),
                            Integer.parseInt(view.getMestania()),
                            Integer.parseInt(view.getOtroci()),
                            Integer.parseInt(view.getSportovci()),
                            Integer.parseInt(view.getUmelci()),
                            new create_normal()));
                }
                //použitie 2.stratégie
                else {
                    view.printOutput(model.Create_Parliament(Integer.parseInt(view.getFarmari()),
                            Integer.parseInt(view.getMestania()),
                            Integer.parseInt(view.getOtroci()),
                            Integer.parseInt(view.getSportovci()),
                            Integer.parseInt(view.getUmelci()),
                            new create_random()));
                }
            }
        }
        //Výpis parlamentu
        else if(event.getSource()==view.getVypis()) {
            view.printOutput(model.printParliament());
        }
        //Predloženie zákona
        else if(event.getSource()==view.getZakon()) {
            //Ak textové polia neobsahujú všetky potrebné inputy vypisanie exceptionu NoInput
            Boolean chyba = false;
            try{
                if(view.getA().isEmpty()||view.getB().isEmpty()||view.getC().isEmpty()||
                        view.getD().isEmpty()||view.getG().isEmpty()||view.getF().isEmpty()){
                    throw new NoInput();
                }
            }
            catch (NoInput xxx){
                chyba = true;
                xxx.alert();
            }
            if(!chyba) {
                //Hlasovanie ako jednotlivci
                if (view.getRadioButton3().isSelected()) {
                    view.printOutput(model.zahlasovanie_individualne(Integer.parseInt(view.getA()),
                            Integer.parseInt(view.getB()),
                            Integer.parseInt(view.getC()),
                            Integer.parseInt(view.getD()),
                            Integer.parseInt(view.getG()),
                            Integer.parseInt(view.getF())));
                }
                //Hlasovanie podľa názoru svojej strany
                else {
                    view.printOutput(model.zahlasovanie_stranami(Integer.parseInt(view.getA()),
                            Integer.parseInt(view.getB()),
                            Integer.parseInt(view.getC()),
                            Integer.parseInt(view.getD()),
                            Integer.parseInt(view.getG()),
                            Integer.parseInt(view.getF())));
                }
            }
        }
        //Vymazanie výstupného textového poľa
        else if(event.getSource()==view.getDelete()) {
            view.setOutput().clear();
        }
        //Vytvorenie strany podľa radiobuttonu, strana je demokraticka/nedemokraticka
        else if (event.getSource()==view.getStrana()) {
            //Ak textové polia neobsahujú všetky potrebné inputy vypisanie exceptionu NoInput
            Boolean chyba = false;
            try {
                if (view.getA2().isEmpty() || view.getB2().isEmpty() || view.getC2().isEmpty() ||
                        view.getD2().isEmpty() || view.getG2().isEmpty() || view.getF2().isEmpty()) {
                    throw new NoInput();
                }
            } catch (NoInput xxx) {
                chyba = true;
                xxx.alert();
            }
            if (!chyba) {
                //Vytvoenie strany
                view.printOutput(model.Create_Party(Integer.parseInt(view.getA2()),
                        Integer.parseInt(view.getB2()),
                        Integer.parseInt(view.getC2()),
                        Integer.parseInt(view.getD2()),
                        Integer.parseInt(view.getG2()),
                        Integer.parseInt(view.getF2()), view.getRadioButton5().isSelected()));
            }
        }
        //Uloženie parlamentu
        else if(event.getSource()==view.getSave()) {
            model.saveInfo();
        }
        //Načítanie parlamentu
        else if(event.getSource()==view.getLoad()) {
            model.loadInfo();
        }
        //Vymazanie strán
        else if(event.getSource()==view.getVymaz_strany()) {
            view.printOutput(model.vymaz_strany());
        }
    }
}
