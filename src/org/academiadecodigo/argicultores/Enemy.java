package org.academiadecodigo.argicultores;

abstract class Enemy extends GameObject implements Destroyable{
    private int health = 100;


    public void hit(int hit) {
        this.health -= hit;

    }

    @Override
    String getMessage() {
        if (!isDestroyed()) {
            return "Batata com " + health + " Vida ";
        }
        return "";
    }

    @Override
    public boolean isDestroyed() {
        if (health <= 0) {
            return true;
        }
        return false;
    }
}
