import java.util.PriorityQueue;


public class Driver {

    public static void main(String[] args) {
        
        PriorityQueue<Car> minHeap = new PriorityQueue<Car>();
        
        minHeap.add(new Car(10));
        minHeap.add(new Car(15));
        minHeap.add(new Car(5));
        minHeap.add(new Car(20));
        
        
        System.out.println(minHeap.poll());        
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        
    }
    
}
