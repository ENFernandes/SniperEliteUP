package org.academiadecodigo.argicultores;

public enum BarrelType {
    PLASTIC("Plastico",30),
    WOOD("Madeira",50),
    METAL("Metal",100);
    private int maxDamage;
    private String nome;

    BarrelType(String symbol,int maxDamage) {
        this.nome = symbol;
        this.maxDamage=maxDamage;
    }
    public String getNome() {
        return nome;
    }

    public int getMaxDamage() {
        return maxDamage;
    }
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}
