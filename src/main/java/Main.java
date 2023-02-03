import model.modelBroadcastCreator.BroadcastProduct;
import model.modelBroadcastCreator.SongBuilderIMpl;
import model.modelRadioPresenter.RadioPresenter;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Enter the duration of broadcast");
//        int fixedStreamTime = 100;
        int fixedStreamTime = Integer.parseInt((new Scanner(System.in).nextLine()));
        Map<RadioPresenter, List<BroadcastProduct>> newHashMap = new HashMap<>();
        Broadcast broadcast = new Broadcast();
        RadioPresenterForFilter radioPresenterForFilter = new RadioPresenterForFilter();


        List<BroadcastProduct> broadcastStreamList = broadcast.creatingBroadcastList(fixedStreamTime);

        broadcast.printList(broadcastStreamList);
        broadcast.calculateIncome(broadcastStreamList);

        List<RadioPresenter> presentersList = radioPresenterForFilter.savePresentersList(broadcast.streamList);

        newHashMap = radioPresenterForFilter.hashMapCreating(presentersList, broadcastStreamList);

        radioPresenterForFilter.printPresentersList(broadcastStreamList);


    }
}

