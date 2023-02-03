package model.modelBroadcastCreator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BroadcastProduct {


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

}