package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero knight = new Hero("Sir Arthur", 250, 0, 45, 60, 500, new Inventory());
        Hero mage = new Hero("Merlin", 100, 300, 10, 20, 1500, new Inventory());

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(knight, mage));

        System.out.println("\n[ FINAL VAULT SUMMARY ]");
        System.out.println(result);
    }
}
