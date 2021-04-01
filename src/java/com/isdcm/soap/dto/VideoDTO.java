package com.isdcm.soap.dto;

import com.isdcm.soap.adapter.LocalDateAdapter;
import com.isdcm.soap.adapter.LocalTimeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "video")
public class VideoDTO {
    @XmlTransient
    private int id;
    @XmlElement
    private String titulo;
    @XmlElement
    private String autor;
    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaCreacion;
    @XmlElement
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private LocalTime duracion;
    @XmlElement
    private int reproducciones;
    @XmlElement
    private String descripcion;
    @XmlElement
    private String formato;
    
    public VideoDTO() {
    }
    
    public VideoDTO(int id, String ti, String au, LocalDate fe, LocalTime du, int re, String de, String fo){
        this.id = id;
        this.titulo = ti;
        this.autor = au;
        this.fechaCreacion = fe;
        this.duracion = du;
        this.reproducciones = re;
        this.descripcion = de;
        this.formato = fo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
