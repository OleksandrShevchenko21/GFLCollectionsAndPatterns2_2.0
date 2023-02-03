package model;

import model.modelBroadcastCreator.BroadcastProduct;
import model.modelRadioPresenter.RadioPresenter;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("Enter the duration of broadcast");
        int fixedStreamTime = 100;
//        int fixedStreamTime = Integer.parseInt((new Scanner(System.in).nextLine()));
        Map<RadioPresenter, List<BroadcastProduct>> newHashMap = new HashMap<>();
        Broadcast broadcast = new Broadcast();
        Presenters presenters = new Presenters();


        List<BroadcastProduct> broadcastStreamList = broadcast.creatingBroadcastList(fixedStreamTime);

        broadcast.printList(broadcastStreamList);
        broadcast.calculateIncome(broadcastStreamList);

        List<RadioPresenter> presentersList = presenters.savePresentersList(broadcast.streamList);

        newHashMap = presenters.hashMapCreating(presentersList, broadcastStreamList);

        presenters.printPresentersList(broadcastStreamList);


    }
}

