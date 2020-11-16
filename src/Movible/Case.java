package Movible;

public abstract class Case {
    private Element element;
    private boolean desactive;

    Case(Element element, boolean desactive) {
        this.element = element;
        this.desactive = desactive;
    }
}
