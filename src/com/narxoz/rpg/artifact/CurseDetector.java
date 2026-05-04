package com.narxoz.rpg.artifact;

public class CurseDetector implements ArtifactVisitor {
    private int cursedCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getName().toLowerCase().contains("blood")) {
            System.out.println("WARNING: " + weapon.getName() + " emanates dark energy! It is cursed!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Potion potion) {
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("doom")) {
            System.out.println("WARNING: Scroll of " + scroll.getSpellName() + " is forbidden magic! It is cursed!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getValue() > 900) {
            System.out.println("WARNING: " + ring.getName() + " is too powerful. It bears a curse of greed!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Armor armor) {
    }

    public int getCursedCount() {
        return cursedCount;
    }
}