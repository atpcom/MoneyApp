package com.atpcom.moneyapp.ui.main;

import android.support.v7.widget.RecyclerView;

import com.atpcom.moneyapp.databinding.AccountItemBinding;
import com.atpcom.moneyapp.models.Account;

class RvViewHolder extends RecyclerView.ViewHolder {

    private AccountItemBinding mBinding;

    RvViewHolder(AccountItemBinding binding) {
        super(binding.getRoot());
        mBinding=binding;
    }

    void bind(Account account){
        mBinding.setAccount(account);
        mBinding.executePendingBindings();
    }
}
