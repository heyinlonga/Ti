package first.test.a12161.fragment;

import android.os.Bundle;
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


public class ClasFragment extends Fragment implements SchoolContract.MainView {

    private RecyclerView mRecylcer;
    private ArrayList<ClasBean.StudenlistBean> list;
    private ClasAdapter clasAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_clas, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        SchoolPresenterImp schoolPresenterImp = new SchoolPresenterImp(this);
        schoolPresenterImp.par2();
    }

    private void initView(View view) {
        mRecylcer=view.findViewById(R.id.recylcer);
        list = new ArrayList<>();
        clasAdapter = new ClasAdapter(getActivity(), list);
        mRecylcer.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecylcer.setAdapter(clasAdapter);
        mRecylcer.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onNext(SchoolBean schoolBean) {

    }

    @Override
    public void onNext1(ClasBean clasBean) {
        List<ClasBean.StudenlistBean> studenlist = clasBean.getStudenlist();
        list.addAll(studenlist);
        clasAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}