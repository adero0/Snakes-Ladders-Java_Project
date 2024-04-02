import java.util.Random;

public class Manager {
    private final Random random = new Random(); // Reuse Random instance
    private int playerTurn = 1;
    private final Plansza plansza;

    public Manager(Plansza plansza) {
        this.plansza = plansza;
    }

    public void turn() {
        System.out.println("Player " + playerTurn + "'s turn");
        int diceRoll = rollDice();
        System.out.println("You threw a " + diceRoll);

        int newPosition = plansza.gracze.get(playerTurn) + diceRoll;
        if (newPosition > 100) {
            newPosition = 200 - newPosition;
        }

        plansza.gracze.put(playerTurn, newPosition);

        if (newPosition == 100) {
            koniec();
        }

        checkIfPlayerMoveSpecial();
        playerTurn = (playerTurn % plansza.getPlayerCount()) + 1;
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void checkIfPlayerMoveSpecial() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (plansza.plansza[i - 1][j - 1].ilewKierunku != 0 && plansza.plansza[i - 1][j - 1].nrNaPolu == plansza.gracze.get(playerTurn)) {
                    plansza.gracze.put(playerTurn, plansza.gracze.get(playerTurn) + plansza.plansza[i - 1][j - 1].ilewKierunku);
                    if (plansza.gracze.get(playerTurn) == 100) {
                        koniec();
                    }
                    System.out.println(plansza.gracze.get(playerTurn));
                }
            }
        }
    }

    public void koniec() {
        System.out.println("Wygrał gracz: " + playerTurn);
        wypiszGdzieGracze();
        System.exit(1);
    }

    public void wypiszGdzieGracze() {
        System.out.println(plansza.gracze);
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
}

//player turn manager class