package com.example.shade.mvpsample.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shade.mvpsample.ui.presenter.LoginInterface;
import com.example.shade.mvpsample.ui.presenter.LoginPresenter;
import com.example.shade.mvpsample.R;

public class LoginScreen extends AppCompatActivity implements MainView{

    EditText usernameEditText;
    EditText userPasswordEditText;
    Button loginButton;
    LoginInterface loginpresenter;
    String userName;
    String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        //Connecting LoginPresenter (Presenter) to LoginScreen (View)
        loginpresenter=new LoginPresenter(this);

        //Initializing Views
        usernameEditText=(EditText) findViewById(R.id.username);
        userPasswordEditText=(EditText) findViewById(R.id.password);
        loginButton=(Button) findViewById(R.id.loginbutton);

        //Listening for button click
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Get username & userpassword from edittext
                userName = usernameEditText.getText().toString();
                userPassword = userPasswordEditText.getText().toString();

                //Check that username & userpassword not empty
                if(!userName.equals("") && !userPassword.equals(""))
                {
                    //Calling the presenter to validate username & userpassword
                    loginpresenter.onLogin(userName,userPassword);
                }
            }
        });


    }

    //Receiving the login result from the Presenter & then update the View with it
    @Override
    public void onLoginResult(String result)
    {
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();

    }
}
