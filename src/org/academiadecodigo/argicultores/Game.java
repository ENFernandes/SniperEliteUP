package org.academiadecodigo.argicultores;

public class Game {
    private GameObject[] gameObject;
    private SniperRifle sniperRifle;
    private int shotsFired = 0;

    public Game(int objects) {
        gameObject = createObjects(objects);
        sniperRifle = new SniperRifle();
    }

    public void start() {
        for (GameObject gO : gameObject) {
            if (gO instanceof Enemy) {
                Enemy enemy = (Enemy) gO;
                while (!enemy.isDead()) {
                    sniperRifle.shoot(enemy);
                    System.out.println(enemy.getMessage());
                    shotsFired++;
                }
                System.out.println(gO.getMessage() + " com " + shotsFired + " tiros");
            } else {
                System.out.println(gO.getMessage());
            }
        }
    }

    public GameObject[] createObjects(int size) {
        GameObject[] objects = new GameObject[size];
        for (int i = 0; i < objects.length; i++) {
            int rand = (int) Math.round(Math.random() * 10);
            if (rand < 3) {
                objects[i] = new Tree();
            } else if (rand > 3 && rand < 6) {
                objects[i] = new ArmouredEnemy();
            } else {
                objects[i] = new SoldierEnemy();
            }
        }
        return objects;
    }
}
