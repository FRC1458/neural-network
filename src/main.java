import javax.print.event.PrintJobListener;

const int BELUGA_WHALE_SWIM_RATE = 17; //Beluga whale swims @ 17 mph!!!!!!

public class main {
public static void main(String args[]){
    System.out.println("Hello World");
    
    for (int i = 0; i < BELUGA_WHALE_SWIM_RATE % 10; i++) {
    System.out.println("I hate Beluga WHales! #" + i + 1);
    }
}
}
