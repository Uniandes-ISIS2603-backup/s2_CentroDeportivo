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
 * @author Leidy Romero
 */
public class DeportistaDTO implements Serializable {

    private Long id;
    public String nombre;
    public Boolean sexo;
    public String ultimaActualizacionDatos;
    public String fechaNacimiento;
    public Double altura;
    public Double presionSanguinea;
    public Double peso;
    public Double medidaPiernas;
    public Double medidaCintura;
    public Double medidaBrazos;
    public Integer ritmoCardiaco;
    public Integer cedula;
    /**      *
     * Constructor por defecto.      *
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
     * Convertir DTO a Entity      *
     *
     *
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public void setUltimaActualizacionDatos(String ultimaActualizacionDatos) {
        this.ultimaActualizacionDatos = ultimaActualizacionDatos;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setPresionSanguinea(Double presionSanguinea) {
        this.presionSanguinea = presionSanguinea;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setMedidaPiernas(Double medidaPiernas) {
        this.medidaPiernas = medidaPiernas;
    }

    public void setMedidaCintura(Double medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public void setMedidaBrazos(Double medidaBrazos) {
        this.medidaBrazos = medidaBrazos;
    }

    public void setRitmoCardiaco(Integer ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public String getUltimaActualizacionDatos() {
        return ultimaActualizacionDatos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getPresionSanguinea() {
        return presionSanguinea;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getMedidaPiernas() {
        return medidaPiernas;
    }

    public Double getMedidaCintura() {
        return medidaCintura;
    }

    public Double getMedidaBrazos() {
        return medidaBrazos;
    }

    public Integer getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public Integer getCedula() {
        return cedula;
    }

    @Override

    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }

}
