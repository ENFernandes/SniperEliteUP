package org.academiadecodigo.argicultores;

public class ArmouredEnemy extends Enemy {
    private int armour = 50;

    @Override
    public void hit(int hit) {
        if (armour <= 0) {
            super.hit(hit);
        } else {
            armour -= hit;
        }
    }

}
