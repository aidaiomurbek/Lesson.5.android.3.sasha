package com.example.lesson5android3sasha.ui.saved;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson5android3sasha.data.model.FilmModel;
import com.example.lesson5android3sasha.databinding.ItemSavedBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.ViewHolder> {

    protected List<FilmModel> list = new ArrayList<>();
    protected OnClickListener listener;

    public SavedAdapter(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ItemSavedBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    public void addList(List<FilmModel> list) {
        if (list != null) {
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemSavedBinding binding;

        public ViewHolder(@NonNull @NotNull ItemSavedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FilmModel model) {
            binding.textTitleItemSaved.setText(model.getTitle());
            binding.getRoot().setOnClickListener(v ->
                    listener.onClick(model));
        }
    }

    interface OnClickListener {
        void onClick(FilmModel model);
    }
}
