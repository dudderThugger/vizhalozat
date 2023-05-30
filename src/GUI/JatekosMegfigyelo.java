package GUI;

public abstract class JatekosMegfigyelo extends Megfigyelo{
    Vizhalozat.Jatekos observed;

    public JatekosMegfigyelo(JatekPanel panel, Vizhalozat.Jatekos observed) {
        super(panel);
        this.observed = observed;
    }

    public void lep() {
        coordinate = panel.getObservedCoordinate(observed.getRajtaAll());
    }

    @Override
    public Object getObserved() { return observed; }
}
