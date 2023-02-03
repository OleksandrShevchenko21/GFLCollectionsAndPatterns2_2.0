package model.modelBroadcastCreator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewBuilderIMpl implements BroadcastProductBuilder {

    BroadcastProduct broadcastProduct = new BroadcastProduct();

    @Override
    public BroadcastProductBuilder setBroadcastType() {
        broadcastProduct.setBroadcastType(BroadcastType.INTERVIEW);
        return this;
    }

    @Override
    public BroadcastProductBuilder setDuration() {
        System.out.println("Enter duration in minutes: ");
        broadcastProduct.setDuration(Integer.parseInt(new Scanner(System.in).nextLine()));
//        broadcastProduct.setDuration(3);
        return this;
    }


    @Override
    public BroadcastProductBuilder setSingerName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setSongName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setAdvertiseName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setInterviewGuestName() {
        System.out.println("Enter interview guest name: ");
        broadcastProduct.setInterviewGuestName(new Scanner(System.in).nextLine());
//        broadcastProduct.setAdvertiseName("INTERVIEW");
        return this;
    }

    @Override
    public BroadcastProductBuilder setPrice() {
        System.out.println("Price is : 30 euro");
        broadcastProduct.setPrice(30);
        return this;
    }

    @Override
    public BroadcastProductBuilder setCommercialType() {
        broadcastProduct.setCommercialType(CommercialType.COMMERCIAL);
        return this;
    }
@Override
public BroadcastProductBuilder setRadioPresenter() {
    System.out.println("Enter radio presenter name: ");
//    broadcastProduct.setRadioPresenterNameBroadcast("Max");
    broadcastProduct.setRadioPresenterNameBroadcast(new Scanner(System.in).nextLine());
    return this;
}

    @Override
    public BroadcastProduct build() {
        return broadcastProduct;
    }

    @Override
    public String toString() {
        return " Broadcast type" + ": " + broadcastProduct.getBroadcastType() + " \t " +
                " Duration" + ": " + broadcastProduct.getDuration() + " \t " +
                " Interview guest name" + ": " + broadcastProduct.getInterviewGuestName() + " \t " +
                " Price" + ": " + broadcastProduct.getPrice() + " \t " +
                " Commercial Type" + ": " + broadcastProduct.getCommercialType();
    }
}