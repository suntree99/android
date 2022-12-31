package com.darma1budi.githubuser2;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class UserListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application mApplication;
    private String mUsername;
    private PreferenceSetting pref;

    public UserListViewModelFactory(Application mApplication, String mUsername, PreferenceSetting pref) {
        this.mApplication = mApplication;
        this.mUsername = mUsername;
        this.pref = pref;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(pref);
        } else if (modelClass.isAssignableFrom(PersonFaveViewModel.class)) {
            return (T) new PersonFaveViewModel(mApplication);
        } else if (modelClass.isAssignableFrom(PersonDetailViewModel.class)) {
            return (T) new PersonDetailViewModel(mApplication, mUsername);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
