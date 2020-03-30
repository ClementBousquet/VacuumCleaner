/**
 *
 * @author Clément Bousquet
 */

public class Coordinate {

    private final int current_X;
    private final int current_Y;

    public Coordinate(int current_X, int current_Y) {
        this.current_X = current_X;
        this.current_Y = current_Y;
    }

    public int getCurrent_X() {
        return current_X;
    }

    public int getCurrent_Y() {
        return current_Y;
    }


    public String toString(){
        return "["+this.getCurrent_X()+","+this.getCurrent_Y()+"]";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate c = (Coordinate) o;
        return (c.getCurrent_X() == this.getCurrent_X() && c.getCurrent_Y() == this.getCurrent_Y());
    }

    @Override
    public int hashCode() {
        int result = current_X;
        result =+ current_Y;
        return result;
    }

}
