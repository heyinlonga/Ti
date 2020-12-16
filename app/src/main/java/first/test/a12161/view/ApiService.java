package first.test.a12161.view;

import first.test.a12161.bean.ClasBean;
import first.test.a12161.bean.SchoolBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String School_Url="http://cdwan.cn:7000/";
    @GET("exam2003/anewslist.json")
    Observable<SchoolBean> getSchool();
    String Clas_Url="http://cdwan.cn:7000/";
    @GET("exam2003/astudent.json")
    Observable<ClasBean> getClas();
}
