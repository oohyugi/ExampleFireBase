package com.yogiputra.examplefirebase.controller;

import android.os.Bundle;

import com.yogiputra.examplefirebase.databinding.ActivityMainBinding;
import com.yogiputra.examplefirebase.vm.MainActivityVM;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by yogi on 27/04/16.
 */
public class MainController extends GitsController<MainActivityVM, ActivityMainBinding> {

    @Override
    public MainActivityVM createViewModel(ActivityMainBinding binding) {
        return new MainActivityVM(mActivity,this,binding);
    }

    @Override
    public void bindViewModel(ActivityMainBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        //TODO your onCreate



    }
}
