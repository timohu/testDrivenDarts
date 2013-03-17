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
		
		turn.throwDart(20, turn.THROW_TRIPLE);
		turn.throwDart(20, turn.THROW_TRIPLE);
		turn.throwDart(20, turn.THROW_TRIPLE);
		
		newGame.setRemainingPoints(turn.calculateRemainingPoints());		
		
		assertTrue(newGame.getRemainingPoints() == 20);
	}
	
	/*@Test
	public void winGameWithSingle() {
		Turn turn = new Turn(newGame.getRemainingPoints());
		
		newGame.setRemainingPoints(turn.throwDart(20, turn.THROW_TRIPLE));
		
		newGame.setRemainingPoints(turn.throwDart(20, turn.THROW_TRIPLE));
		
		newGame.setRemainingPoints(turn.throwDart(20, turn.THROW_TRIPLE));
		
		newGame.setRemainingPoints(turn.throwDart(20, turn.THROW_SINGLE));
		
		assertTrue(newGame.getRemainingPoints() == 20);
	}*/
	
}
