package com.Datos1.Proyecto1.cover;

import java.io.IOException;

public class Cover {

    CoverWindow coverWindow;

    public Cover() throws IOException {

       this.coverWindow  = new CoverWindow();


    }

    public void createWindow(){

            coverWindow.setVisible(true);
    }

    public CoverWindow getWindow(){
        return coverWindow;
    }

}
