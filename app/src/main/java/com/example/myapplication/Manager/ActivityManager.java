package com.example.myapplication.Manager;

import android.app.Activity;

import java.util.Stack;

public class ActivityManager {
    private static volatile ActivityManager mInstance;
    private Stack<Activity> activities;

    private ActivityManager() {
        activities = new Stack<>();
    }

    public static ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    public void attach(Activity activity) {
        activities.add(activity);
    }

    //    public void detach(Activity   detachactivity){
//        for (Activity activity : activities) {
//            if (activity == detachactivity){
//                activities.remove(activity);
//            }
//        }
//    }
//    public void finishAtivity(Class<? extends Activity>  ActivityClass){
//        for (Activity activity : activities) {
//            if (activity.getClass().getCanonicalName().equals(ActivityClass.getCanonicalName())){
//                activities.remove(activity);
//                activity.finish();
//            }
//        }
//    }
    public void detach(Activity detachActivity) {
        // for 去移除有没有问题？ 一边循环一边移除会出问题 ，
        // 既然这个写法有问题，自己又想不到什么解决方法，参考一下别人怎么写的
        /*for (Activity activity : mActivities) {
            if(activity == detachActivity){
                mActivities.remove(activity);
            }
        }*/
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activities.get(i);
            if (activity == detachActivity) {
                activities.remove(i);
                i--;
                size--;
            }
        }
    }

    public void finish(Activity finishActivity) {
        // for 去移除有没有问题？
        /*for (Activity activity : mActivities) {
            if(activity == finishActivity){
                mActivities.remove(activity);
                activity.finish();
            }
        }
*/
        int size = activities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activities.get(i);
            if (activity == finishActivity) {
                activities.remove(i);
                activity.finish();
                i--;
                size--;
            }
        }
    }

    /**
     * 根据Activity的类名关闭 Activity
     */
    public void finish(Class<? extends Activity> activityClass) {
        // for 去移除有没有问题？
        /*for (Activity activity : mActivities) {
            if(activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())){
                mActivities.remove(activity);
                activity.finish();
            }
        }*/

        int size = activities.size();
        for (int i = 0; i < size; i++) {
            Activity activity = activities.get(i);
            if (activity.getClass().getCanonicalName().equals(activityClass.getCanonicalName())) {
                activities.remove(i);
                activity.finish();
                i--;
                size--;
            }
        }
    }

    public void exitApplication() {

    }

    public Activity currentActivitu() {
        return activities.lastElement();
    }
}
