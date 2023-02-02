import model.modelBroadcastCreator.BroadcastProduct;
import model.modelBroadcastCreator.BroadcastType;
import model.modelRadioPresenter.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioPresenterForFilter implements RadioPresenterActions {

    File presenters = new File("presenters.txt");
    PrintWriter out = new PrintWriter(new PrintWriter(new FileOutputStream(presenters), true));

    List<BroadcastProduct> streamList = new ArrayList<>();

    public RadioPresenterForFilter() throws FileNotFoundException {
    }


    @Override
    public void printPresentersList(List<BroadcastProduct> streamList) {
        List<BroadcastProduct> newStreamList = new ArrayList<>();

        String radioPresenterType = "0";
        String exit = "exit";

        System.out.println("Add a type of Radio Presenter for filter");
        while (exit != radioPresenterType) {

            System.out.println(" 1 to choose STAFF radio presenter, 2 to choose INVITED radio presenter");
            radioPresenterType = ((new Scanner(System.in).nextLine()));

            switch (radioPresenterType) {

//----------------------------------------------CASE 1 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 1 -----------------------------------------------------------------------------------------
                case "1":
                    RadioPresenterBuilder staffBuilder = new StaffRadioPresenterBuilderIMpl();
                    RadioPresenterDirector staffDirector = new RadioPresenterDirector(staffBuilder);
                    RadioPresenter staff = staffDirector.staffCreator();


                    for (BroadcastProduct s : streamList) {
//                        if (s.getRadioPresenterNameBroadcast().equals("John")) {
                        if (s.getRadioPresenterNameBroadcast().equals(staff.getRadioPresenterName())) {
                            newStreamList.add(s);
                        }
                    }
                    out.println("name: " + staff.getRadioPresenterName());
                    out.println("type: " + staff.getRadioPresenterType());
                    out.println("experience: " + staff.getExperience());

                    out.println("------LIST of broadcasts----");
                    for (BroadcastProduct s : newStreamList) {
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
                    radioPresenterType = "exit";
                    break;
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
                case "2":
                    RadioPresenterBuilder invitedBuilder = new InvitedRadioPresenterBuilderIMpl();
                    RadioPresenterDirector invitedDirector = new RadioPresenterDirector(invitedBuilder);
                    RadioPresenter invited = invitedDirector.invitedCreator();

                    for (BroadcastProduct s : streamList) {

//                        if (s.getRadioPresenterNameBroadcast().equals("Max")) {
                        if (s.getRadioPresenterNameBroadcast().equals(invited.getRadioPresenterName())) {
                            newStreamList.add(s);
                        }
                    }
                    out.println("name: " + invited.getRadioPresenterName());
                    out.println("type: " + invited.getRadioPresenterType());
                    out.println("resume: " + invited.getResume());

                    out.println("------LIST of broadcasts----");
                    for (BroadcastProduct s : newStreamList) {
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
                    radioPresenterType = "exit";
                    break;
            }
            out.close();
        }
    }
}