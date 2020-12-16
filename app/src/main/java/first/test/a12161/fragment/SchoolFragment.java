package first.test.a12161.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import first.test.a12161.R;
import first.test.a12161.bean.ClasBean;
import first.test.a12161.bean.SchoolBean;
import first.test.a12161.contract.SchoolContract;
import first.test.a12161.presenter.SchoolPresenterImp;


public class SchoolFragment extends Fragment implements SchoolContract.MainView{


    private RecyclerView recycler;
    private RecyclerView mRecycler;
    private ArrayList<SchoolBean.NewsBean> list;
    private SchoolAdapter schoolAdapter;
    private SchoolPresenterImp schoolPresenterImp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        // Inflate the layout for this fragment
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        schoolPresenterImp = new SchoolPresenterImp(this);
        schoolPresenterImp.par();
    }

    private void initView(View view) {
        mRecycler = view.findViewById(R.id.recycler);
        list = new ArrayList<>();
        schoolAdapter = new SchoolAdapter(getActivity(), list);
        mRecycler.setAdapter(schoolAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNext(SchoolBean schoolBean) {
        List<SchoolBean.NewsBean> news = schoolBean.getNews();
        list.addAll(news);
        schoolAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNext1(ClasBean clasBean) {

    }

    @Override
    public void onError(String error) {
        Log.e(TAG, "onError: 错误信息"+error );
    }

    private static final String TAG = "SchoolFragment";
}