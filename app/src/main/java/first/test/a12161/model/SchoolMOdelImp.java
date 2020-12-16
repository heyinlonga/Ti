package first.test.a12161.model;

import first.test.a12161.bean.ClasBean;
import first.test.a12161.bean.SchoolBean;
import first.test.a12161.contract.SchoolCallBack;
import first.test.a12161.contract.SchoolContract;
import first.test.a12161.view.ApiService;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchoolMOdelImp implements SchoolContract.MainModel {


    @Override
    public void model(SchoolContract.MainPersenter persenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.School_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getSchool()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SchoolBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SchoolBean schoolBean) {
                        persenter.onNext(schoolBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        persenter.onError("错误异常"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void model2(SchoolContract.MainPersenter persenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Clas_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getClas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClasBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ClasBean clasBean) {
                        persenter.onNext2(clasBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        persenter.onError("错误异常"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
