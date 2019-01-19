package com.example.android.puremvpdemo;

public interface WelcomeContract {

    interface View {
        void showWelcomeMessage(String welcomeMessage);
    }

    interface Model {

        void setDetails(String firstName, String lastName);

        String getWelcomeMessage();
    }

    interface Presenter {
//        void setView(WelcomeContract.View view);

        void loadWelcomeMessage();

        void submitName(String firstName, String lastName);
    }

}
