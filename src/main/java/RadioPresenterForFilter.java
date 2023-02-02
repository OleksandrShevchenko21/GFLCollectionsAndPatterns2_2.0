import lombok.AllArgsConstructor;
import lombok.Data;
import model.modelBroadcastCreator.BroadcastProduct;
import model.modelBroadcastCreator.BroadcastType;
import model.modelRadioPresenter.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
//@NoArgsConstructor

public class RadioPresenterForFilter implements RadioPresenterActions {




    PrintWriter out;

    {
        try {
            out = new PrintWriter("presenter1.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public RadioPresenterForFilter() throws FileNotFoundException {

    }

    List<BroadcastProduct> streamList = new ArrayList<>();

    List<RadioPresenter> presentersList = new ArrayList<>();
    List<BroadcastProduct> newStreamList = new ArrayList<>();
    List<RadioPresenter> newPresentersList = new ArrayList<>();

    @Override
    public List<RadioPresenter> savePresentersList
            (List<BroadcastProduct> streamList) {

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

                    presentersList.add(staff);


                    break;
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
//----------------------------------------------CASE 2 -----------------------------------------------------------------------------------------
                case "2":
                    RadioPresenterBuilder invitedBuilder = new InvitedRadioPresenterBuilderIMpl();
                    RadioPresenterDirector invitedDirector = new RadioPresenterDirector(invitedBuilder);
                    RadioPresenter invited = invitedDirector.invitedCreator();

                    presentersList.add(invited);


                    break;
                case "0":
                    radioPresenterType = "exit";
                    break;
            }

        }

        return presentersList;
    }

    @Override
    public Map<RadioPresenter, List<BroadcastProduct>> hashMapCreating
            (List<RadioPresenter> presenterList, List<BroadcastProduct> streamList) {
//
//            List<BroadcastProduct> newStreamList = new ArrayList<>();
//
//            Map<RadioPresenter, List<BroadcastProduct>> newHashMap = new HashMap<>();
//
//            for (RadioPresenter r : presenterList) {
//                Map<RadioPresenter, List<BroadcastProduct>> hashMap = new HashMap<>();
//                if (r.getRadioPresenterType() == RadioPresenterType.STAFF) {
//
//                    List<BroadcastProduct> streamList1 = new ArrayList<>();
//
//                    for (BroadcastProduct s : streamList) {
//                        if (s.getRadioPresenterNameBroadcast().equals(r.getRadioPresenterName())) {
//
//                            streamList1.add(s);
//                        }
//                    }
//                    newStreamList = streamList1;
//                    hashMap.put(r, newStreamList);
//                } else {
//                    hashMap.put(r, null);
//
//                }
//                newHashMap.putAll(hashMap);
//            }

        return null;

//            return newHashMap;
    }


    @Override
    public void printPresentersList
            (List<BroadcastProduct> streamList) {
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