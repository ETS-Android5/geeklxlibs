/**
 * Copyright 2016,Smart Haier.All rights reserved
 */
package com.just.agentweb.geek.hois3;

import android.util.Pair;

import java.util.HashMap;

public class HiosAliasNew {
    // Map<alias, Pair<packageName, className>>
    private static HashMap<String, Pair<String, String>> sAlias = new HashMap<>();

    public static void register(String name, String packageName, String target) {
        sAlias.put(name, Pair.create(packageName, target));
    }

    public static Pair<String, String> getByName(String name) {
        return sAlias.get(name);
    }
}
