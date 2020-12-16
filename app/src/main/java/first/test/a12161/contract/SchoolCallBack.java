package first.test.a12161.contract;

import first.test.a12161.bean.SchoolBean;

public interface SchoolCallBack {
    void onSuccess(SchoolBean schoolBean);
    void onFail(String error);
}
