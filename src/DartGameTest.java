import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DartGameTest {
	
	public static final int INITIAL_POINTS = 200;
	
	private DartGame newGame;
	
	@Before
	public void setUp() {
		newGame = new DartGame();
		initializeDartGame();
		getRemainingPoints();
	}

	@Test
	public void initializeDartGame() {
		Player player = new Player();
		newGame.setPlayer(player);
		assertTrue(newGame.getPlayer() == player);
	}
	
	@Test
	public void getRemainingPoints() {
		newGame.setRemainingPoints(INITIAL_POINTS);
		assertTrue(INITIAL_POINTS == newGame.getRemainingPoints());
	}
	
	@Test
	public void throw180() {
		Turn turn = new Turn(newGame.getRemainingPoints());
		
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		
		newGame.setRemainingPoints(turn.getTemporaryRemainingPoints());		
		
		assertTrue(newGame.getRemainingPoints() == 20);
	}
	
	@Test
	public void winGameWithSingle() {
		Turn turn = new Turn(newGame.getRemainingPoints());
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		newGame.setRemainingPoints(turn.getTemporaryRemainingPoints());
	
		Turn turnTwo = new Turn(newGame.getRemainingPoints());
		turnTwo.throwDart(20, Turn.THROW_SINGLE);
		newGame.setRemainingPoints(turnTwo.getTemporaryRemainingPoints());
		
		assertTrue(newGame.getRemainingPoints() == 20);
	}
	
	@Test
	public void winGameWithDouble() {
		Turn turn = new Turn(newGame.getRemainingPoints());
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		turn.throwDart(20, Turn.THROW_TRIPLE);
		newGame.setRemainingPoints(turn.getTemporaryRemainingPoints());
	
		Turn turnTwo = new Turn(newGame.getRemainingPoints());
		turnTwo.throwDart(10, Turn.THROW_DOUBLE);
		newGame.setRemainingPoints(turnTwo.getTemporaryRemainingPoints());
		
		assertTrue(newGame.getRemainingPoints() == 0);
	}
	
	@Test
	public void winGameWithBullseye() {
		Turn turn = new Turn(newGame.getRemainingPoints());
		turn.throwDart(10, Turn.THROW_TRIPLE);
		turn.throwDart(10, Turn.THROW_DOUBLE);
		turn.throwDart(10, Turn.THROW_SINGLE);
		newGame.setRemainingPoints(turn.getTemporaryRemainingPoints());

		Turn turnTwo = new Turn(newGame.getRemainingPoints());
		turnTwo.throwDart(20, Turn.THROW_TRIPLE);
		turnTwo.throwDart(20, Turn.THROW_SINGLE);
		turnTwo.throwDart(10, Turn.THROW_SINGLE);
		newGame.setRemainingPoints(turnTwo.getTemporaryRemainingPoints());

		Turn turnThree = new Turn(newGame.getRemainingPoints());
		turnThree.throwDart(50, Turn.THROW_SINGLE);
		newGame.setRemainingPoints(turnThree.getTemporaryRemainingPoints());

		assertTrue(newGame.getRemainingPoints() == 0);
	}
	
}
