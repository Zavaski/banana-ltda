package com.banana.Bean;

import com.banana.Model.ReservaSala;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
@Named("reservaSalaBean")
@ViewScoped
public class ReservaBean implements Serializable {
    private ReservaSala reservaSala;

    public String cadastrarReserva() {
        reservaSala = new ReservaSala();
        return "";
    }



}
