package model.modelBroadcastCreator;


public interface BroadcastProductBuilder {


    BroadcastProductBuilder setBroadcastType();
    BroadcastProductBuilder setDuration();
    BroadcastProductBuilder setSingerName();
    BroadcastProductBuilder setSongName();
    BroadcastProductBuilder setAdvertiseName();
    BroadcastProductBuilder setInterviewGuestName();
    BroadcastProductBuilder setPrice();
    BroadcastProductBuilder setCommercialType();
//    BroadcastProductBuilder setRadioPresenterType();
    BroadcastProductBuilder setRadioPresenter();


    BroadcastProduct build();


}

