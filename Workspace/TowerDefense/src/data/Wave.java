package data;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import static helpers.Artist.*;
import static helpers.Clock.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy[] enemyTypes;
	private CopyOnWriteArrayList<Enemy> enemyList;
	private int enemiesPerWave, enemiesSpawned;
	private boolean waveCompleted;

	public Wave(Enemy[] enemyTypes, float spawnTime, int enemiesPerWave) {
		this.enemyTypes = enemyTypes;
		this.spawnTime = spawnTime;
		this.enemiesPerWave=enemiesPerWave;
		this.enemiesSpawned=0;
		this.timeSinceLastSpawn=0;
		enemyList = new CopyOnWriteArrayList<Enemy>();
		this.waveCompleted=false;
		
		spawn();

	}

	public void update() {
		//gia su toan bo enemy da chet, cho den khi vong lap ket thuc
		boolean allEnemiesDead= true;
		if (enemiesSpawned <enemiesPerWave) {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			spawn();
			timeSinceLastSpawn = 0;
			}
		}
		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				allEnemiesDead=false;
				e.update();
				e.draw();
			} else
				enemyList.remove(e);
		}
		if(allEnemiesDead) {
			waveCompleted = true;
		}
	}

	private void spawn() {
		int enemyChosen = 0;
		if(WaveManager.getWaveNumber() <=2)
			enemyChosen = enemiesSpawned % 3;
		else if (WaveManager.getWaveNumber() <= 5){
			Random random = new Random();
			enemyChosen = random.nextInt(4);
		}
		else
			enemyChosen = 3;
			enemyList.add(new Enemy(enemyTypes[enemyChosen].getTexture(), enemyTypes[enemyChosen].getStartTile(), enemyTypes[enemyChosen].getTileGrid(), TILE_SIZE, TILE_SIZE,
			enemyTypes[enemyChosen].getSpeed(),enemyTypes[enemyChosen].getHealth()));
			enemiesSpawned++;
	}
	
	public boolean isCompleted() {
		return waveCompleted;
	}
	public CopyOnWriteArrayList<Enemy> getEnemyList(){
		return enemyList;
	}
}
