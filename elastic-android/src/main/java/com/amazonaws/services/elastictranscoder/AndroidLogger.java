package com.amazonaws.services.elastictranscoder;

import org.apache.commons.logging.Log;

/**
 * Created by kulik on 16.01.15.
 */
public class AndroidLogger implements Log {
    private final String mTag;

    public AndroidLogger(Class<AmazonElasticTranscoder> amazonElasticTranscoderClass) {
        mTag = amazonElasticTranscoderClass.getSimpleName();
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public boolean isFatalEnabled() {
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void trace(Object o) {
        android.util.Log.v(mTag, o.toString());
    }

    @Override
    public void trace(Object o, Throwable throwable) {
        android.util.Log.v(mTag, o.toString(), throwable);
    }

    @Override
    public void debug(Object o) {
        android.util.Log.d(mTag, o.toString());
    }

    @Override
    public void debug(Object o, Throwable throwable) {
        android.util.Log.d(mTag, o.toString(), throwable);
    }

    @Override
    public void info(Object o) {
        android.util.Log.i(mTag, o.toString());
    }

    @Override
    public void info(Object o, Throwable throwable) {
        android.util.Log.i(mTag, o.toString(), throwable);
    }

    @Override
    public void warn(Object o) {
        android.util.Log.w(mTag, o.toString());
    }

    @Override
    public void warn(Object o, Throwable throwable) {
        android.util.Log.w(mTag, o.toString(), throwable);
    }

    @Override
    public void error(Object o) {
        android.util.Log.e(mTag, o.toString());
    }

    @Override
    public void error(Object o, Throwable throwable) {
        android.util.Log.e(mTag, o.toString(), throwable);
    }

    @Override
    public void fatal(Object o) {
        android.util.Log.e(mTag, o.toString());
    }

    @Override
    public void fatal(Object o, Throwable throwable) {
        android.util.Log.e(mTag, o.toString(), throwable);
    }
}
