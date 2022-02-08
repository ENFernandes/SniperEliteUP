package org.academiadecodigo.argicultores;

abstract class Enemy extends GameObject {
    private int health = 100;
    private boolean isDead = false;


    public boolean isDead() {
        return isDead;
    }

    public void hit(int hit) {
        this.health -= hit;
        if (health < 0) {
            isDead = true;
        }
    }

    @Override
    String getMessage() {
        if (!isDead) {
            return "Batata com " + health + " Vida ";
        }
        return "\nBatata == Puré";
    }
}
