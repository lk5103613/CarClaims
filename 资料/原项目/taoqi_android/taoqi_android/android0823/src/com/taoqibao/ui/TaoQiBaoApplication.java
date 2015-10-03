package com.taoqibao.ui;

import java.util.LinkedHashSet;
import java.util.Set;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class TaoQiBaoApplication  extends Application {
	private static Set<Activity> mList = new LinkedHashSet<Activity>(); 
	public static void addActivity(Activity activity) { 
        mList.add(activity); 
    } 
	public static void removeActivity(Activity activity){ 
		 mList.remove(activity); 

    } 
	public static void exit() { 
        try { 
            for (Activity activity : mList) { 
                if (activity != null) 
                    activity.finish(); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            System.exit(0); 
        } 
    } 
	public static void clearPage() { 
        try { 
            for (Activity activity : mList) { 
                if (activity != null) 
                    activity.finish(); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
	
	@Override
    public void onCreate() {
     
    	
	    super.onCreate();
	 
	
	    
	    initImageLoader(getApplicationContext());
	    ///////////////////////////
	 
 
	}
	  public static void initImageLoader(Context context) {
			// This configuration tuning is custom. You can tune every option, you may tune some of them,
			// or you can create default configuration by
			//  ImageLoaderConfiguration.createDefault(this);
			// method.
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
					.threadPriority(Thread.NORM_PRIORITY - 2)
					.denyCacheImageMultipleSizesInMemory()
					.memoryCache(new WeakMemoryCache())
					.diskCacheFileNameGenerator(new Md5FileNameGenerator())
					.tasksProcessingOrder(QueueProcessingType.LIFO)
					.writeDebugLogs() // Remove for release app
					.build();
			// Initialize ImageLoader with configuration.
			ImageLoader.getInstance().init(config);
		}
	  
	  public synchronized static TaoQiBaoApplication getInstance() { 
	        if (null == mInstance) { 
	        	mInstance = new TaoQiBaoApplication(); 
	        } 
	        return mInstance; 
	    } 
	  private static TaoQiBaoApplication mInstance = null;

}
