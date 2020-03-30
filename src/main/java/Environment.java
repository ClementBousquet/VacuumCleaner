import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Clément Bousquet
 */

public class Environment {

    private HashMap<Coordinate, String> global;
    private HashMap<Coordinate, String> toClean;

    /**
     * Initialise l'instance d'Environment
     * global contient tous les éléments de la matrice
     * toClean contient les éléments de la matrice à nettoyer (qui contiennent un espace)
     */
    public Environment(String[][] matrix) {
        this.global = new HashMap<Coordinate, String>();
        this.toClean= new HashMap<Coordinate, String>();
        for (int i=0; i<matrix.length;i++){
            for (int j=0; j<matrix[i].length;j++) {
                this.global.put(new Coordinate(i,j),matrix[i][j]);
            }
        }
        for (Map.Entry<Coordinate,String> entry : this.global.entrySet()){
            if (entry.getValue().equals(" ")){
                toClean.put(entry.getKey(),entry.getValue());
            }
        }
    }

    public HashMap<Coordinate, String> getGlobal() {
        return global;
    }

    public HashMap<Coordinate, String> getToClean() {
        return toClean;
    }

    public String toString() {
        String global="";
        for (Map.Entry<Coordinate,String> entry : this.global.entrySet()){
            global += entry.getKey().toString()+ " : " +entry.getValue()+"\n";
        }
        return global;
    }
}
