package com.narxoz.rpg.artifact;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalGoldValue = 0;

    @Override
    public void visit(Weapon weapon) {
        System.out.println("Weapon '" + weapon.getName() + "' is worth " + weapon.getValue() + "G.");
        totalGoldValue += weapon.getValue();
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Potion '" + potion.getName() + "' is worth " + potion.getValue() + "G.");
        totalGoldValue += potion.getValue();
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Scroll '" + scroll.getName() + "' is worth " + scroll.getValue() + "G.");
        totalGoldValue += scroll.getValue();
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Ring '" + ring.getName() + "' is worth " + ring.getValue() + "G.");
        totalGoldValue += ring.getValue();
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Armor '" + armor.getName() + "' is worth " + armor.getValue() + "G.");
        totalGoldValue += armor.getValue();
    }

    public int getTotalGoldValue() {
        return totalGoldValue;
    }
}