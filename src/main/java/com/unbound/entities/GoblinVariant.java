package com.unbound.entities;

import net.minecraft.util.RandomSource;

import java.util.Arrays;
import java.util.Comparator;

public enum GoblinVariant {
    DEFAULT(0, 50),
    TRAVELER(1, 10),
    ARMORED(2, 20),
    SLINGER(3, 20);

    private static final GoblinVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(GoblinVariant::getId)).toArray(GoblinVariant[]::new);

    private final int id; // this is just a signifier of what variant is being used
    private final int weight; // this is the likelyhood of any variant spawning expressed as a %

    GoblinVariant(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }

    public static GoblinVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public static GoblinVariant getRandom(RandomSource random) {
        int total = Arrays.stream(values()).mapToInt(v -> v.weight).sum(); // 100
        int roll = random.nextInt(total);
        int cumulative = 0;
        for (GoblinVariant variant : values()) {
            cumulative += variant.weight;
            if (roll < cumulative) return variant;
        }
        return DEFAULT;
    }
}