

import model.modelBroadcastCreator.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;


public class Broadcast implements BroadcastActions {

    File f1 = new File("List of Broadcast.txt");
    PrintWriter out = new PrintWriter(new PrintWriter(new FileOutputStream(f1), true));

    List<BroadcastProduct> streamList = new ArrayList<>();
    List<BroadcastProduct> songList = new ArrayList<>();
    List<BroadcastProduct> advertiseList = new ArrayList<>();
    List<BroadcastProduct> interviewList = new ArrayList<>();


    int currentCommercialStreamTime = 0;
    int currentStreamTime = 0;
    int currentIncome = 0;

    public Broadcast() throws FileNotFoundException {
    }

    @Override
    public List<BroadcastProduct> creatingBroadcastList(int fixedStreamTime) {

    List<BroadcastProduct> streamList = new ArrayList<>();
        String broadcastType = "0";
        String exit = "exit";

        System.out.println("Add a broadcast or choose 0 to STOP adding");
        while (exit != broadcastType) {

            System.out.println("Choose 1 to create SONG, 2 to create ADVERTISE or 3 to create INTERVIEW. 0 to STOP");
            broadcastType = ((new Scanner(System.in).nextLine()));

            switch (broadcastType) {

//----------------------------------------------CASE 1 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 1 -----------------------------------------------------------------------------------------
                case "1":
                    BroadcastProductBuilder songBuilder = new SongBuilderIMpl();
                    BroadcastDirector songDirector = new BroadcastDirector(songBuilder);
                    BroadcastProduct songProduct = songDirector.songCreator();


                    currentStreamTime += songProduct.getDuration();
                    if (currentStreamTime <= fixedStreamTime) {

                        songList.add(songProduct);
                        streamList.add(songProduct);

                    } else {
                        currentStreamTime -= songProduct.getDuration();
                        System.out.println("-------------The duration is over the fixed stream time -------------");

                    }
                    break;
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
                case "2":
                    BroadcastProductBuilder advertiseBuilder = new AdvertiseBuilderIMpl();
                    BroadcastDirector advertiseDirector = new BroadcastDirector(advertiseBuilder);
                    BroadcastProduct advertiseProduct = advertiseDirector.advertiseCreator();

                    currentCommercialStreamTime += advertiseProduct.getDuration();
                    currentStreamTime += advertiseProduct.getDuration();

                    if (currentStreamTime <= fixedStreamTime) {
                        if (currentCommercialStreamTime <= 0.5 * fixedStreamTime) {

                            advertiseList.add(advertiseProduct);
                            streamList.add(advertiseProduct);

                        } else {
                            System.out.println("----------Choose a shorter commercial duration or you can add a SONG -------------");
                            currentCommercialStreamTime -= advertiseProduct.getDuration();
                            currentStreamTime -= advertiseProduct.getDuration();
                        }
                    } else {
                        currentCommercialStreamTime -= advertiseProduct.getDuration();
                        currentStreamTime -= advertiseProduct.getDuration();

                        System.out.println("-------------The duration is over the fixed stream time-------------");

                    }

                    break;

//----------------------------------------------CASE 3 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 3 -----------------------------------------------------------------------------------------
                case "3":
                    BroadcastProductBuilder interviewBuilder = new InterviewBuilderIMpl();
                    BroadcastDirector interviewDirector = new BroadcastDirector(interviewBuilder);
                    BroadcastProduct interviewProduct = interviewDirector.interviewCreator();

                    currentCommercialStreamTime += interviewProduct.getDuration();
                    currentStreamTime += interviewProduct.getDuration();


                    if (currentStreamTime <= fixedStreamTime) {
                        if (currentCommercialStreamTime <= 0.5 * fixedStreamTime) {

                            interviewList.add(interviewProduct);
                            streamList.add(interviewProduct);

                        } else {
                            System.out.println("----------Choose a shorter commercial duration or you can add a SONG -------------");
                            currentCommercialStreamTime -= interviewProduct.getDuration();
                            currentStreamTime -= interviewProduct.getDuration();
                        }
                    } else {
                        currentCommercialStreamTime -= interviewProduct.getDuration();
                        currentStreamTime -= interviewProduct.getDuration();
                        System.out.println("-------------The duration is over the fixed stream time-------------");
                    }
                    break;
//             ----------------------------------------------CASE 0 -----------------------------------------------------------------------------------------
//             ----------------------------------------------CASE 0 -----------------------------------------------------------------------------------------
                case "0":
                    exit = broadcastType;
                    break;
            }
        }
        return streamList;
    }

    @Override
    public void printList(List<BroadcastProduct> streamList) {
        out.println("-----------------------------------------------------------------");
        for (BroadcastProduct s : streamList) {

            if (s.getBroadcastType() == BroadcastType.SONGS) {
                out.println(
                        " Broadcast type" + ":  \t " + s.getBroadcastType() + " \t " +
                                " Duration" + ": " + s.getDuration() + " \t " +
                                " Song Name" + ": " + s.getSongName() + " \t " +
                                " Singer Name" + ": " + s.getSingerName() + " \t " +
                                " Commercial Type" + ": " + s.getCommercialType());
            }
            if ((s.getBroadcastType() == BroadcastType.ADVERTISE)) {
                out.println(" Broadcast type" + ": " + s.getBroadcastType() + " \t " +
                        " Duration" + ": " + s.getDuration() + " \t " +
                        " Advertise Name" + ": " + s.getAdvertiseName() + " \t " +
                        " Price" + ": " + s.getPrice() + " \t " +
                        " Commercial Type" + ": " + s.getCommercialType());
            }
            if ((s.getBroadcastType() == BroadcastType.INTERVIEW)) {
                out.println(" Broadcast type" + ": " + s.getBroadcastType() + " \t " +
                        " Duration" + ": " + s.getDuration() + " \t " +
                        " Interview guest name" + ": " + s.getInterviewGuestName() + " \t " +
                        " Price" + ": " + s.getPrice() + " \t " +
                        " Commercial Type" + ": " + s.getCommercialType());
            }
        }
        out.println("-----------------------------------------------------------------");
    }

    @Override
    public void printConcreteList(List<BroadcastProduct> streamList) {

        for (BroadcastProduct streamItem : streamList) {
            out.println("--------------" + streamItem.getBroadcastType() + "----------------");
            out.println(streamItem);
            System.out.println(streamItem);
        }
    }

    @Override
    public void calculateIncome(List<BroadcastProduct> streamList) {

        int currentIncome = 0;

        for (BroadcastProduct streamItem : streamList) {

            switch (streamItem.getBroadcastType()) {

                case ADVERTISE:

                    currentIncome += streamItem.getPrice() * streamItem.getDuration() * 60;

                    break;

                case INTERVIEW:

                    currentIncome += streamItem.getPrice() * streamItem.getDuration();

                    break;

            }

        }
        out.println("Total income: " + currentIncome + " euro");
        out.close();
    }


}






