package model.modelRadioPresenter;

import model.modelBroadcastCreator.BroadcastProduct;

import java.util.List;
import java.util.Map;

public interface RadioPresenterActions {

    public void printPresentersList(List<BroadcastProduct> streamList);
    public List <RadioPresenter> savePresentersList(List<BroadcastProduct> streamList);
    public Map<RadioPresenter, List<BroadcastProduct>> hashMapCreating(List<RadioPresenter> presenterList, List<BroadcastProduct> streamList);


}
