package org.academiadecodigo.argicultores;

public class Barrel extends GameObject implements Destroyable{
    private BarrelType barrelType;
    private int currentDamage;


    public Barrel()
    {
        int random = (int)(Math.random()*BarrelType.values().length);
        barrelType = BarrelType.values()[random];
        currentDamage= barrelType.getMaxDamage();
    }

    @Override
    String getMessage() {
            return "O Barril de "+ barrelType.getNome() +" tem " + currentDamage + " de live";
    }
    @Override
    public void hit(int hit) {
        currentDamage-=hit;

    }
    @Override
    public boolean isDestroyed() {
        if (currentDamage <= 0) {
            return true;
        }return false;
    }
}
