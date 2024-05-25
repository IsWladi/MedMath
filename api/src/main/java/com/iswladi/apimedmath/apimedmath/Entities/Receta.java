package com.iswladi.apimedmath.apimedmath.Entities;

/**
 * Receta
 */
public class Receta {

    private int porCuantosDias;
    private int cadaCuantoHoras;

    public Receta(int cadaCuantoHoras, int porCuantosDias) {
        this.cadaCuantoHoras = cadaCuantoHoras;
        this.porCuantosDias = porCuantosDias;
    }

	public int getCadaCuantoHoras() {
		return cadaCuantoHoras;
	}
	public void setCadaCuantoHoras(int cadaCuantoHoras) {
		this.cadaCuantoHoras = cadaCuantoHoras;
	}
	public int getPorCuantosDias() {
		return porCuantosDias;
	}
	public void setPorCuantosDias(int porCuantosDias) {
		this.porCuantosDias = porCuantosDias;
	}

}
