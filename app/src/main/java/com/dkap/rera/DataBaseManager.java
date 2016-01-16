package com.dkap.rera;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DK on 09/01/2016.
 */
public class DataBaseManager extends SQLiteOpenHelper {
    private static final String createStationQuery = "CREATE TABLE Station (\n" +
            "  Name TEXT NOT NULL PRIMARY KEY,\n" +
            "  Ordre INTEGER NOT NULL,\n" +
            "  Branche INTEGER NOT NULL,\n" +
            "  Sens INTEGER NOT NULL,\n" +
            "  Problem BOOLEAN NOT NULL);";
    private static final String createParcoursQuery = "CREATE TABLE Parcours(\n" +
            "  StationDepart TEXT NOT NULL,\n" +
            "  StationArrivee TEXT NOT NULL,\n" +
            "  UserId INTEGER NOT NULL,\n" +
            "  Name TEXT NOT NULL,\n" +
            "  FOREIGN KEY(StationDepart) REFERENCES Station(Name),\n" +
            "  FOREIGN KEY(StationArrivee) REFERENCES Station(Name),\n" +
            "  FOREIGN KEY(UserId) REFERENCES User(Id),  \n" +
            "  PRIMARY KEY (UserId, Name)\n" +
            "  );";
    private static final String createUserQuery = "  CREATE TABLE User(\n" +
            "  Id INTEGER NOT NULL PRIMARY KEY,\n" +
            "  Pseudo TEXT NOT NULL,\n" +
            "  Mdp TEXT NOT NULL\n" +
            "  );";
    private static final String dropStationQuery = "DROP TABLE IF EXISTS Station;";
    private static final String dropParcoursQuery = "DROP TABLE IF EXISTS Parcours;";
    private static final String dropUserQuery = "DROP TABLE IF EXISTS User;";
    private SQLiteDatabase database;

    public DataBaseManager(Context context){
        super(context,"database.db",null,1);
    }

    public void open(){
        database = this.getWritableDatabase();
    }
    public void close(){
        database.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createStationQuery);
        db.execSQL(createParcoursQuery);
        db.execSQL(createUserQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropStationQuery);
        db.execSQL(dropParcoursQuery);
        db.execSQL(dropUserQuery);
        onCreate(db);
    }
}
