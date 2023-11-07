package utilz.constants.character_constants;

import characters.playable.enemies.Enemy;

public class EnemyConstants {
    
    public static Enemy testEnemy;

    public static void InitEnemies() {
        testEnemy = new Enemy("Test", 0, 0, 0, "Heart_56.png");
    } //InitEnemies

} //Enemy Constants
