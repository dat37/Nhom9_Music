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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.name.dat.nhom9_music.Adapter.NgheSiAdapter;
import vn.name.dat.nhom9_music.Model.NgheSiModel;
import vn.name.dat.nhom9_music.R;
import vn.name.dat.nhom9_music.Service_API.APIService;
import vn.name.dat.nhom9_music.Service_API.Dataservice;

public class Fragment_NgheSi extends Fragment {

    View view;
    NgheSiAdapter ngheSiAdapter;
    RecyclerView recyclerViewNgheSi;
    TextView tenNgheSi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nghesi, container, false);
        recyclerViewNgheSi = view.findViewById(R.id.recyclerviewnghesi);
        tenNgheSi = view.findViewById(R.id.txtnghesi);
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
                ngheSiAdapter = new NgheSiAdapter(getActivity(), mangnghesi);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewNgheSi.setLayoutManager(linearLayoutManager);
                recyclerViewNgheSi.setAdapter(ngheSiAdapter);
            }

            @Override
            public void onFailure(Call<List<NgheSiModel>> call, Throwable t) {

            }

        });
    }

}