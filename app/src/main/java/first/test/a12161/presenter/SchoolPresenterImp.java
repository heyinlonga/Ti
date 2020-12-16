package first.test.a12161.presenter;

import first.test.a12161.bean.ClasBean;
import first.test.a12161.bean.SchoolBean;
import first.test.a12161.contract.SchoolCallBack;
import first.test.a12161.contract.SchoolContract;
import first.test.a12161.fragment.SchoolFragment;
import first.test.a12161.model.SchoolMOdelImp;

public class SchoolPresenterImp implements SchoolContract.MainPersenter {

        private SchoolContract.MainView mainView;

        private SchoolContract.MainModel mainModel;
        public SchoolPresenterImp( SchoolContract.MainView mainView) {
            this.mainView = mainView;
            this.mainModel = new SchoolMOdelImp();
        }

        @Override
        public void par() {
            mainModel.model(this);
        }
        @Override
        public void par2() {
            mainModel.model2(this);
        }

        @Override
        public void onNext(SchoolBean schoolBean) {
            mainView.onNext(schoolBean);
        }

        @Override
        public void onNext2(ClasBean clasBean) {
            mainView.onNext1(clasBean);
        }

        @Override
        public void onError(String error) {
            mainView.onError(error);
        }

}
