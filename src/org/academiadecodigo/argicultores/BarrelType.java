package org.academiadecodigo.argicultores;

public enum BarrelType {
    PLASTIC("Plastico"),
    WOOD("Madeira"),
    METAL("Metal");
    private int maxDamage;
    private String nome;

    BarrelType(String symbol) {
        this.nome = symbol;
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
