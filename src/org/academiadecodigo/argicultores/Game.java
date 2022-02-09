package org.academiadecodigo.argicultores;

public class Game {
    private GameObject[] gameObject;
    private SniperRifle sniperRifle;
    private int totalShots ;
    private int shotsFired = 0;

    public Game(int objects) {
        gameObject = createObjects(objects);
        sniperRifle = new SniperRifle();
    }

    public void start() {
        for (GameObject gO : gameObject) {
            shotsFired=0;
            if(!(gO instanceof Tree)) {
                Destroyable destroyable = ((Destroyable) gO);
                if (gO instanceof Enemy) {
                    Enemy enemy = (Enemy) gO;
                    verifyE(enemy,destroyable);
                    System.out.println("Batata virou puré com " + shotsFired + " tiros\n");
                } else if(gO instanceof Barrel) {
                    Barrel barrel = (Barrel) gO;
                    verifyB(barrel,destroyable);
                    System.out.println("Barril foi-se com " + shotsFired + " tiros\n");
                }
            }
            else {
                System.out.println(gO.getMessage());
            }totalShots+=shotsFired;
        }
        System.out.printf("Foram desparados: "+totalShots+" tiros");
    }


    public void verifyE(Enemy enemy,Destroyable destroyable){
        while (!enemy.isDead()) {
            sniperRifle.shoot(destroyable);
                System.out.println(enemy.getMessage());
                shotsFired++;
        }
    }

    public void verifyB(Barrel barrel,Destroyable destroyable){
        while (!barrel.isDestroy()) {
            sniperRifle.shoot(destroyable);
            System.out.println(barrel.getMessage());
            shotsFired++;
        }
    }

    public GameObject[] createObjects(int size) {
        GameObject[] objects = new GameObject[size];
        for (int i = 0; i < objects.length; i++) {
            int rand = (int) Math.round(Math.random() * 15);
            if (rand <= 3) {
                objects[i] = new Tree();
            } else if (rand > 3 && rand <= 6) {
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
