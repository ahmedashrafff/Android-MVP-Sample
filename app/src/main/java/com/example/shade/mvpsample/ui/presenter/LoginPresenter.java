package com.example.shade.mvpsample.ui.presenter;

import com.example.shade.mvpsample.data.model.User;
import com.example.shade.mvpsample.ui.view.MainView;

public class LoginPresenter implements LoginInterface
{

    MainView mainView;


    //Connecting Presenter to LoginScreen via MainView Interface
    public LoginPresenter(MainView mainView)
    {
        this.mainView = mainView;
    }

    //Where all the logic happens check if username & userpassword is true or not
    @Override
    public void onLogin(String userName, String userPassword)
    {
        User user=new User();

        if(user.getuserName().equals(userName) && user.getPassword().equals(userPassword))
        {
            mainView.onLoginResult("Successfully Logged In");
        }
        else
        {
            mainView.onLoginResult("Failed to Log In");
        }

    }
}
