package Movible;

import java.io.Serializable;

public class Case implements Serializable, Cloneable {
    private Element element;
    private boolean active;

    public Case() {

    }

    public Case(Element element, boolean active) {
        this.element = element;
        this.active = active;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public boolean estVide() {
        return (element == null);
    }

    public void vider() {
        element = null;
    }

    @Override
    public String toString() {

        if (this.estVide()) {
            return ".";
        } else {
            return element.toString();
        }
    }

    public boolean isActive() {
        return active;
    }

    public boolean estUneBrique() {
        return this.getElement() instanceof Brique;
    }

    public Brique getBrique() {
        if (this.estUneBrique())
            return (Brique) this.getElement();
        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}
