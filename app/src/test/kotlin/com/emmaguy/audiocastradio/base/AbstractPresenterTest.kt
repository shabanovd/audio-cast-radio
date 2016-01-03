package com.emmaguy.audiocastradio.base

import android.support.annotation.CallSuper
import org.junit.Before
import org.mockito.MockitoAnnotations

abstract class AbstractPresenterTest<P : AbstractPresenter<V>, V : AbstractPresenter.View> {
    protected var presenter: AbstractPresenter<V>? = null;
    private var view: V? = null;

    @CallSuper @Before fun before() {
        MockitoAnnotations.initMocks(this);

        presenter = createPresenter();
        view = createView();
    }

    protected abstract fun createPresenter(): P;
    protected abstract fun createView(): V;

    protected fun getView(): V {
        return view!!
    }

    protected fun presenterOnAttachView() {
        presenter!!.onAttachView(view!!)
    }

    protected fun presenterOnDetachView() {
        presenter!!.onDetachView()
    }
}