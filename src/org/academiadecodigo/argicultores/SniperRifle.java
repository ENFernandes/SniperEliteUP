package org.academiadecodigo.argicultores;

public class SniperRifle {
    private int bulletDamage = (int)Math.round(Math.random()*100);

    public void shoot(Destroyable destroyable) {

        destroyable.hit(bulletDamage);

    }

}
