package com.example.lesson5android3sasha.ui.film;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.lesson5android3sasha.R;
import com.example.lesson5android3sasha.data.model.FilmModel;
import com.example.lesson5android3sasha.data.network.FilmRepository;
import com.example.lesson5android3sasha.databinding.FragmentFilmBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FilmFragment extends Fragment implements FilmAdapter.OnClickFilmAdapter {

    public static final String ID = "id";
    protected FragmentFilmBinding binding;
    protected FilmAdapter adapter;
    protected NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        getFilm();
        setupListener();
    }

    private void init() {
        adapter = new FilmAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

    }

    private void getFilm() {
        FilmRepository.getFilm(new FilmRepository.FilmCallback() {
            @Override
            public void onSuccess(List<FilmModel> list) {
                if (adapter != null) {
                    adapter.addList(list);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }

    private void setupListener() {
        binding.btnSavedFragmentFilm.setOnClickListener(v ->
                navController.navigate(R.id.action_filmFragment_to_savedFragment)
        );
    }

    @Override
    public void onClickSend(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(ID, id);
        setArguments(bundle);
        navController.navigate(R.id.action_mainFragment_to_descriptionFragment, bundle);
    }

    @Override
    public void onClickSave(FilmModel model) {
        FilmRepository.insertFilm(model);
        Toast.makeText(requireContext(), "Фильм сохранился!", Toast.LENGTH_SHORT).show();
    }
}