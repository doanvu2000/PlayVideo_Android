package com.example.videocategory.ui.home;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.videocategory.MainActivity;
import com.example.videocategory.R;
import com.example.videocategory.RecyclerViewFragment;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private RecyclerViewFragment x;
    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue( "This is home fragment" );
        x = RecyclerViewFragment.newInstance();
//        FragmentManager fragmentManager = getClass().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace( R.id.nav_host_fragment, x);
//        fragmentTransaction.commit();
    }

    public LiveData<String> getText() {
        return mText;
    }
}