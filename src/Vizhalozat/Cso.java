package Vizhalozat;

public class Cso extends Mezo{
    public Cso(Jatek jatek, Szkeleton szkeleton) {
        super(jatek, szkeleton);
    }

    @Override
    public boolean felveszik() {
        return false;
    }

    @Override
    public void befolyik() {

    }

    @Override
    public boolean pumpaLehelyez(Pumpa p) {
        return false;
    }

    @Override
    public boolean foltoz() {
        return false;
    }

    @Override
    public boolean lyukaszt() {
        return false;
    }

    @Override
    public Pumpa pumpaVasarlas() {
        return null;
    }

    @Override
    public boolean atAllit(Cso be, Cso ki) {
        return false;
    }

    @Override
    public boolean javitjak() {
        return false;
    }

    @Override
    public boolean csoLehelyezes(Cso cs) {
        return false;
    }
}
