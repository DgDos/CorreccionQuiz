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
public class contextoNavegacion {
    private int ID;
    private String link;
    private int ID_Modelo;

    public contextoNavegacion() {
    }

    public contextoNavegacion(int ID, String link, int ID_Modelo) {
        this.ID = ID;
        this.link = link;
        this.ID_Modelo = ID_Modelo;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getID_Modelo() {
        return ID_Modelo;
    }

    public void setID_Modelo(int ID_Modelo) {
        this.ID_Modelo = ID_Modelo;
    }
    
    
    
}
