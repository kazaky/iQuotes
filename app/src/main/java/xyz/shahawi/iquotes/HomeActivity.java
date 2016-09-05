package xyz.shahawi.iquotes;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

    //    QuotesApp mApplication = (QuotesApp) getApplicationContext();

        // Begin the transaction
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.placeholer, new HomeFragment());
        // Complete the changes added above
        ft.commit();
    }
}
