/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Francisco Jose MacAllister
 */
@Entity
public class RutinaEntity extends BaseEntity implements Serializable {
     private int identificadorRutina;
    private String nombre;
    private boolean estadoTerminado;

    public int getIdentificadorRutina() {
        return identificadorRutina;
    }

    public void setIdentificadorRutina(int identificadorRutina) {
        this.identificadorRutina = identificadorRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstadoTerminado() {
        return estadoTerminado;
    }

    public void setEstadoTerminado(boolean estadoTerminado) {
        this.estadoTerminado = estadoTerminado;
    }
}
