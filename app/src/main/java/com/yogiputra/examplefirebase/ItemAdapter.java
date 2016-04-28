package com.yogiputra.examplefirebase;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yogiputra.examplefirebase.dao.Berita;
import com.yogiputra.examplefirebase.databinding.ItemRowBinding;
import com.yogiputra.examplefirebase.vm.ItemRowVM;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by yogi on 27/04/16.
 */
public class ItemAdapter extends GitsAdapter<Berita,ItemRowVM,ItemRowBinding> {
    public ItemAdapter(List<Berita> collection) {
        super(collection);
    }

    @Override
    public ItemRowVM createViewModel(AppCompatActivity activity, ItemRowBinding binding, Berita item) {
        return new ItemRowVM(activity,binding,item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_row;
    }

    @Override
    public void render(ItemRowBinding binding, ItemRowVM viewModel, Berita item) {
    binding.setVm(viewModel);

    }

    @Override
    public void onRowClick(Berita data, int position) {
        Toast.makeText(mContext,"Hello"+mCollection.get(position).getTitle(),Toast.LENGTH_SHORT).show();
    }
}
