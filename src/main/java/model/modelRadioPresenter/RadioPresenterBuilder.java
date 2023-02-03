package model.modelRadioPresenter;

public interface RadioPresenterBuilder {

    RadioPresenterBuilder setRadioPresenterName();
    RadioPresenterBuilder setRadioPresenterType();
    RadioPresenterBuilder setExperience();
    RadioPresenterBuilder setResume();

    RadioPresenter build();

}
