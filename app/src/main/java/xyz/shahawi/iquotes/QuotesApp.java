package xyz.shahawi.iquotes;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Ahmed Elshahawi on 9/5/2016.
 * For updates: Shahawi.xyz
 */
public class QuotesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        byte[] encryptKey = new byte[]{9, 9, 9};

        // Configure Realm for the application
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("iq.realm")

                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
