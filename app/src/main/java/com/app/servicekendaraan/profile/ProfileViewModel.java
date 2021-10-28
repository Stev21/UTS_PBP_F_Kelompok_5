package com.app.servicekendaraan.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.app.servicekendaraan.roomdatabase.ServiceKendaraanDatabase;
import com.app.servicekendaraan.roomdatabase.user.UserDao;
import com.app.servicekendaraan.roomdatabase.user.UserData;

public class ProfileViewModel extends AndroidViewModel {
    private UserDao dao;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        dao = ServiceKendaraanDatabase.getSaveInstance(application).userDao();
    }

    public LiveData<UserData> getDataByUsername(String username) {
        return dao.getDataByUserName(username);
    }

    public void edit(UserData userData) {
        new Thread(() -> dao.updateUser(userData)).start();

    }


}
