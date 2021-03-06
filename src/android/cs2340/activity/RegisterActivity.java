package android.cs2340.activity;

import android.content.Intent;
import android.cs2340.presenters.RegisterPagePresenter;
import android.cs2340.views.RegisterPageView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.cs2340.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @author Team 42
 * @see SystemUiHider
 */
public class RegisterActivity extends AbstractActivityFactory implements RegisterPageView {

    /**
     * The Presenter used by the view.
     */
    RegisterPagePresenter presenter;
    
    /**
     * The username entered by the user.
     */
    EditText username;
    
    /**
     * The first password entered by the user.
     */
    EditText passOne;
    
    /**
     * The second password entered by the user. 
     */
    EditText passTwo;
    
    /**
     * The email entered by the user. 
     */
    EditText email;
    
    /**
     * The textbox for feedback shown to the user. 
     */
    TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPagePresenter(this);

        username = (EditText) findViewById(android.cs2340.R.id.Username_Reg);
        passOne = (EditText) findViewById(R.id.PassRegOne);
        passTwo = (EditText) findViewById(R.id.PassRegTwo);
        email = (EditText) findViewById(R.id.RegisterEmail);
        
        feedback = (TextView) findViewById(R.id.feedback_string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    /**
     * Hook for when the user clicks the register button.
     * @param view This view.
     */
    public void registerUser(View view) {
        presenter.onClickReg();
    }

    /**
     * Hook for when the user clicks the cancel button.
     * @param view This view. 
     */
    public void cancelReg(View view) {
        presenter.onClickBack();
    }

    @Override
    public void clearInfo() {
        username.setText("");
        passOne.setText("");
        passTwo.setText("");
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassOne() {
        return passOne.getText().toString();
    }

    @Override
    public String getPassTwo() {
        return passTwo.getText().toString();
    }
    
    @Override
    public String getEmail() {
        return email.getText().toString();
    }

    @Override
    public void setInfoErrorMessage(String text) {
        feedback.setText(text);
    }

    @Override
    public void goToIntro() {
        Intent intent = new Intent(RegisterActivity.this,
                FullscreenActivity.class);
        startActivity(intent);
    }

}