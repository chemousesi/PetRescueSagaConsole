package Movible;

import java.io.Serializable;

public abstract class Case implements Serializable {
    private Element element;
    private boolean desactive;

    Case(Element element, boolean desactive) {
        this.element = element;
        this.desactive = desactive;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
