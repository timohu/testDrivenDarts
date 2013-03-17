public class Turn {

	public static final int THROW_SINGLE = 1;
	public static final int THROW_DOUBLE = 2;
	public static final int THROW_TRIPLE = 3;

	private boolean turnDone;

	private int points;
	private int multiplier;
	private int totalPoints;

	private int originalRemainingPoints;
	private int temporaryRemainingPoints;

	public Turn(int remainingPoints) {
		this.originalRemainingPoints = remainingPoints;
		this.temporaryRemainingPoints = remainingPoints;
	}

	public void throwDart(int points, int multiplier) {
		setTotalPoints(points, multiplier);
		processThrow();
	}

	public void setTotalPoints(int points, int multiplier) {
		if ((points > 0 && points < 21) || 
				points == 25 ||
				points == 50
				) {
			this.points = points;
		}

		if (multiplier == THROW_SINGLE  ||
				multiplier == THROW_DOUBLE || 
				multiplier == THROW_TRIPLE) {
			this.multiplier = multiplier;
		}

		totalPoints = (this.points * this.multiplier);
	}

	public void processThrow() {
		if (!turnDone) {
			if (isGameWin()) {
				turnDone = true;
				temporaryRemainingPoints = 0;
			} else if (isTurnFailed()) {
				turnDone = true;
				temporaryRemainingPoints = originalRemainingPoints;
			} else if (isSuccessfulThrow()) {
				temporaryRemainingPoints -= totalPoints;
			}
		}
	}

	public boolean isTurnFailed() {
		if (temporaryRemainingPoints < totalPoints) {
			return true;
		} else if ((temporaryRemainingPoints - totalPoints) == 1) {
			return true;
		} else if ((temporaryRemainingPoints - totalPoints) == 0 && 
				this.multiplier == THROW_SINGLE) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGameWin() {
		int scoreAfterThrow = temporaryRemainingPoints - totalPoints;
		
		System.out.println(points);
		
		if (scoreAfterThrow != 0) {
			return false;
		} else if (points == 25) {
			return true;
		} else if (points == 50) {
			return true;
		} else if (this.multiplier != THROW_SINGLE) {
			return true;
		}

		return false;
	}

	public boolean isSuccessfulThrow() {
		if (temporaryRemainingPoints > totalPoints) {
			return true;
		} else {
			return false;
		}
	}

	public int getTemporaryRemainingPoints() {
		return temporaryRemainingPoints;
	}

}