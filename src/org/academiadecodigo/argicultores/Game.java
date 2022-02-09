package org.academiadecodigo.argicultores;

public class Game {
    private GameObject[] gameObject;
    private SniperRifle sniperRifle;
    private int totalShots;
    private int shotsFired = 0;

    public Game(int objects) {
        gameObject = createObjects(objects);
        sniperRifle = new SniperRifle();
    }

    public void start() {
        for (GameObject gO : gameObject) {
            if (gO instanceof Tree) {
                System.out.println("Sou uma arvore nao me mates\n");
            } else {
                shotsFired = 0;
                Destroyable destroyable = ((Destroyable) gO);
                while (!destroyable.isDestroyed()) {
                    sniperRifle.shoot(destroyable);
                    if (gO instanceof Enemy) {
                        Enemy enemy = (Enemy) gO;
                        System.out.println(enemy.getMessage());
                        shotsFired++;
                    } else if (gO instanceof Barrel) {
                        Barrel barrel = (Barrel) gO;
                        System.out.println(barrel.getMessage());
                        shotsFired++;
                    }
                }
                System.out.println("Alvo destruido com " + shotsFired + " tiros\n");
                totalShots += shotsFired;
            }
        }
        System.out.printf("Foram desparados no total: " + totalShots + " tiros");
    }

    public GameObject[] createObjects(int size) {
        GameObject[] objects = new GameObject[size];
        for (int i = 0; i < objects.length; i++) {
            int rand = (int) Math.round(Math.random() * 21);
            if (rand <= 3) {
                objects[i] = new Tree();
            } else if (rand > 3 && rand <= 9) {
                objects[i] = new ArmouredEnemy();
            } else if (rand > 9 && rand < 15) {
                objects[i] = new SoldierEnemy();
            } else {
                objects[i] = new Barrel();
            }
        }
        return objects;
    }

}
