package Formas;

import javax.swing.JOptionPane;

public class Circulo {
    private double raio;
    private double area;
    private double perimetro;
    
    public Circulo() {
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
    public void calcularArea() {
        double a = this.getRaio() * this.getRaio() * Math.PI;
        this.setArea(a);
        JOptionPane.showMessageDialog(null, "O valor do perímetro desse circulo e: " + a);
    }

    public void calcularPerimetro() {
        double p = this.getRaio() * 2 * Math.PI;
        this.setPerimetro(p);
        JOptionPane.showMessageDialog(null, "O valor do perímetro desse circulo e: " + p);
    }
}
