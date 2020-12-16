package first.test.a12161.contract;

import first.test.a12161.bean.ClasBean;
import first.test.a12161.bean.SchoolBean;

public class SchoolContract {
    public interface MainView{
        void onNext(SchoolBean schoolBean);
        void onNext1(ClasBean clasBean);
        void onError(String error);
    }
    public interface  MainModel{
       void model(MainPersenter persenter);
       void model2(MainPersenter persenter);
    }
    public interface MainPersenter{
        void par();
        void par2();
        void onNext(SchoolBean schoolBean);
        void onNext2(ClasBean clasBean);
        void onError(String error);
    }
}
