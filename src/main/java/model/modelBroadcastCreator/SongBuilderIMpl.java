package model.modelBroadcastCreator;

import lombok.*;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongBuilderIMpl implements BroadcastProductBuilder {

    BroadcastProduct broadcastProduct = new BroadcastProduct();

    @Override
    public BroadcastProductBuilder setBroadcastType() {
        broadcastProduct.setBroadcastType(BroadcastType.SONGS);
        return this;
    }

    @Override
    public BroadcastProductBuilder setDuration() {
        System.out.println("Enter duration in minutes: ");
        broadcastProduct.setDuration(Integer.parseInt(new Scanner(System.in).nextLine()));
//        broadcastProduct.setDuration(1);
        return this;
    }


    @Override
    public BroadcastProductBuilder setSingerName() {
        System.out.println("Enter singer: ");
        broadcastProduct.setSingerName(new Scanner(System.in).nextLine());
//        broadcastProduct.setSingerName("SINGER");
        return this;
    }

    @Override
    public BroadcastProductBuilder setSongName() {
        System.out.println("Enter song: ");
        broadcastProduct.setSongName(new Scanner(System.in).nextLine());
//        broadcastProduct.setSongName("SONG");
        return this;
    }

    @Override
    public BroadcastProductBuilder setAdvertiseName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setInterviewGuestName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setPrice() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setCommercialType() {
        broadcastProduct.setCommercialType(CommercialType.NONCOMMERCIAL);
        return this;
    }


    @Override
    public BroadcastProductBuilder setRadioPresenter() {
        System.out.println("Enter radio presenter name:  ");
//        broadcastProduct.setRadioPresenterNameBroadcast("John");
        broadcastProduct.setRadioPresenterNameBroadcast(new Scanner(System.in).nextLine());
        return this;
    }
    @Override
    public BroadcastProduct build() {
        return broadcastProduct;
    }
    @Override
    public String toString() {
        return " Broadcast type"  + ": " + broadcastProduct.getBroadcastType() + " \t " +
                " Duration"  + ": " + broadcastProduct.getDuration() + " \t " +
                " Advertise Name" + ": " + broadcastProduct.getAdvertiseName() + " \t " +
                " Price" + ": " + broadcastProduct.getPrice() + " \t " +
                " Commercial Type" + ": " + broadcastProduct.getCommercialType();

    }

}