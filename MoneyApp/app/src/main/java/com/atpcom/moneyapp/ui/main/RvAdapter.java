package com.atpcom.moneyapp.ui.main;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.atpcom.moneyapp.R;
import com.atpcom.moneyapp.databinding.AccountItemBinding;
import com.atpcom.moneyapp.models.Account;

public class RvAdapter extends PagedListAdapter<Account,RvViewHolder> {

    public static int pos;

    private static final DiffUtil.ItemCallback<Account> DIFF_UTIL = new DiffUtil.ItemCallback<Account>() {
        @Override
        public boolean areItemsTheSame(Account oldItem, Account newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(Account oldItem, Account newItem) {
            return oldItem.equals(newItem);
        }
    };

    RvAdapter() {
        super(DIFF_UTIL);
    }


    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AccountItemBinding binding = DataBindingUtil.inflate(inflater,R.layout.account_item,parent,false);
        return new RvViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}