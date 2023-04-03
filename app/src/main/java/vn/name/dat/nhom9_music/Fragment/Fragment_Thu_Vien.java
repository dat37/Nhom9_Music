package vn.name.dat.nhom9_music.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.name.dat.nhom9_music.Activity.HomeActivity;
import vn.name.dat.nhom9_music.Adapter.ViewPagerThuVien;
import vn.name.dat.nhom9_music.R;

public class Fragment_Thu_Vien extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imgAddThuVien;
    CircleImageView imguser;
    ProgressDialog progressDialog;
    View view;
    private String tenThuVien;
    private HomeActivity hm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_thu_vien, container, false);
        AnhXa();
        init();
        imgAddThuVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openDialog();
            }
        });
        return  view;
    }
    private void init() {
        ViewPagerThuVien viewPagerThuVien = new ViewPagerThuVien(getChildFragmentManager());
        viewPagerThuVien.addFragment(new Fragment_ThuVien_NgheSi(), "Nghệ sĩ");
        viewPagerThuVien.addFragment(new Fragment_ThuVien_YeuThich(), "Yêu thích");
        viewPager.setAdapter(viewPagerThuVien);
        tabLayout.setupWithViewPager(viewPager);
        Picasso.get().load(hm.getUrl()).into(imguser);
    }

    private void AnhXa() {
        hm = (HomeActivity) getActivity();
        tabLayout = view.findViewById(R.id.tabLayouttv);
        viewPager = view.findViewById(R.id.viewPagertv);
        imgAddThuVien = view.findViewById(R.id.idaddthuvien);
        imguser = view.findViewById(R.id.imageviewuserthuvien);
    }

}