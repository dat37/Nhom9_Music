package vn.name.dat.nhom9_music.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.name.dat.nhom9_music.Adapter.DanhsachbaihatAdapter;
import vn.name.dat.nhom9_music.Model.BaiHatModel;
import vn.name.dat.nhom9_music.Model.NgheSiModel;
import vn.name.dat.nhom9_music.Model.PhoBienModel;
import vn.name.dat.nhom9_music.Model.PlaylistModel;
import vn.name.dat.nhom9_music.R;
import vn.name.dat.nhom9_music.Service_API.APIService;
import vn.name.dat.nhom9_music.Service_API.Dataservice;

public class DanhsachbaihatActivity extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    TextView txtcollapsing;
    PlaylistModel playlist = null;
    NgheSiModel ngheSi = null;
    PhoBienModel phoBien = null;
    ImageView imgdanhsachcakhuc;
    ArrayList<BaiHatModel> mangbaihat;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    ImageView btnThemnhac;
    SwipeRefreshLayout swipeRefreshLayout;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        AnhXa();
        floatingActionButton.setEnabled(false);
        DataIntent();
        overridePendingTransition(R.anim.anim_intent_in, R.anim.anim_intent_out);
        if (ngheSi != null && !ngheSi.equals("")){
            setValueInView(ngheSi.getHinhNgheSi());
            GetDataNgheSi(ngheSi.getIdNgheSi());
            txtcollapsing.setText(ngheSi.getTenNgheSi());
            getSupportActionBar().setTitle(ngheSi.getTenNgheSi());
        }
        if (playlist != null && !playlist.equals("")){
            setValueInView(playlist.getHinhPlaylist());
            GetDataPlaylist(playlist.getIdPlaylist());
            txtcollapsing.setText(playlist.getTen());
            getSupportActionBar().setTitle(playlist.getTen());
        }
        if (phoBien != null && !phoBien.equals("")){
            setValueInView(phoBien.getHinhPhoBien());
            GetDataPhoBien(phoBien.getIdPhoBien());
            txtcollapsing.setText(phoBien.getTenPhoBien());
            getSupportActionBar().setTitle(phoBien.getTenPhoBien());
        }

        floatActionButtonClick();

    }

    private void setValueInView(String hinh) {
        Picasso.get().load(hinh).into(imgdanhsachcakhuc);
    }
    private void GetDataPlaylist(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatplaylist(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }
    private void GetDataBangXepHang(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatbangxephang(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }
    private void GetDataChuDe(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatchude(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }
    private void GetDataNgheSi(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatnghesi(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }

    private void GetDataPhoBien(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatphobien(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }
    private void GetDataThinhHanh(String id) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatModel>> callback = dataservice.GetDanhsachbaihatthinhhanh(id);
        callback.enqueue(new Callback<List<BaiHatModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatModel>> call, Response<List<BaiHatModel>> response) {
                mangbaihat = (ArrayList<BaiHatModel>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatModel>> call, Throwable t) {

            }
        });
    }

    private void AnhXa() {
        toolbar = findViewById(R.id.toolbardanhsachbaihat);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        imgdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        txtcollapsing = findViewById(R.id.textViewcollapsing);
        btnThemnhac = findViewById(R.id.btnthemnhacthuvien);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void DataIntent() {
        Intent intent = getIntent();
        btnThemnhac.setVisibility(View.GONE);
        if (intent != null){
            if (intent.hasExtra("intentplaylist")){
                playlist = (PlaylistModel) intent.getSerializableExtra("intentplaylist");
            }else
            if (intent.hasExtra("intentnghesi")){
                ngheSi = (NgheSiModel) intent.getSerializableExtra("intentnghesi");
            }else
            if (intent.hasExtra("intentphobien")){
                phoBien = (PhoBienModel) intent.getSerializableExtra("intentphobien");
            }
        }
    }
    private void floatActionButtonClick(){
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DanhsachbaihatActivity.this, PlayNhacActivity.class);
                if (mangbaihat!=null){
                    if (mangbaihat.size() > 0){
                        intent.putExtra("cacbaihat", mangbaihat);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DanhsachbaihatActivity.this, "Danh sách không có bài hát nào cả :(", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(DanhsachbaihatActivity.this, "Danh sách không có bài hát nào cả :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}