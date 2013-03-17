
public class DartGame {

	private Player player;


	public DartGame() {

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
	
	public void setRemainingPoints(int remainingPoints) {
		this.player.setRemainingPoints(remainingPoints);
	}

	public int getRemainingPoints() {
		return this.player.getRemainingPoints();
	}

}
