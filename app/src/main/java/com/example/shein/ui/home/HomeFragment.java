package com.example.shein.ui.home;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.shein.databinding.FragmentHomeBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SpannableString spannableString = new SpannableString("GBP£3.50 GBP£5.49");
        StrikethroughSpan ss = new StrikethroughSpan();
        spannableString.setSpan(ss, 9, 17, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textview.setText(spannableString);

        List<CarouselItem> list = new ArrayList<>();

        list.add(new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Photo by Aaron Wu on Unsplash"));
        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080","RKRKRKR"));

        binding.carousel.setData(list);
        binding.carousel2.setData(list);
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}