package com.esliceu.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Meteorit {
    private String nom;
    private String nomCientific;
    private Double velocitat;
    private Double velocitatMinima;
    private Double velocitatMaxima;
    private Boolean esPerillos;
    private int indexPerillositat;
    private Double distancia;
    private Double distanciaMinima;
    private Double distanciaMaxima;
    private Double diametre;
    private Double altura;
    private Double amplada;
    private Double profunditat;
    private String[] composicio;
    private Double radi;
    private Double orbita;
    private String[] planetesPropers;
    private Date primeraVisualitzacio;
    private Date diaMesProximALaTerra;

    public Meteorit(String nom, Double velocitat, Boolean esPerillos, Double distancia, Double diametre) {
        this.nom = nom;
        this.velocitat = velocitat;
        this.esPerillos = esPerillos;
        this.distancia = distancia;
        this.diametre = diametre;
    }

    public Meteorit(String nom, String nomCientific, Double velocitat, Double velocitatMinima, Double velocitatMaxima,
                    Boolean esPerillos, int indexPerillositat, Double distancia, Double distanciaMinima,
                    Double distanciaMaxima, Double diametre, Double altura, Double amplada, Double profunditat,
                    String[] composicio, Double radi, Double orbita, String[] planetesPropers, Date primeraVisualitzacio,
                    Date diaMesProximALaTerra) {
        this.nom = nom;
        this.nomCientific = nomCientific;
        this.velocitat = velocitat;
        this.velocitatMinima = velocitatMinima;
        this.velocitatMaxima = velocitatMaxima;
        this.esPerillos = esPerillos;
        this.indexPerillositat = indexPerillositat;
        this.distancia = distancia;
        this.distanciaMinima = distanciaMinima;
        this.distanciaMaxima = distanciaMaxima;
        this.diametre = diametre;
        this.altura = altura;
        this.amplada = amplada;
        this.profunditat = profunditat;
        this.composicio = composicio;
        this.radi = radi;
        this.orbita = orbita;
        this.planetesPropers = planetesPropers;
        this.primeraVisualitzacio = primeraVisualitzacio;
        this.diaMesProximALaTerra = diaMesProximALaTerra;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomCientific() {
        return nomCientific;
    }

    public void setNomCientific(String nomCientific) {
        this.nomCientific = nomCientific;
    }

    public Double getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(Double velocitat) {
        this.velocitat = velocitat;
    }

    public Double getVelocitatMinima() {
        return velocitatMinima;
    }

    public void setVelocitatMinima(Double velocitatMinima) {
        this.velocitatMinima = velocitatMinima;
    }

    public Double getVelocitatMaxima() {
        return velocitatMaxima;
    }

    public void setVelocitatMaxima(Double velocitatMaxima) {
        this.velocitatMaxima = velocitatMaxima;
    }

    public Boolean getEsPerillos() {
        return esPerillos;
    }

    public void setEsPerillos(Boolean esPerillos) {
        this.esPerillos = esPerillos;
    }

    public int getIndexPerillositat() {
        return indexPerillositat;
    }

    public void setIndexPerillositat(int indexPerillositat) {
        this.indexPerillositat = indexPerillositat;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getDistanciaMinima() {
        return distanciaMinima;
    }

    public void setDistanciaMinima(Double distanciaMinima) {
        this.distanciaMinima = distanciaMinima;
    }

    public Double getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(Double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public Double getDiametre() {
        return diametre;
    }

    public void setDiametre(Double diametre) {
        this.diametre = diametre;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAmplada() {
        return amplada;
    }

    public void setAmplada(Double amplada) {
        this.amplada = amplada;
    }

    public Double getProfunditat() {
        return profunditat;
    }

    public void setProfunditat(Double profunditat) {
        this.profunditat = profunditat;
    }

    public String[] getComposicio() {
        return composicio;
    }

    public void setComposicio(String[] composicio) {
        this.composicio = composicio;
    }

    public Double getRadi() {
        return radi;
    }

    public void setRadi(Double radi) {
        this.radi = radi;
    }

    public Double getOrbita() {
        return orbita;
    }

    public void setOrbita(Double orbita) {
        this.orbita = orbita;
    }

    public String[] getPlanetesPropers() {
        return planetesPropers;
    }

    public void setPlanetesPropers(String[] planetesPropers) {
        this.planetesPropers = planetesPropers;
    }

    public Date getPrimeraVisualitzacio() {
        return primeraVisualitzacio;
    }

    public void setPrimeraVisualitzacio(Date primeraVisualitzacio) {
        this.primeraVisualitzacio = primeraVisualitzacio;
    }

    public Date getDiaMesProximALaTerra() {
        return diaMesProximALaTerra;
    }

    public void setDiaMesProximALaTerra(Date diaMesProximALaTerra) {
        this.diaMesProximALaTerra = diaMesProximALaTerra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meteorit meteorit = (Meteorit) o;
        return indexPerillositat == meteorit.indexPerillositat && Objects.equals(nom, meteorit.nom) && Objects.equals(nomCientific, meteorit.nomCientific) && Objects.equals(velocitat, meteorit.velocitat) && Objects.equals(velocitatMinima, meteorit.velocitatMinima) && Objects.equals(velocitatMaxima, meteorit.velocitatMaxima) && Objects.equals(esPerillos, meteorit.esPerillos) && Objects.equals(distancia, meteorit.distancia) && Objects.equals(distanciaMinima, meteorit.distanciaMinima) && Objects.equals(distanciaMaxima, meteorit.distanciaMaxima) && Objects.equals(diametre, meteorit.diametre) && Objects.equals(altura, meteorit.altura) && Objects.equals(amplada, meteorit.amplada) && Objects.equals(profunditat, meteorit.profunditat) && Arrays.equals(composicio, meteorit.composicio) && Objects.equals(radi, meteorit.radi) && Objects.equals(orbita, meteorit.orbita) && Arrays.equals(planetesPropers, meteorit.planetesPropers) && Objects.equals(primeraVisualitzacio, meteorit.primeraVisualitzacio) && Objects.equals(diaMesProximALaTerra, meteorit.diaMesProximALaTerra);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nom, nomCientific, velocitat, velocitatMinima, velocitatMaxima, esPerillos, indexPerillositat, distancia, distanciaMinima, distanciaMaxima, diametre, altura, amplada, profunditat, radi, orbita, primeraVisualitzacio, diaMesProximALaTerra);
        result = 31 * result + Arrays.hashCode(composicio);
        result = 31 * result + Arrays.hashCode(planetesPropers);
        return result;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "nom='" + nom + '\'' +
                ", velocitat=" + velocitat +
                ", esPerillos=" + esPerillos +
                ", distancia=" + distancia +
                ", diametre=" + diametre +
                '}';
    }
}
