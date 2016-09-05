package xyz.shahawi.iquotes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;
import xyz.shahawi.iquotes.models.Quote;

public class HomeFragment extends Fragment {
    private Realm realm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // Create a task
                Quote q = realm.createObject(Quote.class);
                q.setId(UUID.randomUUID().toString());
                q.setAuthor("Steve Jobs");
                q.setQuote("Your Time is limited");

            }
        });

        // Query the realm DB for the type Quote
        RealmResults<Quote> quotes = realm.where(Quote.class).findAll();
        for (Quote q : quotes) {
            Log.d("Realm", q.getAuthor());
        }

        /*
        try {
            // Create a Quote
            realm.beginTransaction();

            Quote q = realm.createObject(Quote.class);
            q.setId(UUID.randomUUID().toString());
            q.setAuthor("Dieter Rams");
            q.setQuote("Good design is as little design as possible");
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
        }*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Ensure not to leak memory
        realm.close();
    }

}
