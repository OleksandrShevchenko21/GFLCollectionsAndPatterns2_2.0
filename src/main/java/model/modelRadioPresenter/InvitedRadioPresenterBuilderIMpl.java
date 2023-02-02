package model.modelRadioPresenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitedRadioPresenterBuilderIMpl implements RadioPresenterBuilder {


    RadioPresenter radioPresenter = new RadioPresenter();


    @Override
    public RadioPresenterBuilder setRadioPresenterName() {
        System.out.println("Enter a name of Radio Presenter: ");
        radioPresenter.setRadioPresenterName(new Scanner(System.in).nextLine());
//        radioPresenter.setRadioPresenterName("Max");
        return this;

    }

    @Override
    public RadioPresenterBuilder setRadioPresenterType() {
        radioPresenter.setRadioPresenterType(RadioPresenterType.INVITED);
        return this;
    }

    @Override
    public RadioPresenterBuilder setExperience() {
        return null;
    }

    @Override
    public RadioPresenterBuilder setResume() {
        System.out.println("Enter a resume ");
//        radioPresenter.setRadioPresenterName(new Scanner(System.in).nextLine());
        radioPresenter.setResume("a good job for invited person ");
        return this;
    }

    @Override
    public RadioPresenter build() {
        return radioPresenter;
    }

}

