package Vizhalozat;

public class Szabotor extends Jatekos{
    public Szabotor(Mezo rajtaAll, Szkeleton szkeleton) {
        super(rajtaAll, szkeleton);
    }

    @Override
    public void lerak_pumpa() {

    }

    @Override
    Pumpa get_PumpaTart() {
        return null;
    }

    public void lyukaszt(){
        szkeleton.hivas(this, "lyukaszt");
        rajtaAll.lyukaszt();
        szkeleton.visszateres(this, "lyukaszt");
    }
}
