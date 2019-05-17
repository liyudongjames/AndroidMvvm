package com.example.liyudong.mvvm.viewmodel;import androidx.lifecycle.LiveData;import androidx.lifecycle.MutableLiveData;import androidx.lifecycle.ViewModel;import com.example.liyudong.mvvm.net.BaseSubscribe;import com.example.liyudong.mvvm.net.bean.BaseBean;import com.example.liyudong.mvvm.net.bean.PublicArticalListBean;import com.example.liyudong.mvvm.net.repository.ArticleListRepository;import java.util.List;public class ArticleListViewModel extends ViewModel {    private BaseSubscribe<List<PublicArticalListBean>> articalListSubscribe;    private ArticleListRepository repository;    public ArticleListViewModel(ArticleListRepository repository) {        this.repository = repository;        articalListSubscribe = new BaseSubscribe<>();    }    public LiveData<BaseBean<List<PublicArticalListBean>>> getPublicArticalListLiveData() {        return articalListSubscribe.getDatas();    }    public void getArtical() {        repository.getArticles()                .subscribe(articalListSubscribe);    }}