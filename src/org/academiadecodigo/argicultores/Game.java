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
            if (gO instanceof Enemy || gO instanceof Barrel ) {
                Destroyable destroyable = ((Destroyable) gO);
                Enemy enemy = (Enemy) gO;
                while (!enemy.isDead() || !destroyable.isDestroyed()) {
                    sniperRifle.shoot(destroyable);
                    if(gO instanceof Enemy)
                    System.out.println(enemy.getMessage());
                    else
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
            int rand = (int) Math.round(Math.random() * 15);
            if (rand < 3) {
                objects[i] = new Tree();
            } else if (rand > 3 && rand < 6) {
                objects[i] = new ArmouredEnemy();
            } else if (rand > 6 && rand < 11) {
                objects[i] = new SoldierEnemy();
            } else {
                objects[i] = new Barrel();
            }
        }
        return objects;
    }
}
