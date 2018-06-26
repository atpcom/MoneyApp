package com.atpcom.moneyapp.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.arch.paging.DataSource;
import com.atpcom.moneyapp.models.Account;
import java.util.List;

@Dao
public interface AccountDao {

    @Query("SELECT * FROM account")
    DataSource.Factory<Integer,Account> getAll();

    @Query("SELECT * FROM account WHERE id = :id")
    Account getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Account account);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Account> accounts);

    @Update
    void update(Account account);

    @Delete
    void delete(Account account);
}
