package com.droid.war.users;

import com.droid.war.model.Droid;
import com.droid.war.model.DroidWithDoubleDamage;

public class DroidStorage {
    static Droid droid1 = new DroidWithDoubleDamage("Android", 1000, 30, 60);
    static Droid droid2 = new DroidWithDoubleDamage("Apple", 1000, 20, 70);

    public static Droid getDroid1() {
        return droid1;
    }

    public static Droid getDroid2() {
        return droid2;
    }

    public static void setDroid1(Droid droid1) {
        DroidStorage.droid1 = droid1;

    }

    public static void setDroid2(Droid droid2) {
        DroidStorage.droid2 = droid2;

    }
}
