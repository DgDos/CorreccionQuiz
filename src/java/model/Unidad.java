/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LabingXEON
 */
public class Unidad {
    private int ID;
    private int ID_C;
    private int ID_t;

    public Unidad() {
    }

    public Unidad(int ID, int ID_C, int ID_t) {
        this.ID = ID;
        this.ID_C = ID_C;
        this.ID_t = ID_t;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_C() {
        return ID_C;
    }

    public void setID_C(int ID_C) {
        this.ID_C = ID_C;
    }

    public int getID_t() {
        return ID_t;
    }

    public void setID_t(int ID_t) {
        this.ID_t = ID_t;
    }
    
    
    
}
