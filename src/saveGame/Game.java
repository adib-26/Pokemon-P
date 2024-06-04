import java.io.*;

public class Game {
	// GameState class to hold game data
	static class GameState implements Serializable {
		private int coordinateX;
		private int coordinateY;
		private int score;
		private String[] powersCurrentlyTheUserHas;
		// Add other relevant data as needed
	}

	// Save the game state to a file
	public void saveGame(GameState gameState) {
		try (FileOutputStream fileOut = new FileOutputStream("gamestate.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(gameState);
			System.out.println("Game state saved successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Load the game state from a file
	public GameState loadGame() {
		try (FileInputStream fileIn = new FileInputStream("gamestate.ser");
			 ObjectInputStream in = new ObjectInputStream(fileIn)) {
			return (GameState) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

    public void exampleUsage() {
		Game game = new Game();
		GameState initialGameState = new GameState();
		initialGameState.coordinateX = 10;
		initialGameState.coordinateY = 20;
		initialGameState.score = 100;
		//initialGameState.powersCurrentlyTheUserHas = new String[]{"Double Jump", "Invisibility"};

		// Save the initial game state
		game.saveGame(initialGameState);

		// Load the saved game state
		GameState loadedGameState = game.loadGame();
		if (loadedGameState != null) {
			System.out.println("Loaded game state:");
			System.out.println("X: " + loadedGameState.coordinateX);
			System.out.println("Y: " + loadedGameState.coordinateY);
			System.out.println("Score: " + loadedGameState.score);
			//System.out.println("Powers: " + String.join(", ", loadedGameState.powersCurrentlyTheUserHas));
		}
    }
}
