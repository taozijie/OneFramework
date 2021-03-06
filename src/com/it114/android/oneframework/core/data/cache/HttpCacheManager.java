package com.it114.android.oneframework.core.data.cache;

import com.it114.android.oneframework.core.data.db.HttpCacheTable;
import com.it114.android.oneframework.core.model.HttpCache;
import com.it114.android.oneframework.core.util.CacheUtil;

import com.loopj.android.http.RequestParams;

public class HttpCacheManager {

	public static void create(String url,  RequestParams params, String content) {
		HttpCache lastCache = get(url,params);
		if(lastCache !=null) {
			lastCache.content = content;
			lastCache.updateTime = System.currentTimeMillis();
			HttpCacheTable.insert(lastCache);
		} else {
			HttpCache cache=new HttpCache();
			cache.key = CacheUtil.makeKey(url, params);
			cache.params = (params==null)? "": params.toString();
			cache.content = content;
			cache.url = url;
			cache.updateTime = System.currentTimeMillis();
			HttpCacheTable.insert(cache);
		}
	}

	public static HttpCache get(String url, RequestParams params) {
		String key = CacheUtil.makeKey(url,params);
		return HttpCacheTable.get(key);
	}

	public  static void delete(String url, RequestParams params) {
		HttpCacheTable.delete(CacheUtil.makeKey(url,params));
	}

	public static void deleteByDate(int daysAgo){
		HttpCacheTable.deleteByDate(daysAgo);
	}

}
