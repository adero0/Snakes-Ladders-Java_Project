import java.util.*;

public class Plansza {
    Pole[][] plansza;
    HashMap<Integer, Integer> gracze;
    int playerCount;

    Plansza() {
        this.plansza = new Pole[10][10];
        this.playerCount = 1;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void initilizeBoard() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                for (int j = 1; j <= 10; j++) {
                    plansza[i - 1][j - 1] = new Pole(((i - 1) * 10) + j);
                }
            } else {
                for (int j = 10; j >= 1; j--) {
                    plansza[i - 1][j - 1] = new Pole((i - 1) * 10 - j + 11);
                }
            }
        }
        this.gracze = new HashMap<>();
        for (int i = 0; i < playerCount; i++) {
            gracze.put(i+1, plansza[0][0].nrNaPolu);
        }
    }

    public void randomSnakesAndLadders(int howMany) {
        Random r = new Random();
        for (int i = 0; i < howMany; i++) {
            int a = r.nextInt(10), b = r.nextInt(10);
            int distance = r.nextInt();
            while (a == 0 && b == 0) {
                a = r.nextInt(10);
                b = r.nextInt(10);
            }
            plansza[a][b].ilewKierunku = r.nextInt(101 - plansza[a][b].nrNaPolu) - plansza[a][b].nrNaPolu + 1;
        }
    }

    public void wypisz() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%-5s", plansza[i - 1][j - 1]);
            }
            System.out.println();
        }
    }

    public void wypiszWezeIDrabiny() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%-5s", plansza[i - 1][j - 1].ilewKierunku);
            }
            System.out.println();
        }
        System.out.println();
    }
    public int getPlayerCount() {
        return playerCount;
    }
}
