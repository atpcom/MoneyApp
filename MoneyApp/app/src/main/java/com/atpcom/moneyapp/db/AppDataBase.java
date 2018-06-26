package com.atpcom.moneyapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.atpcom.moneyapp.models.Account;

@Database(entities = {Account.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract AccountDao accountDao();
}
