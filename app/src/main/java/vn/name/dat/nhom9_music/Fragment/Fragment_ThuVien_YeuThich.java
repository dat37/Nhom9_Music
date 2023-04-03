package vn.name.dat.nhom9_music.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.name.dat.nhom9_music.Activity.HomeActivity;
import vn.name.dat.nhom9_music.Adapter.YeuThichAdapter;
import vn.name.dat.nhom9_music.Model.BaiHatYeuThichModel;
import vn.name.dat.nhom9_music.R;
import vn.name.dat.nhom9_music.Service_API.APIService;
import vn.name.dat.nhom9_music.Service_API.Dataservice;

public class Fragment_ThuVien_YeuThich extends Fragment {
    View view;
    private HomeActivity hm;
    private YeuThichAdapter yeuThichAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thu_vien_yeu_thich, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewyeuthich);
        hm = (HomeActivity) getActivity();
        GetData(hm.getTaikhoan());
        swipeRefreshLayout = view.findViewById(R.id.swipeyeuthich);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetData(hm.getTaikhoan());
                yeuThichAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }
    public void GetData(String username) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatYeuThichModel>> callback = dataservice.danhsachyeuthich(username);
        callback.enqueue(new Callback<List<BaiHatYeuThichModel>>() {
            @Override
            public void onResponse(Call<List<BaiHatYeuThichModel>> call, Response<List<BaiHatYeuThichModel>> response) {
                ArrayList<BaiHatYeuThichModel> mangyeuthich = (ArrayList<BaiHatYeuThichModel>) response.body();
                yeuThichAdapter = new YeuThichAdapter(getActivity(), mangyeuthich);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(yeuThichAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatYeuThichModel>> call, Throwable t) {

            }
        });
    }
}