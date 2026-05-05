package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {
    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n--- Entering the Chronomancer's Vault ---");

        Inventory vaultLoot = new Inventory();
        vaultLoot.addArtifact(new Weapon("Bloodletter Sword", 500, 15, 60)); // Cursed
        vaultLoot.addArtifact(new Potion("Elixir of Reversal", 100, 1, 100));
        vaultLoot.addArtifact(new Scroll("Rune of Doom", 300, 0, "Doom Strike")); // Cursed
        vaultLoot.addArtifact(new Ring("Band of Eternity", 1000, 0, 20)); // Cursed (value > 900)
        vaultLoot.addArtifact(new Armor("Aegis Plate", 800, 45, 100));

        System.out.println("\n[ APPRAISAL PHASE ]");
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        EnchantmentScanner scanner = new EnchantmentScanner();
        CurseDetector detector = new CurseDetector();
        WeightCalculator weightCalc = new WeightCalculator(); // 4th visitor

        ArtifactVisitor[] visitors = {goldAppraiser, scanner, detector, weightCalc};

        for (ArtifactVisitor visitor : visitors) {
            System.out.println("\n>>> Running " + visitor.getClass().getSimpleName() + ":");
            vaultLoot.accept(visitor);
        }

        System.out.println("\nSummary: Vault holds " + goldAppraiser.getTotalGoldValue() + "G and weighs " + weightCalc.getTotalWeight() + " lbs.");

        System.out.println("\n[ TRAP PHASE & TIME REWIND ]");
        Hero leader = party.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println(leader.getName() + " approaches the central pedestal.");
        System.out.println("State BEFORE: " + leader);

        caretaker.save(leader.createMemento());
        System.out.println(">> Time crystal activated! Snapshot saved. Caretaker size: " + caretaker.size());

        System.out.println("\n!!! A cursed temporal trap triggers! !!!");
        leader.takeDamage(150);
        leader.spendGold(200);
        System.out.println("State AFTER TRAP: " + leader);

        System.out.println("\n>> Smashing the time crystal... Rewinding time...");
        leader.restoreFromMemento(caretaker.undo());
        System.out.println("State AFTER REWIND: " + leader);

        int appraisedCount = vaultLoot.size() * visitors.length;
        return new VaultRunResult(appraisedCount, 1, 1);
    }
}
