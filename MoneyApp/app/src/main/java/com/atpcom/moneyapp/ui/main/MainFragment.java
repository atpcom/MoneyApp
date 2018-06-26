package com.atpcom.moneyapp.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.atpcom.moneyapp.R;
import com.atpcom.moneyapp.models.Account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainFragment extends Fragment {

    public static final String TAG = "qwerty";

    private MainViewModel viewModel;
    private RvAdapter rvAdapter;
    private ExecutorService IO_EXECUTOR = Executors.newSingleThreadExecutor();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.rvAccountList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new RvAdapter();
        viewModel.getAccountsList().observe(this, rvAdapter::submitList);
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(), recyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                
            }

            @Override
            public void onLongClick(View view, int position) {
                Account account = rvAdapter.getCurrentList().get(position);
                IO_EXECUTOR.execute(()-> viewModel.getAppDataBase().accountDao().delete(account));
            }
        }));
        recyclerView.setAdapter(rvAdapter);

        setHasOptionsMenu(true);
        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addAccount:
                Account account = new Account("c","wallet",100,"rub");
                IO_EXECUTOR.execute(()-> viewModel.getAppDataBase().accountDao().insert(account));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
