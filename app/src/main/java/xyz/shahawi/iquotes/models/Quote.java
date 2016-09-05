package xyz.shahawi.iquotes.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ahmed Elshahawi on 9/5/2016.
 * For updates: Shahawi.xyz
 */


public class Quote extends RealmObject {

    @PrimaryKey
    private String id;
    private String author;
    private String quote;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
