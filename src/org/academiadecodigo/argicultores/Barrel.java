package org.academiadecodigo.argicultores;

public class Barrel extends GameObject implements Destroyable{
    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroy=false;


    public Barrel()
    {
        int random = (int)(Math.random()*BarrelType.values().length);
        barrelType = BarrelType.values()[random];

        switch (barrelType)
        {
            case WOOD:
                currentDamage=50;
                break;
            case METAL:
                currentDamage=100;
                break;
            case PLASTIC:
                currentDamage=30;
                break;
        }
    }

    public boolean isDestroy() {
        return destroy;
    }


    @Override
    String getMessage() {
        if(currentDamage>0) {
            return "\nO Barril de "+ barrelType.getNome() +" ainda tem " + currentDamage + " de live";
        }
        return "";
    }

    @Override
    public void hit(int hit) {
        currentDamage-=hit;
        if (currentDamage < 0) {
            destroy = true;
        }
    }
    @Override
    public boolean isDestroyed() {
        return true;
    }
}
