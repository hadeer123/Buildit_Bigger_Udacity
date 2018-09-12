package com.udacity.gradle.builditbigger;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    private static final String LOG_TAG = AsyncTaskTest.class.getName();
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);
    @Test
    public void testAsyncTask(){

        FetchJokeAsyncTask asyncTask = new FetchJokeAsyncTask(null);
        asyncTask.execute();
        String result = null;
        try {
            result = asyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        assertNotNull(result);
    }
}
