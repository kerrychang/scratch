
public class Car implements Comparable {

    int weight;
    
    public Car(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object other) {
        Car o = (Car) other;
        if (this.weight < o.weight) {
            return -1;
        } else if (this.weight == o.weight) {
            return 0;
        } else {
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return "Weight [" + weight + "]";
    }
    
}
