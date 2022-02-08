package org.academiadecodigo.argicultores;

public class SniperRifle {
    private int bulletDamage = 40;

    public void shoot(Enemy gO) {

        gO.hit(bulletDamage);

    }

}
