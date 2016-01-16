package com.dkap.rera;

import android.provider.ContactsContract;
import android.widget.Chronometer;

import java.sql.Time;
import java.util.Timer;

/**
 * Created by DK on 28/11/2015.
 */
public class Station {
    private String name;
    private Integer order;
    private Branche branche;
    private Etat etat;
    private boolean isProblem;
    private Sens sens;
    private DataBaseManager dataBaseManager;
    private Timer timer;

    private Branche ToBranche(Integer branche) {
        switch (branche) {
            case 0:
                return Branche.A;
            case 1:
                return Branche.A1;
            case 2:
                return Branche.A2;
            case 3:
                return Branche.A3;
            case 4:
                return Branche.A4;
            default:
                throw new Exception(String.format("Wrong branche number {0}", branche));
        }
    }

    public Station(DataBaseManager dataBaseManager, String name, Integer order, Integer branche, Integer etat, boolean isProblem, Integer sens) {
        this.dataBaseManager = dataBaseManager;
        this.name = name;
        this.order = order;
        this.branche = StationConverter.ConvertToBranche(branche);
        this.etat = StationConverter.ConvertToEtat(etat);
        this.isProblem = isProblem;
        this.sens = StationConverter.ConvertSens(sens);
    }
    //TODO FetchEtat

    //TODO GetNextRer

}
