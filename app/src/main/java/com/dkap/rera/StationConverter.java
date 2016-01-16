package com.dkap.rera;

import android.widget.Chronometer;

import java.util.Timer;

/**
 * Created by DK on 18/12/2015.
 */
public final class StationConverter {
    public static Branche ConvertToBranche(Integer branche) {
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
            case 5:
                return Branche.A5;
            default:
                throw new Exception("Conversion to branche not possible");
        }
    }
        public static Etat ConvertToEtat(Integer etat){
            switch (etat){
                case 0:
                    return Etat.OK;
                case 1:
                    return Etat.Ralentissement;
                case 2:
                    return Etat.Probleme;
                default:
                    throw new Exception("Conversion to etat not possible");
            }
    }
    public static Sens ConvertSens(Integer sens){
       switch (sens){
           case 0:
               return Sens.EastToWest;
           case 1:
               return Sens.WestToEst;
           default:
               throw new Exception("Conversion to sens not possible");
       }
    }
}
