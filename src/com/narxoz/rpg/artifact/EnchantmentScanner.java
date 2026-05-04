package com.narxoz.rpg.artifact;

public class EnchantmentScanner implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.println("Scanning " + weapon.getName() + "... Mundane aura. Grants +" + weapon.getAttackBonus() + " attack.");
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("Scanning " + potion.getName() + "... Alchemical aura. Heals for " + potion.getHealing() + ".");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("Scanning " + scroll.getName() + "... Strong magical aura! Contains spell: " + scroll.getSpellName() + ".");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("Scanning " + ring.getName() + "... Enchanted aura! Grants +" + ring.getMagicBonus() + " magic bonus.");
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("Scanning " + armor.getName() + "... Mundane aura. Grants +" + armor.getDefenseBonus() + " defense.");
    }
}