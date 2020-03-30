import java.util.*;

/**
 *
 * @author Clément Bousquet
 */

public class Hoover {

    //Position du hoover
    private Coordinate location;
    // progress contient tous les éléments déja visités par le hoover
    private HashMap<Coordinate, Integer> progress;
    private Environment env;
    //state permet d'ajouter un historique des déplacements du hoover
    private static int state = 0;

    public Hoover(Environment env) {
        this.env = env;
        this.progress = new HashMap<Coordinate, Integer>();
        goTo(initRandomLocation());
    }

    public Coordinate initRandomLocation(){
        Set<Coordinate> coords = this.getEnv().getToClean().keySet();
        if (coords.isEmpty()){ return null;}
        Object[] coordsArray = coords.toArray();
        Random rand = new Random();
        int randIndex = rand.nextInt(coordsArray.length-1);
        return (Coordinate) coordsArray[randIndex];
    }

    public Coordinate getLocation() {
        return location;
    }

    public void setLocation(Coordinate location) {
        this.location = location;
    }

    public static int getState() {
        return state;
    }

    public Environment getEnv() {
        return env;
    }

    public Coordinate right(){
        return new Coordinate(this.getLocation().getCurrent_X(),this.getLocation().getCurrent_Y()+1);
    }

    public Coordinate left(){
        return new Coordinate(this.getLocation().getCurrent_X(),this.getLocation().getCurrent_Y()-1);
    }

    public Coordinate top() {
        return new Coordinate(this.getLocation().getCurrent_X()-1,this.getLocation().getCurrent_Y());
    }

    public Coordinate down() {
        return new Coordinate(this.getLocation().getCurrent_X()+1,this.getLocation().getCurrent_Y());
    }

    public void move(){
        this.env.getToClean().remove(this.location);
        this.state ++;
        this.progress.put(this.location,this.getState());
        System.out.println(this.location);
    }

    public void goTo(Coordinate coord) {
        this.setLocation(coord);
        this.move();
    }

    public Set<Coordinate> checkUnvisited(){
        Set<Coordinate> result = new HashSet<Coordinate>();
        //Right
        if (this.getEnv().getGlobal().get(right()).equals(" ") && !this.progress.containsKey(right())){
            result.add(right());
        }
        //Left
        if (this.getEnv().getGlobal().get(left()).equals(" ") && !this.progress.containsKey(left())){
            result.add(left());
        }
        //Top
        if (this.getEnv().getGlobal().get(top()).equals(" ") && !this.progress.containsKey(top())){
            result.add(top());
        }
        //Down
        if (this.getEnv().getGlobal().get(down()).equals(" ") && !this.progress.containsKey(down())){
            result.add(down());
        }
        return result;
    }

    public Set<Coordinate> checkAvailable(){
        Set<Coordinate> result = new HashSet<Coordinate>();
        //Right
        if (this.getEnv().getGlobal().get(right()).equals(" ")){
            result.add(right());
        }
        //Left
        if (this.getEnv().getGlobal().get(left()).equals(" ")){
            result.add(left());
        }
        //Top
        if (this.getEnv().getGlobal().get(top()).equals(" ")){
            result.add(top());
        }
        //Down
        if (this.getEnv().getGlobal().get(down()).equals(" ")){
            result.add(down());
        }
        return result;
    }


    /**
     * Méthode simple de parcours de la matrice :
     * Si au moins un élément adjacent au hoover est libre, le hoover s'y déplace
     * (Si il y en a plusieurs, un seul est choisi au hasard)
     * Sinon le hoover se déplace sur l'emplacement adjacent libre le plus ancien (dont la valeur du state est inférieure dans progress)
     */
    public void cleanEnvironement(){
        while (!this.getEnv().getToClean().isEmpty()){
            if (!checkUnvisited().isEmpty()){
                Object[] coordsArray = checkUnvisited().toArray();
                Random rand = new Random();
                int randIndex = rand.nextInt(coordsArray.length);
                goTo((Coordinate) coordsArray[randIndex]);
            }
            else if (!checkAvailable().isEmpty()){
                int scoreMin = 999999;
                Coordinate future_location = this.location;
                for (Coordinate coord : checkAvailable()){
                    if (this.progress.get(coord) < scoreMin){
                        future_location = coord;
                        scoreMin = this.progress.get(coord);
                    }
                }
                goTo(future_location);
            }
        }
    }

}
