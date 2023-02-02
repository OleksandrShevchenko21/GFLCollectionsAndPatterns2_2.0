package model.modelBroadcastCreator;



import java.util.List;

public interface BroadcastActions {

    public void creatingBroadcastList(int fixedStreamTime);

    public void printList(List<BroadcastProduct> streamList);

    public void printConcreteList(List<BroadcastProduct> streamList);

    public void calculateIncome();

}
