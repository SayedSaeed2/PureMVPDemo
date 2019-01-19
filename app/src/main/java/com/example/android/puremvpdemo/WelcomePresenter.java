package com.example.android.puremvpdemo;

public class WelcomePresenter implements WelcomeContract.Presenter {

    private WelcomeContract.View view;
    private WelcomeContract.Model model;


    public WelcomePresenter(WelcomeContract.View view) {
        this.view = view;
        model = new UserDataManager();
    }

    @Override
    public void loadWelcomeMessage() {

        view.showWelcomeMessage(model.getWelcomeMessage());
    }

    @Override
    public void submitName(String firstName, String lastName) {
        model.setDetails(firstName, lastName);
    }
}
