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
		Turn newTurn = new Turn();
		newTurn.addThrow(20, Turn.THROW_TRIPLE);
		newTurn.addThrow(20, Turn.THROW_TRIPLE);
		newTurn.addThrow(20, Turn.THROW_TRIPLE);
	}
}
