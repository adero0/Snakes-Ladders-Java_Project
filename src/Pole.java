public class Pole {
    int ilewKierunku;
    int nrNaPolu;
    public Pole(int nrNaPolu,int ilewKierunku) {
        this.ilewKierunku = ilewKierunku;
        this.nrNaPolu = nrNaPolu;
    }
    public Pole(int nrNaPolu) {
        this.ilewKierunku = 0;
        this.nrNaPolu = nrNaPolu;
    }


    @Override
    public String toString() {
        char kropka = 32;
        if(ilewKierunku>0){
            kropka = 157;
        }
        return nrNaPolu + "" +  kropka;
    }
}
