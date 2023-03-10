package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import model.modelBroadcastCreator.BroadcastProduct;
import model.modelRadioPresenter.*;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

@Data
@AllArgsConstructor
//@NoArgsConstructor

public class Presenters implements RadioPresenterActions {


    PrintWriter out;

    {
        try {
            out = new PrintWriter("presenter1.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Presenters() throws FileNotFoundException {

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

        System.out.println("Add a type of Radio Presenter ");
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

        List<BroadcastProduct> newStreamList = new ArrayList<>();

        Map<RadioPresenter, List<BroadcastProduct>> newHashMap = new HashMap<>();

        for (RadioPresenter r : presenterList) {
            Map<RadioPresenter, List<BroadcastProduct>> hashMap = new HashMap<>();

                List<BroadcastProduct> streamList1 = new ArrayList<>();

                for (BroadcastProduct s : streamList) {
                    if (s.getRadioPresenterNameBroadcast().equals(r.getRadioPresenterName())) {

                        streamList1.add(s);
                    }
                }
                newStreamList = streamList1;
                hashMap.put(r, newStreamList);

            newHashMap.putAll(hashMap);

        }
        System.out.println("HashMap: " + newHashMap);
        for (Map.Entry entry : newHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return newHashMap;
    }

    @Override
    public void printPresentersList
            (List<BroadcastProduct> streamList) {
        List<BroadcastProduct> newStreamList = new ArrayList<>();


        String radioPresenterType = "0";
        String exit = "exit";

        System.out.println("Enter a Radio Presenter to show in file");
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

                        out.println(s);
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
                        out.println(s);
                    }
                    radioPresenterType = "exit";
                    break;

                case "0":
                    radioPresenterType = "exit";
                    break;
            }

            out.close();
        }
    }

}