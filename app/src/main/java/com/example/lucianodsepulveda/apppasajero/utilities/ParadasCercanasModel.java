package com.example.lucianodsepulveda.apppasajero.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.lucianodsepulveda.apppasajero.interfaces.ParadasCercanasInterface;

public class ParadasCercanasModel implements ParadasCercanasInterface.Model {

    Context mContext;
    Activity mActivity;
    private ParadasCercanasInterface.Presenter presenter;
    public ParadasCercanasModel(ParadasCercanasInterface.Presenter presenter, Context mContext, Activity mActivity) {

        this.presenter = presenter;
        this.mContext = mContext;
        this.mActivity = mActivity;

    }

    public void obtenerPermisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.i("Permisos", "Se tienen los permisos!");
            } else {
                ActivityCompat.requestPermissions(
                        mActivity, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 1222);
            }
        }
    }

    public String obtenerRadio(String seleccionRadio) {

        String eleccionRadioParadas = "500.0"; //para inicializar con algun valor y que no haya errores

//        String seleccionRadio = itemSeleccionRadio.getSelectedItem().toString();
        //"5 cuadras","10 cuadras","20 cuadras","50 cuadras"
        if (seleccionRadio.equals("5 cuadras")) {
            eleccionRadioParadas = "500.0";
        } else if (seleccionRadio.equals("10 cuadras")) {
            eleccionRadioParadas = "1000.0";
        } else if (seleccionRadio.equals("20 cuadras")) {
            eleccionRadioParadas = "2000.0";
        } else if (seleccionRadio.equals("50 cuadras")) {
            eleccionRadioParadas = "5000.0";
        }

        return eleccionRadioParadas;
    }


}
