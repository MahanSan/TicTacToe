public class Player {
    private char playerValue;
    private static int playerCount = 0;
    private String name;
    private int movesCount;

    Player(String playerName, char playerValue){
        if (playerName == null || playerName.isEmpty()){
            playerName = "Player" + ++playerCount;
        }
        setName(playerName);
        setPlayerValue(playerValue);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public char getPlayerValue() {
        return playerValue;
    }

    private void setPlayerValue(char playerValue) {
        this.playerValue = playerValue;
    }

    public void incrementMovesCount(){
        this.movesCount++;
    }
    public int getMovesCount(){
        return this.movesCount;
    }

}
