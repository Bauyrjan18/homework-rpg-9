package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;

import java.util.Stack;

public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>();
    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
        }
    }

    public HeroMemento undo() {
        if (history.isEmpty()) return null;
        return history.pop();
    }

    /**
     * Returns the most recent snapshot without removing it.
     *
     * @return the latest stored snapshot, or null in the scaffold
     */
    public HeroMemento peek() {
        if (history.isEmpty()) return null;
        return history.peek();
    }

    public int size() {
        return history.size();
    }
}
