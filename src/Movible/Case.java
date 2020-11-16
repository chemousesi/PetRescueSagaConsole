package Movible;

import java.io.Serializable;

public class Case implements Serializable {
    private Element element;
    private boolean active;

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

    public boolean isActive() {
        return active;
    }
}
