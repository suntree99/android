package com.darma1budi.githubuser2;

import androidx.datastore.core.DataStore;

import java.util.concurrent.Flow;
import java.util.prefs.Preferences;

public class PreferenceSetting {
    private static final String THEME_KEY = "theme_setting";
    private static volatile PreferenceSetting INSTANCE;
    private final DataStore<Preferences> dataStore;

    private PreferenceSetting(DataStore<Preferences> dataStore) {
        this.dataStore = dataStore;
    }

//    public Flow<Boolean> getThemeSetting() {
//        return this.dataStore.getData().map((preferences) -> {
//            return preferences.getBoolean(THEME_KEY, false);
//        });
//    }

//    public void saveThemeSetting(boolean isDarkModeActive) {
//        this.dataStore.edit((preferences) -> {
//            preferences.putBoolean(THEME_KEY, isDarkModeActive);
//        });
//    }

    public static PreferenceSetting getInstance(DataStore<Preferences> dataStore) {
        if (INSTANCE == null) {
            synchronized(PreferenceSetting.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PreferenceSetting(dataStore);
                }
            }
        }

        return INSTANCE;
    }
}

