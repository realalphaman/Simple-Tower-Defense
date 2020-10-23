package data;

import static helpers.Artist.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import UI.UI.Menu;
import helpers.StateManager;

public class Game {
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI gameUI;
	private Menu towerPickerMenu;
	private Texture menuBackground;
	private Enemy[] enemyTypes;


	public Game(TileGrid grid) {
		this.grid = grid;
		enemyTypes = new Enemy[4];
		enemyTypes[0] = new EnemyEvil(2,0,grid);
		enemyTypes[1] = new EnemyDevil(2,0,grid);
		enemyTypes[2] = new EnemyUFO(2,0,grid);
		enemyTypes[3] = new EnemyAlien(2,0,grid);
		waveManager = new WaveManager(enemyTypes,2,12+ WaveManager.getWaveNumber() * 3);
		player = new Player(grid, waveManager);
		player.setup();
		this.menuBackground = QuickLoad("menu_background");
		setupUI();
		
	}
	
	private void setupUI() {
		gameUI = new UI();
		gameUI.createMenu("TowerPicker", 1280, 100, 192, 960, 2,0);
		towerPickerMenu = gameUI.getMenu("TowerPicker");
		towerPickerMenu.quickAdd("TowerBlue", "CannonBlueFull");
		towerPickerMenu.quickAdd("TowerIce","iceCannon");
		towerPickerMenu.quickAdd("TowerKing" , "TowerKing");
		towerPickerMenu.quickAdd("TowerQueen" , "TowerQueen");
	}

	
	private void updateUI() {
		gameUI.draw();	
		gameUI.drawString(1320, 70, "20");
		gameUI.drawString(1410, 70, "30");
		gameUI.drawString(1320, 230, "55");
		gameUI.drawString(1410, 230, "40");
		gameUI.drawString(1320,600, "Health: " + Player.Lives);
		gameUI.drawString(1320, 700, "Money: " + Player.Money);
		gameUI.drawString(1320, 800, "Wave: " + waveManager.getWaveNumber());
		
		if(Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if(towerPickerMenu.isButtonClicked("TowerBlue"))
					player.pickTower(new TowerBlue(TowerType.CannonBlue, grid.GetTile(0, 0),waveManager.getCurrentWave().getEnemyList()));
				if(towerPickerMenu.isButtonClicked("TowerIce"))
					player.pickTower(new TowerIce(TowerType.CannonIce, grid.GetTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
				if(towerPickerMenu.isButtonClicked("TowerKing"))
					player.pickTower(new TowerKing(TowerType.CannonKing, grid.GetTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
				if(towerPickerMenu.isButtonClicked("TowerQueen"))
					player.pickTower(new TowerQueen(TowerType.CannonQueen, grid.GetTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
				
			}
		}
	}
	
	public void update() {
		DrawQuadTex(menuBackground,1280,0,192,960);
		grid.draw();
		waveManager.update();
		player.update();
		gameUI.draw();
		updateUI();
		
	}
}
