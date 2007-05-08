package net.sf.freecol.common.model;

import java.util.Vector;

import junit.framework.TestCase;
import net.sf.freecol.common.FreeColException;
import net.sf.freecol.util.test.MockModelController;

public class GameTest extends TestCase {

	public void testGame() throws FreeColException {

		Game game = new Game(new MockModelController());
        
        game.setMap(new Map(game, Map.SMALL));

		game.addPlayer(new Player(game, "TestPlayer", false, Player.DUTCH));

		game.newTurn();

	}

	public void testAddPlayer() {
		Game game = new Game(new MockModelController());

		Vector<Player> players = new Vector<Player>();

		for (int i = Player.NUMBER_OF_NATIONS - 1; i >= 0; i--) {
			Player p = new Player(game, String.valueOf(i), false, !Player.isEuropeanNoREF(i), i);
			game.addPlayer(p);
			players.add(p);
		}

        assertEquals(Player.NUMBER_OF_NATIONS, game.getPlayers().size());
		assertEquals(players, game.getPlayers());
	}

}
