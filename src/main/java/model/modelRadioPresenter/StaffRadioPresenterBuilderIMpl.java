package model.modelRadioPresenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffRadioPresenterBuilderIMpl implements RadioPresenterBuilder{

    RadioPresenter radioPresenter = new RadioPresenter();


    @Override
    public RadioPresenterBuilder setRadioPresenterName() {
        System.out.println("Enter a name of Radio Presenter: ");
        radioPresenter.setRadioPresenterName(new Scanner(System.in).nextLine());
//        radioPresenter.setRadioPresenterName("John");
        return this;

    }

    @Override
    public RadioPresenterBuilder setRadioPresenterType() {
        radioPresenter.setRadioPresenterType(RadioPresenterType.STAFF);
        return this;
    }

    @Override
    public RadioPresenterBuilder setExperience() {
        System.out.println("Enter an experience: ");
        radioPresenter.setExperience(Integer.parseInt(new Scanner(System.in).nextLine()));
//        radioPresenter.setExperience(2);
        return this;
    }

    @Override
    public RadioPresenterBuilder setResume() {
        return null;
    }

    @Override
    public RadioPresenter build() {
        return radioPresenter;
    }

}
