package com.atpcom.moneyapp.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.arch.persistence.room.Room;

import com.atpcom.moneyapp.db.AppDataBase;
import com.atpcom.moneyapp.models.Account;

public class MainViewModel extends AndroidViewModel {

    private LiveData<PagedList<Account>> mAccountsList;
    private AppDataBase appDataBase;

    public MainViewModel(Application application) {
       super(application);
       appDataBase = Room.databaseBuilder(application, AppDataBase.class, "accounts.db")
               .build();
       PagedList.Config pagedListConfig=(new PagedList.Config.Builder()).setEnablePlaceholders(true)
               .setPrefetchDistance(10)
               .setPageSize(20).build();
       mAccountsList = new LivePagedListBuilder<>(
                appDataBase.accountDao().getAll(), pagedListConfig).build();
    }

    AppDataBase getAppDataBase() {
        return appDataBase;
    }

    LiveData<PagedList<Account>> getAccountsList() {
        return mAccountsList;
    }
}
