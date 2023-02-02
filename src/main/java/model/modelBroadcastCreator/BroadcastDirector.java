package model.modelBroadcastCreator;

public class BroadcastDirector {
    private BroadcastProductBuilder builder;

    public BroadcastDirector(BroadcastProductBuilder builder){
        super();
        this.builder = builder;

    }

    public BroadcastProduct songCreator(){
        System.out.println("Song creating...");
        return builder
                .setBroadcastType()
                .setDuration()
                .setSongName()
                .setSingerName()
                .setCommercialType()
//                .setRadioPresenterType()
                .setRadioPresenter()
                .build();
    }
    public BroadcastProduct advertiseCreator(){
        System.out.println("Advertise creating...");
        return builder
                .setBroadcastType()
                .setDuration()
                .setAdvertiseName()
                .setPrice()
                .setCommercialType()
//                .setRadioPresenterType()
                .setRadioPresenter()
                .build();
    }
    public BroadcastProduct interviewCreator(){
        System.out.println("Interview creating...");
        return builder
                .setBroadcastType()
                .setDuration()
                .setInterviewGuestName()
                .setPrice()
                .setCommercialType()
//                .setRadioPresenterType()
                .setRadioPresenter()
                .build();
    }

}
