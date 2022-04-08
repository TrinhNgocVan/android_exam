package com.aptech.exam_edit;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.aptech.exam_edit.config.AppDatabase;
import com.aptech.exam_edit.dao.ProductDao;
import com.aptech.exam_edit.databinding.FragmentFirstBinding;
import com.aptech.exam_edit.entity.Product;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    Button addButton ;
    EditText nameText ;
    EditText quantityTex ;
    ProductDao productDao ;
    private AppDatabase appDatabase ;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameText = getView().findViewById(R.id.productName) ;
        quantityTex = getView().findViewById(R.id.productQuantity) ;
        appDatabase  = AppDatabase.buildDatabaseInstance(  getActivity(), "android_exam" , false);
        Toast.makeText(getActivity(),  appDatabase.doesDatabaseExist(getActivity(),"android_exam"), Toast.LENGTH_SHORT).show();

        binding.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                String name  = String.valueOf(nameText.getText());
                int quantity =   Integer.parseInt(String.valueOf(nameText.getText())); ;

            Product p = new Product(name ,quantity);
              addProduct(p);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }

        });

    }
    public  void addProduct(Product p ){
        productDao = appDatabase.productDao() ;
        productDao.add(p);
        Toast.makeText(getActivity(), "inserted", Toast.LENGTH_SHORT).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getallsong(){
        productDao = appDatabase.productDao() ;
        List<Product> songs = productDao.getlAll();

        songs.stream().forEach(s -> {
                    Toast.makeText(getActivity(), s.getName(), Toast.LENGTH_SHORT).show();
                }
        );
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}