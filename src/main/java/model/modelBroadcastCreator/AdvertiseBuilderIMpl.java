package model.modelBroadcastCreator;

import lombok.*;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseBuilderIMpl implements BroadcastProductBuilder {

    AdvertiseProduct broadcastProduct = new AdvertiseProduct();

    @Override
    public BroadcastProductBuilder setBroadcastType() {
        broadcastProduct.setBroadcastType(BroadcastType.ADVERTISE);
        return this;
    }

    @Override
    public BroadcastProductBuilder setDuration() {
        System.out.println("Enter duration in minutes: ");
        broadcastProduct.setDuration(Integer.parseInt(new Scanner(System.in).nextLine()));
//        broadcastProduct.setDuration(2);
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
        System.out.println("Enter advertise name: ");
        broadcastProduct.setAdvertiseName(new Scanner(System.in).nextLine());
//        broadcastProduct.setAdvertiseName("ADVERTISE");
        return this;
    }


    @Override
    public BroadcastProductBuilder setPrice() {
        System.out.println("Price is : 5 euro");
        broadcastProduct.setPrice(5);
        return this;
    }


    @Override
    public BroadcastProductBuilder setInterviewGuestName() {
        return null;
    }

    @Override
    public BroadcastProductBuilder setCommercialType() {
        broadcastProduct.setCommercialType(CommercialType.COMMERCIAL);
        return this;
    }

@Override
public BroadcastProductBuilder setRadioPresenter() {
    System.out.println("Enter radio presenter name: ");
//    broadcastProduct.setRadioPresenterNameBroadcast("John");
    broadcastProduct.setRadioPresenterNameBroadcast(new Scanner(System.in).nextLine());
    return this;
}

    @Override
    public AdvertiseProduct build() {
        return broadcastProduct;
    }
}