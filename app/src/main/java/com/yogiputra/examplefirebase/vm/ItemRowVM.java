package com.yogiputra.examplefirebase.vm;

import android.content.Context;
import android.databinding.ObservableField;

import com.yogiputra.examplefirebase.dao.Berita;
import com.yogiputra.examplefirebase.databinding.ItemRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;

/**
 * Created by yogi on 27/04/16.
 */
public class ItemRowVM extends GitsRowVM<Berita, ItemRowBinding> {
    public ObservableField<String>mTitle= new ObservableField<>();
    public ObservableField<String>mContent= new ObservableField<>();


    public ItemRowVM(Context context, ItemRowBinding binding, Berita item) {
        super(context, binding, item);
        mTitle.set(item.getTitle());
        mContent.set(item.getContent());

    }


}
