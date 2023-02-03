package model.modelRadioPresenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadioPresenter {
    private String radioPresenterName;
    private RadioPresenterType RadioPresenterType;;

    private int experience;
    private String resume;

}
