package com.example.videocategory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.videocategory.databinding.RecyclerviewFragmentBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {
    RecyclerviewFragmentBinding binding;
    String urlAPI = "http://demo1913415.mockable.io/GetCategory";
    String url_banner = "https://demo5898233.mockable.io/banner";

    public static RecyclerViewFragment newInstance() {

        Bundle args = new Bundle();

        RecyclerViewFragment fragment = new RecyclerViewFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate( inflater, R.layout.recyclerview_fragment, container, false );
        new DoGetData().execute();
        // ---------------- Call API with Volley-----------------------------------------
        {
            RequestQueue queue = Volley.newRequestQueue( getContext() );
            JsonArrayRequest request = new JsonArrayRequest( Request.Method.GET, url_banner, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            List<ImageBanner> bannerList = new ArrayList<>();
                            List<String> image = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject jsonObject = response.getJSONObject( i );
                                    int ID = jsonObject.getInt( "id" );
                                    String name = jsonObject.getString( "name" );
                                    String link = jsonObject.getString( "link" );
                                    ImageBanner imageBanner = new ImageBanner( ID, name, link );
                                    bannerList.add( imageBanner );
                                    image.add( link );
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(), 2, RecyclerView.HORIZONTAL, false );
                            binding.listVideo1.setLayoutManager(layoutManager );
                            RecyclerView_2Adapter recyclerViewAdapter = new RecyclerView_2Adapter( bannerList, getContext() );
                            binding.listVideo1.setAdapter(recyclerViewAdapter );
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            } );
            queue.add( request );

        }
        // ----------------End Call API with Volley--------------------------------------
        int image[] = {R.drawable.black_panther, R.drawable.iron_man, R.drawable.thor,R.drawable.zutto, R.drawable.your_name_min};
        for (int i = 0; i < image.length; i++) {
            FlipperImage( image[i] );
        }
        return binding.getRoot();
    }

    public void FlipperImage(int image) {
        ImageView imageView = new ImageView( getContext() );
        imageView.setBackgroundResource( image );
        imageView.setScaleType( ImageView.ScaleType.FIT_XY );
        binding.viewFlipper.addView( imageView );
        binding.viewFlipper.setFlipInterval( 4000 );
        binding.viewFlipper.setAutoStart( true );
        binding.viewFlipper.setInAnimation( getContext(), android.R.anim.slide_in_left );
        binding.viewFlipper.setOutAnimation( getContext(), android.R.anim.slide_out_right );
    }

    public class DoGetData extends AsyncTask<Void, Void, Void> {
        List<VideoObject> videoObjectList;
        String result = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            binding.loading.setVisibility( View.VISIBLE );
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL( urlAPI );
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            binding.loading.setVisibility( View.GONE );
            videoObjectList = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray( result );
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject( i );

                    int id = jsonObject.getInt( "id" );
                    int publisher_id = jsonObject.getInt( "publisher_id" );
                    int content_type = jsonObject.getInt( "content_type" );
                    int tab = jsonObject.getInt( "tab" );
                    String title = jsonObject.getString( "title" );
                    String avatar = jsonObject.getString( "avatar" );
                    int status = jsonObject.getInt( "status" );
                    int deleted = jsonObject.getInt( "deleted" );
                    int user_created = jsonObject.getInt( "user_created" );
                    int user_modified = jsonObject.getInt( "user_modified" );
                    String date_created = jsonObject.getString( "date_created" );
                    String date_modified = jsonObject.getString( "date_modified" );
                    int parent_id = jsonObject.getInt( "parent_id" );
                    int lft = jsonObject.getInt( "lft" );
                    int rgt = jsonObject.getInt( "rgt" );
                    int level = jsonObject.getInt( "level" );
                    String short_code = jsonObject.getString( "short_code" );
                    String command_code = jsonObject.getString( "command_code" );
                    double price = jsonObject.getDouble( "price" );
                    String finished_message = jsonObject.getString( "finished_message" );
                    String help_message = jsonObject.getString( "help_message" );
                    int icash = jsonObject.getInt( "icash" );
                    String thumb = jsonObject.getString( "thumb" );
                    VideoObject videoObject = new VideoObject( id, publisher_id, content_type, tab, title, avatar,
                            status, deleted, user_created, user_modified, date_created, date_modified, parent_id, lft, rgt, level,
                            short_code, command_code, price, finished_message, help_message, icash, thumb );
                    videoObjectList.add( videoObject );
                }
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(), 2, RecyclerView.HORIZONTAL, false );
                binding.listVideo.setLayoutManager( layoutManager );
//                binding.listVideo1.setLayoutManager( layoutManager );
                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter( videoObjectList, getContext() );
                binding.listVideo.setAdapter( recyclerViewAdapter );
//                binding.listVideo1.setAdapter( recyclerViewAdapter );
            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute( aVoid );
        }
    }
}
