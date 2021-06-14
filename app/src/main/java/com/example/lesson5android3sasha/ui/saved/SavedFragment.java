package com.example.lesson5android3sasha.ui.saved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lesson5android3sasha.R;
import com.example.lesson5android3sasha.data.model.FilmModel;
import com.example.lesson5android3sasha.data.network.FilmRepository;
import com.example.lesson5android3sasha.databinding.FragmentSavedBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SavedFragment extends Fragment implements SavedAdapter.OnClickListener {

    public static final String MODEL = "model";
    protected SavedAdapter adapter;
    protected FragmentSavedBinding binding;


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSavedBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        getFilms();
    }

    private void init() {
        adapter = new SavedAdapter(this);
        binding.recyclerViewFilmFragmentSaved.setAdapter(adapter);
    }

    private void getFilms() {
        List<FilmModel> list = FilmRepository.getFilmsFromRoom();
        adapter.addList(list);
    }

    @Override
    public void onClick(FilmModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MODEL, model);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(R.id.action_savedFragment_to_descriptionFragment, bundle);
    }
}