package com.example.derek.assignment1;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Main Activity Class
 */
public class MainActivity extends AppCompatActivity {

    //variable to hold defined key of intent
    public static final String EXTRA_MESSAGE = "MainActivity";

    //log tag
    private static final String TAG = "MainActivity";

    //global scope components
    Button enterBtn, clearBtn;
    EditText rssInputTxt;

    /**
     * Initialise the main activity
     * @param savedInstanceState Reference to the object passed into the onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial the variables
        rssInputTxt = findViewById(R.id.txtRssAddress);
        enterBtn = findViewById(R.id.btnEnter);
        clearBtn = findViewById(R.id.btnClear);
    }//end onCrete

    /**
     * Method to create toast messages
     * @param message Sentence to be passed
     */
    void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }//end toastMessage

    /**
     * Button listener to respond to on click events
     * @param view Gets the value of button clicked by its ID
     */
    public void buttonListener(View view) {
        //check which button was clicked
        if (view.getId() == R.id.btnEnter){
            //variable to hold the rss url text
            String message = rssInputTxt.getText().toString();

            //validate the link, if the link is empty
            if (message.equals("")) {
                //display a toast message to the user
                toastMessage("Input cannot be empty");
            }//end if
            //else if the link is valid
            else if (message.contains("rss")) {
                //create an intent for the RssActivity intent
                Intent intent = new Intent(this, RSSActivity.class);
                //add the url as part of the intent
                intent.putExtra(EXTRA_MESSAGE, message);
                //start the activity
                startActivity(intent);
            }//end else if
            //else the link is not valid
            else {
                //display a toast message to the user
                toastMessage("Invalid RSS feed link");
                //clear the edit text box
                rssInputTxt.setText("");
                //focus on the edit text box
                rssInputTxt.findFocus();
            }//end if
        }//end if
        else if (view.getId() == R.id.btnClear) {
            //remove the text from the edit text
            rssInputTxt.setText("");
        }//end else if
    }//end button listener
}//end class
