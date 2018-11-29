/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;
import co.edu.uniandes.csw.centrodeportivo.entities.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que modela al deportista
 * @author Leidy Romero
 */
public class DeportistaDTO implements Serializable {
    /**
     * Id del deportista
     */
    public Long id;
    /**
     * Nombre del deportista
     */
    public String nombre;
    /**
     * Sexo del deportista
     */
    public Boolean sexo;
    /**
     * Fecha ultima actualizacion de datos
     */
    public String ultimaActualizacionDatos;
    /**
     * Fecha de nacimiento del deportista
     */
    public String fechaNacimiento;
    /**
     * Altura del deportista
     */
    public Double altura;
    /**
     * Presion sanguinea del deportista
     */
    public Double presionSanguinea;
    /**
     * peso del deportista
     */
    public Double peso;
    /**
     * Medida piernas del deportista
     */
    public Double medidaPiernas;
    /**
     * Mediida cintura del deportista
     */
    public Double medidaCintura;
    /**
     * Medida de los brazos del deportista
     */
    public Double medidaBrazos;
    /**
     * Ritmo cardiaco del deportista
     */
    public Integer ritmoCardiaco;
    /**
     * cedula del deportista
     */
    public Integer cedula;
    /**
     * Constructor por defecto.
     */
    public DeportistaDTO() {
    }
    /**      *
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en      *
     * la entidad que viene de argumento.      *
     *
     * @param deportistaEntity: Es la entidad que se va a convertir a DTO      *
     */
    public DeportistaDTO(DeportistaEntity deportistaEntity) {
        
        if (deportistaEntity != null) {
            
            this.id = deportistaEntity.getId();
            this.nombre = deportistaEntity.getNombre();
            this.sexo = deportistaEntity.getSexo();
            this.ultimaActualizacionDatos = deportistaEntity.getUltimaActualizacionDatos();
            this.altura = deportistaEntity.getAltura();
            this.presionSanguinea = deportistaEntity.getPresionSanguinea();
            this.peso = deportistaEntity.getPeso();
            this.ritmoCardiaco = deportistaEntity.getRitmoCardiaco();
            this.medidaPiernas = deportistaEntity.getMedidaPiernas();
            this.medidaBrazos = deportistaEntity.getMedidaBrazos();
            this.medidaCintura = deportistaEntity.getMedidaCintura();
            this.cedula = deportistaEntity.getCedula();
            this.fechaNacimiento = deportistaEntity.getFechaNacimiento();
        }
        
    }
    /**      *
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO      *
     */
    public DeportistaEntity toEntity() {
        
        DeportistaEntity deportistaEntity = new DeportistaEntity();
        deportistaEntity.setId(this.id);
        deportistaEntity.setNombre(this.nombre);
        deportistaEntity.setSexo(this.sexo);
        deportistaEntity.setUltimaActualizacionDatos(this.ultimaActualizacionDatos);
        deportistaEntity.setAltura(this.altura);
        deportistaEntity.setPresionSanguinea(this.presionSanguinea);
        deportistaEntity.setPeso(this.peso);
        deportistaEntity.setRitmoCardiaco(this.ritmoCardiaco);
        deportistaEntity.setMedidaCintura(this.medidaCintura);
        deportistaEntity.setMedidaBrazos(this.medidaBrazos);
        deportistaEntity.setMedidaPiernas(this.medidaPiernas);
        deportistaEntity.setCedula(this.cedula);
        deportistaEntity.setFechaNacimiento(this.fechaNacimiento);
        return deportistaEntity;
        
    }
    /**
     * Cambia el id por el recibido por parametro
     * @param id nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Cambia el nombre por el recibido por parametro
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Cambia el sexo por el recibido por parametro
     * @param sexo nuevo sexo
     */
    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }
    /**
     * Cambia la fecha de la ultima actualización de datos
     * @param ultimaActualizacionDatos nueva fecha
     */
    public void setUltimaActualizacionDatos(String ultimaActualizacionDatos) {
        this.ultimaActualizacionDatos = ultimaActualizacionDatos;
    }
    /**
     * Cambia la fecha de nacimiento por la recibida por parametro
     * @param fechaNacimiento nueva feccha
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Cambia la altura por la recibida por parametro
     * @param altura nueva altura
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }
    /**
     * Cambia la presion sanguinea por la recibida por parametro
     * @param presionSanguinea nueva presion sanguinea
     */
    public void setPresionSanguinea(Double presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }
    /**
     * Cambia el peso por el recibido por parametro
     * @param peso nuevo peso
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    /**
     * Cambia la medida de las piernas
     * @param medidaPiernas nueva medida
     */
    public void setMedidaPiernas(Double medidaPiernas) {
        this.medidaPiernas = medidaPiernas;
    }
    /**
     * Cambia la medida de la cintura
     * @param medidaCintura nueva medida
     */
    public void setMedidaCintura(Double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }
    /**
     * Cambia la medida de brazos
     * @param medidaBrazos nueva medida
     */
    public void setMedidaBrazos(Double medidaBrazos) {
        this.medidaBrazos = medidaBrazos;
    }
    /**
     * Cambia el ritmo cardiaco por el recibido por parametro
     * @param ritmoCardiaco nuevo ritmo
     */
    public void setRitmoCardiaco(Integer ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }
    /**
     * Cambia la cedula por la recibida
     * @param cedula nueva cedula
     */
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    /**
     * Retorna el id
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Retorna el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * retorna el sexo del deportista
     * @return sexo
     */
    public Boolean getSexo() {
        return sexo;
    }
    /**
     * Retorna la fecha de la ultima actualizacion de datos
     * @return fecha
     */
    public String getUltimaActualizacionDatos() {
        return ultimaActualizacionDatos;
    }
    /**
     * Retorna la fecha de nacimiento del deportista
     * @return la fecha
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * Retorrna la altura del deportista
     * @return altura
     */
    public Double getAltura() {
        return altura;
    }
    /**
     * Retorna la presion sanguinea del deportista
     * @return presion sanguinea
     */
    public Double getPresionSanguinea() {
        return presionSanguinea;
    }
    /**
     * Retorna el peso del deportista
     * @return peso
     */
    public Double getPeso() {
        return peso;
    }
    /**
     *
     * @return
     */
    public Double getMedidaPiernas() {
        return medidaPiernas;
    }
    /**
     * Retorna la medida de la cintura del deportista
     * @return medida
     */
    public Double getMedidaCintura() {
        return medidaCintura;
    }
    /**
     * Retorna la medida  de los brazos del deportista
     * @return la medida
     */
    public Double getMedidaBrazos() {
        return medidaBrazos;
    }
    /**
     * Retorna el ritmo cardiaco del deportista
     * @return ritmo cardiaco
     */
    public Integer getRitmoCardiaco() {
        return ritmoCardiaco;
    }
    /**
     * Retorna la cedula del deportista
     * @return cedula
     */
    public Integer getCedula() {
        return cedula;
    }
    
    /**
     * Retorna el string del DTO
     * @return string
     */
    @Override
    public String toString() {
        
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        
    }
}