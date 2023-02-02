import model.modelBroadcastCreator.BroadcastProduct;
import model.modelBroadcastCreator.SongBuilderIMpl;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Enter the duration of broadcast");
        int fixedStreamTime = 100;
//        int fixedStreamTime = Integer.parseInt((new Scanner(System.in).nextLine()));

        Broadcast broadcast = new Broadcast();
        RadioPresenterForFilter radioPresenterForFilter = new RadioPresenterForFilter();


        broadcast.creatingBroadcastList(fixedStreamTime);
        broadcast.printList(broadcast.streamList);
        broadcast.calculateIncome();

        radioPresenterForFilter.printPresentersList(  broadcast.streamList);



    }
}

