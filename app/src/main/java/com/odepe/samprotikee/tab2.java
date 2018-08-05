package com.odepe.samprotikee;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.florent37.diagonallayout.DiagonalLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class tab2 extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Model> list;
    private Tab2RecyclerView adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    DiagonalLayout diagonalLayout;

    private String baseURL = "http://www.samprotikee.com";

    public static List<WPImage> mListPost;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View view =inflater.inflate(R.layout.tab1,container,false);

        // post dekhar jonno cardview start

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        diagonalLayout = (DiagonalLayout)view.findViewById(R.id.diagonalLayout);
        //progressBar = (ProgressBar)view.findViewById(R.id.progressbar);
        diagonalLayout.setVisibility(View.GONE);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent login = new Intent(view.getContext(), MainActivity.class);
                startActivity(login);
            }
        });

        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        list = new ArrayList<Model>();
        /// call retrofill
        getRetrofit();

        adapter = new Tab2RecyclerView(list, getContext());

        recyclerView.setAdapter(adapter);


        return view;

    }

    public void getRetrofit(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        Call<List<WPImage>> call = service.getPostInfotab2();

        // to make call to dynamic URL

        // String yourURL = yourURL.replace(BaseURL,"");
        // Call<List<WPPost>>  call = service.getPostInfo( yourURL);

        /// to get only 6 post from your blog
        // http://your-blog-url/wp-json/wp/v2/posts?per_page=2

        // to get any specific blog post, use id of post
        //  http://www.blueappsoftware.in/wp-json/wp/v2/posts/1179

        // to get only title and id of specific
        // http://www.blueappsoftware.in/android/wp-json/wp/v2/posts/1179?fields=id,title



        call.enqueue(new Callback<List<WPImage>>() {
            @Override
            public void onResponse(Call<List<WPImage>> call, Response<List<WPImage>> response) {
                Log.e("mainactivyt", " response "+ response.body());
                mListPost = response.body();
                //progressBar.setVisibility(View.GONE);
                for (int i=0; i<response.body().size();i++){
                    Log.e("main ", " title "+ response.body().get(i).getTitle().getRendered() + " "+
                            response.body().get(i).getId());

                    //String tempdetails =  response.body().get(i).getExcerpt().getRendered().toString();
                    String tempdetails =  response.body().get(i).getBetterFeaturedImage().getSourceUrl().toString();
                    //tempdetails = tempdetails.replace("<p>","");
                    //tempdetails = tempdetails.replace("</p>","");
                    //tempdetails = tempdetails.replace("[&hellip;]","");

                    String time =  response.body().get(i).getModified().toString();

                    list.add( new Model( Model.IMAGE_TYPE,  response.body().get(i).getTitle().getRendered(),
                            tempdetails,
                            response.body().get(i).getBetterFeaturedImage().getSourceUrl(),
                            time));

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<WPImage>> call, Throwable t) {

            }
        });

    }
    public static List<WPImage> getList(){
        return  mListPost;
    }
}
