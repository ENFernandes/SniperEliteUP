package org.academiadecodigo.argicultores;

public class SniperRifle {
    private int bulletDamage = 0;

    public void shoot(Destroyable destroyable) {
        bulletDamage = (int)Math.round(Math.random()*100);
        destroyable.hit(bulletDamage);

    }

}
