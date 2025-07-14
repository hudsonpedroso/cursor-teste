package com.werewolfvampire.game.entity;

public enum Faction {
    WEREWOLF("Lobisomem", "#8B4513"),
    VAMPIRE("Vampiro", "#800080");

    private final String displayName;
    private final String color;

    Faction(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColor() {
        return color;
    }
}