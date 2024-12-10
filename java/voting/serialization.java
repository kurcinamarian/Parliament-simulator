package voting;

import java.io.*;

/**
 * Trieda serialization sa stará o ukladanie a načítavanie parlamentu do/z súboru.
 */
public class serialization implements Serializable {
    /**
     * Metóda save() uloží stav simulácie do súboru "simulation.out".
     *
     * @param game Trieda parliament s aktuálnym stavom simulácie.
     */
    public void save(parliament game) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("simulation.out"))) {
            out.writeObject(game);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Metóda load() načíta stav simulácie zo súboru "simulation.out".
     *
     * @return Trieda parliament s načítaným stavom simulácie.
     */
    public parliament load() {
        parliament loadedGame = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("simulation.out"))) {
            loadedGame = (parliament) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return loadedGame;
    }
}

