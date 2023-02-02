package model.modelRadioPresenter;

public class RadioPresenterDirector {
    private RadioPresenterBuilder builder;

    public RadioPresenterDirector(RadioPresenterBuilder radioBuilder) {
        super();
        this.builder = radioBuilder;
    }

    public RadioPresenter staffCreator() {
        System.out.println("Adding STAFF radio presenter....");
        return builder
                .setRadioPresenterName()
                .setRadioPresenterType()
                .setExperience()
                .build();
    }
    public RadioPresenter invitedCreator() {
        System.out.println("Adding INVITED radio presenter....");
        return builder
                .setRadioPresenterName()
                .setRadioPresenterType()
                .setResume()
                .build();
    }
}
