package com.foobnix.pdf.info;

import android.app.Activity;

import com.foobnix.android.utils.LOG;
import com.foobnix.ui2.MainTabs2;

public class MyADSProvider {

    public int intetrstialTimeout = 0;
    private Activity a;

    public void createHandler() {
        try {
            Class.forName("android.os.AsyncTask");
        } catch (Throwable ignore) {
        }
    }

    public void activate(final Activity a, boolean withInterstitial, final Runnable finish) {
        this.a = a;

        if (AppsConfig.checkIsProInstalled(a)) {
            LOG.d("PRO is installed or beta");
            return;
        }

        if (!AppsConfig.ADS_ON_PAGE && !(a instanceof MainTabs2)) {
            LOG.d("Skip ads in the book");
            return;
        }
    }

    public boolean showInterstial() {
        return false;
    }

    public void destroy() {
        a = null;
    }

}
