public class Main {
    public static void main(String[] args) {
        Plansza p1 = new Plansza();
        p1.setPlayerCount(4);
        p1.initilizeBoard();
        p1.randomSnakesAndLadders(10);
        p1.wypisz();
        p1.wypiszWezeIDrabiny();
        Manager m1 = new Manager(p1);
        while (true) {
            m1.turn();
        }
    }
}

