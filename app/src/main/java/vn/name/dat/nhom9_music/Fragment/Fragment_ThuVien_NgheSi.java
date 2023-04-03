package vn.name.dat.nhom9_music.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.name.dat.nhom9_music.Adapter.ThuVienNgheSiAdapter;
import vn.name.dat.nhom9_music.Model.NgheSiModel;
import vn.name.dat.nhom9_music.R;
import vn.name.dat.nhom9_music.Service_API.APIService;
import vn.name.dat.nhom9_music.Service_API.Dataservice;

public class Fragment_ThuVien_NgheSi  extends Fragment {

    View view;
    ThuVienNgheSiAdapter thuVienNgheSiAdapter;
    RecyclerView recyclerViewNgheSi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien_nghesi, container, false);
        recyclerViewNgheSi = view.findViewById(R.id.recyclerviewnthuvienghesi);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<NgheSiModel>> callback = dataservice.GetNgheSiCurrent();
        callback.enqueue(new Callback<List<NgheSiModel>>() {
            @Override
            public void onResponse(Call<List<NgheSiModel>> call, Response<List<NgheSiModel>> response) {
                ArrayList<NgheSiModel> mangnghesi = (ArrayList<NgheSiModel>) response.body();
                thuVienNgheSiAdapter = new ThuVienNgheSiAdapter(getActivity(), mangnghesi);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewNgheSi.setLayoutManager(linearLayoutManager);
                recyclerViewNgheSi.setAdapter(thuVienNgheSiAdapter);
            }

            @Override
            public void onFailure(Call<List<NgheSiModel>> call, Throwable t) {

            }

        });
    }

}