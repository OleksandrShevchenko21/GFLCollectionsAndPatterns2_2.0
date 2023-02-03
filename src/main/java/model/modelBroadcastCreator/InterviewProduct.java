package model.modelBroadcastCreator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewProduct extends BroadcastProduct {
    private BroadcastType broadcastType;
    private int duration;
    private String singerName;
    private String songName;
    private String advertiseName;
    private int price;
    private String interviewGuestName;
    private CommercialType commercialType;
    //    private RadioPresenterType RadioPresenterType;;
    private String radioPresenterNameBroadcast;

    @Override
    public String toString() {
        return " Broadcast type"  + ": " + broadcastType+ " \t " +
                " Duration"  + ": " + duration + " \t " +
                " Interview guest name" + ": " + interviewGuestName + " \t " +
                " Price" + ": " + price + " \t " +
                " Commercial Type" + ": " + commercialType;

    }
}
