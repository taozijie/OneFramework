package com.it114.android.oneframework.core.http;

import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 *
 */
public class SafeHandler {
    public static <E> void onFailure (HttpRequestHandler<E> handler, String error){
        try{
            handler.onFailure(error);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <E> void  onSuccess(HttpRequestHandler<E> handler, E data){
        try{
            handler.onSuccess(data);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static <E> void  onSuccess(HttpRequestHandler<E> handler, E data, int totalPages, int currentPage){
        try{
            handler.onSuccess(data, totalPages, currentPage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
