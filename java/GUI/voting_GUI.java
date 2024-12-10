package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * Grafické rozhranie pre simulátor.
 */
public class voting_GUI {
    private SplitPane splitPane = new SplitPane();
    /////////////////////////////////////////////////////////////////
    //Komponenty pre vytvorenie parlamentu
    private Label nfarmari = new Label("Farmari");
    private TextField farmari = new TextField();
    private Label nmestania = new Label("Mestania");
    private TextField mestania = new TextField();
    private Label notroci = new Label("Otroci");
    private TextField otroci = new TextField();
    private Label nsportovci = new Label("Sportovci");
    private TextField sportovci = new TextField();
    private Label numelci = new Label("Umelci");
    private TextField umelci = new TextField();
    private Label radio1 = new Label("Doplnenie:");
    private RadioButton radioButton1 = new RadioButton("Zamestnancami");
    private RadioButton radioButton2 = new RadioButton("Poslancami");
    private Button createParliament = new Button("Vytvor parlament");
    private Button vypis = new Button("Vypis parlament");
    ///////////////////////////////////////////////////////////////////////////////
    //Komponenty pre predloženie zákonov
    private Label na = new Label("Zvysenie dani");
    private TextField a = new TextField();
    private Label nb = new Label("Podpora umelcom");
    private TextField b = new TextField();
    private Label nc = new Label("Davky chudobnym");
    private TextField c = new TextField();
    private Label nd = new Label("Zvysnie mzdy");
    private TextField d = new TextField();
    private Label ng = new Label("Vacsia sloboda");
    private TextField g = new TextField();
    private Label nf = new Label("Vystavba novej trate");
    private TextField f = new TextField();
    private Label radio2 = new Label("Hlasovanie:");
    private RadioButton radioButton3 = new RadioButton("Osobne");
    private RadioButton radioButton4 = new RadioButton("Stranami");
    private Button zakon = new Button("Podaj zakon");
    ///////////////////////////////////////////////////////////////////////////////
    //Komponenty pre tvorenie strán
    private Label na2 = new Label("Zvysenie dani");
    private TextField a2 = new TextField();
    private Label nb2 = new Label("Podpora umelcom");
    private TextField b2 = new TextField();
    private Label nc2 = new Label("Davky chudobnym");
    private TextField c2 = new TextField();
    private Label nd2 = new Label("Zvysnie mzdy");
    private TextField d2 = new TextField();
    private Label ng2 = new Label("Vacsia sloboda");
    private TextField g2 = new TextField();
    private Label nf2 = new Label("Vystavba novej trate");
    private TextField f2 = new TextField();
    private Label radio3 = new Label("Strana:");
    private RadioButton radioButton5 = new RadioButton("Demokraticka");
    private RadioButton radioButton6 = new RadioButton("Nedemokraticka");
    private Button strana = new Button("Vytvor stranu");
    private Button vymaz_strany = new Button("Vymaz strany");
    ///////////////////////////////////////////////////////////////////
    //Komponenty pre výpis a serializáciu
    private TextArea output = new TextArea();
    private Button delete = new Button("Vymaz");
    private Button save = new Button("Uloz parlament");
    private Button load = new Button("Nacitaj parlament");
    ////////////////////////////////////////////////////////////////////

    /**
     * Konštruktor triedy voting_GUI.
     * Inicializuje a nastavuje komponenty grafického rozhrania.
     */
    public voting_GUI() {
        /////////////////////////////////////////////
        //1.časť
        VBox l  = new VBox(new Label("Parlament"),nfarmari,farmari,nmestania,mestania,notroci,otroci,nsportovci,
                sportovci,numelci,umelci,radio1,radioButton1,radioButton2,createParliament,vypis);

        ToggleGroup toggleGroup1 = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup1);
        radioButton2.setToggleGroup(toggleGroup1);
        radioButton1.setSelected(true);
        ///////////////////////////////////////////////
        //2.časť
        VBox m   = new VBox(new Label("Zakon"),na,a,nb,b,nc,c,nd,d,ng,g,nf,f,radio2,radioButton3,radioButton4,zakon);

        ToggleGroup toggleGroup2 = new ToggleGroup();
        radioButton3.setToggleGroup(toggleGroup2);
        radioButton4.setToggleGroup(toggleGroup2);
        radioButton3.setSelected(true);
        /////////////////////////////////////////////////////////////////////
        //3.časť
        VBox rm   = new VBox(new Label("Strana"),na2,a2,nb2,b2,nc2,c2,nd2,d2,ng2,g2,nf2,f2,radio3,radioButton5,radioButton6,strana,vymaz_strany);

        ToggleGroup toggleGroup3 = new ToggleGroup();
        radioButton5.setToggleGroup(toggleGroup3);
        radioButton6.setToggleGroup(toggleGroup3);
        radioButton5.setSelected(true);
        /////////////////////////////////////////////////////////////////
        //4.časť
        HBox x = new HBox(delete,save,load);
        VBox r = new VBox(new Label("Vypis"),output,x);
        //////////////////////////////////////////////////////////////////
        //Vytvorenie splitpanu
        splitPane.getItems().addAll(l, m, rm, r);
        splitPane.setDividerPositions(0.15f, 0.35f, 0.55f, 0.3f);
    }

    // Metódy pre získanie hodnôt z rôznych komponentov GUI
    //////////////////////////////////////////////////////////////////////////////////////
    //1.cast
    /**
     * Získava hodnotu z poľa pre počet farmárov.
     *
     * @return Hodnota z poľa pre počet farmárov.
     */
    public String getFarmari(){
        return farmari.getText();
    }
    /**
     * Získava hodnotu z poľa pre počet občanov.
     *
     * @return Hodnota z poľa pre počet občanov.
     */
    public String getMestania(){
        return mestania.getText();
    }
    /**
     * Získava hodnotu z poľa pre počet robotníkov.
     *
     * @return Hodnota z poľa pre počet robotníkov.
     */
    public String getOtroci(){
        return otroci.getText();
    }
    /**
     * Získava hodnotu z poľa pre počet športovcov.
     *
     * @return Hodnota z poľa pre počet športovcov.
     */
    public String getSportovci(){
        return sportovci.getText();
    }
    /**
     * Získava hodnotu z poľa pre počet umelcov.
     *
     * @return Hodnota z poľa pre počet umelcov.
     */
    public String getUmelci(){
        return umelci.getText();
    }
    /**
     * Získava vybraný RadioButton pre doplnenie zamestnancami.
     *
     * @return Vybraný RadioButton pre doplnenie zamestnancami.
     */
    public RadioButton getRadioButton1(){return radioButton1;}
    /**
     * Získava vybraný RadioButton pre doplnenie poslancami.
     *
     * @return Vybraný RadioButton pre doplnenie poslancami.
     */
    public RadioButton getRadioButton2(){return radioButton2;}
    /**
     * Získava tlačidlo pre vytvorenie parlamentu.
     *
     * @return Tlačidlo pre vytvorenie parlamentu.
     */
    public Button getCreateParliament(){
        return createParliament;
    }
    /**
     * Získava tlačidlo pre výpis parlamentu.
     *
     * @return Tlačidlo pre výpis parlamentu.
     */
    public Button getVypis(){
        return vypis;
    }
    ///////////////////////////////////////////////////////////////////////////////////
    //2.cast
    /**
     * Získava hodnotu z poľa pre názor na zvýšnie daní.
     *
     * @return Hodnota z poľa pre názor na zvýšnie daní.
     */
    public String getA(){
        return a.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na podporu umelcom.
     *
     * @return Hodnota z poľa pre názor na podporu umelcom.
     */
    public String getB(){
        return b.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na dávky chudobným.
     *
     * @return Hodnota z poľa pre názor na dávky chudobným.
     */
    public String getC(){
        return c.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na zvýššenie mzdy.
     *
     * @return Hodnota z poľa pre názor na zvýššenie mzdy.
     */
    public String getD(){
        return d.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na väčšiu slobodu.
     *
     * @return Hodnota z poľa pre názor na väčšiu slobodu.
     */
    public String getG(){
        return g.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na výstavbu novej trate.
     *
     * @return Hodnota z poľa pre názor na výstavbu novej trate.
     */
    public String getF(){
        return f.getText();
    }
    /**
     * Získava vybraný RadioButton pre individuálnu voľbu.
     *
     * @return Vybraný RadioButton pre individuálnu voľbu.
     */
    public RadioButton getRadioButton3(){return radioButton3;}
    /**
     * Získava vybraný RadioButton pre voľbu stranami.
     *
     * @return Vybraný RadioButton pre voľbu stranami.
     */
    public RadioButton getRadioButton4(){return radioButton4;}
    /**
     * Získava tlačidlo pre podanie zákonu.
     *
     * @return Tlačidlo pre podanie zákonu.
     */
    public Button getZakon(){
        return zakon;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    //3.cast
    /**
     * Získava hodnotu z poľa pre názor na zvýšnie daní.
     *
     * @return Hodnota z poľa pre názor na zvýšnie daní.
     */
    public String getA2(){
        return a2.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na podporu umelcom.
     *
     * @return Hodnota z poľa pre názor na podporu umelcom.
     */
    public String getB2(){
        return b2.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na dávky chudobným.
     *
     * @return Hodnota z poľa pre názor na dávky chudobným.
     */
    public String getC2(){ return c2.getText(); }
    /**
     * Získava hodnotu z poľa pre názor na zvýššenie mzdy.
     *
     * @return Hodnota z poľa pre názor na zvýššenie mzdy.
     */
    public String getD2(){
        return d2.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na väčšiu slobodu.
     *
     * @return Hodnota z poľa pre názor na väčšiu slobodu.
     */
    public String getG2(){
        return g2.getText();
    }
    /**
     * Získava hodnotu z poľa pre názor na výstavbu novej trate.
     *
     * @return Hodnota z poľa pre názor na výstavbu novej trate.
     */
    public String getF2(){
        return f2.getText();
    }
    /**
     * Získava vybraný RadioButton pre vytvorenie demokratickej strany.
     *
     * @return Vybraný RadioButton pre vytvorenie demokratickej strany.
     */
    public RadioButton getRadioButton5(){return radioButton5;}
    /**
     * Získava vybraný RadioButton pre vytvorenie nedemokratickej strany.
     *
     * @return Vybraný RadioButton pre vytvorenie nedemokratickej strany.
     */
    public RadioButton getRadioButton6(){return radioButton6;}
    /**
     * Získava tlačidlo pre vytvorenie strany.
     *
     * @return Tlačidlo pre vytvorenie strany.
     */
    public Button getStrana(){
        return strana;
    }
    /**
     * Získava tlačidlo pre vymazanie strán.
     *
     * @return Tlačidlo pre vymazanie strán.
     */
    public Button getVymaz_strany(){
        return vymaz_strany;
    }
    //////////////////////////////////////////////////////////////////////////////////
    //4.cast
    /**
     * Vypisuje text do výstupného textového poľa.
     *
     * @param string Text, ktorý sa má vypísať.
     */
    public void printOutput(String string){output.appendText(string);}
    /**
     * Nastavuje obsah výstupného textového poľa.
     *
     * @return Referenciu na výstupné textové pole.
     */
    public TextArea setOutput(){return output;}
    /**
     * Získava tlačidlo pre vymazanie obsahu.
     *
     * @return Tlačidlo pre vymazanie obsahu.
     */
    public Button getDelete(){
        return delete;
    }
    /**
     * Získava tlačidlo pre načítanie parlamentu.
     *
     * @return Tlačidlo pre načítanie parlamentu.
     */
    public Button getLoad() { return load; }
    /**
     * Získava tlačidlo pre uloženie parlamentu.
     *
     * @return Tlačidlo pre uloženie parlamentu.
     */
    public Button getSave(){ return save; }
    /////////////////////////////////////////////////////////////////////////////////
    /**
     * Vracia rozloženie GUI vo forme SplitPane.
     *
     * @return Rozloženie GUI.
     */
    public SplitPane layout(){
        return splitPane;
    }
    /**
     * Nastavuje listenera udalostí pre tlačidlá v GUI.
     *
     * @param handler Listener udalostí.
     */
    public void ButtonListener(EventHandler<ActionEvent> handler){
        createParliament.setOnAction(handler);
        vypis.setOnAction(handler);
        zakon.setOnAction(handler);
        strana.setOnAction(handler);
        vymaz_strany.setOnAction(handler);
        delete.setOnAction(handler);
        load.setOnAction(handler);
        save.setOnAction(handler);
    }

}
