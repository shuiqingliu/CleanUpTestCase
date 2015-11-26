package com.shuiqingliu.cleantestcase;

import android.os.RemoteException;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by qingliu on 11/26/15.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class WandouTest extends UiAutomatorTestCase{

    private UiDevice mUiDevice;
    private boolean isOK;

    @Test
    public void testDemo() throws UiObjectNotFoundException, RemoteException {
        //点击home
        mUiDevice = getUiDevice().getInstance();
        mUiDevice.pressHome();
        UiObject Apps = new UiObject(new UiSelector().description("Apps"));
        Apps.click();
        //进入急速清理应用

        UiScrollable listScrollable = new UiScrollable(new UiSelector().scrollable(true));
        listScrollable.scrollDescriptionIntoView("极速清理");
        UiObject cleanSpeed = new UiObject(new UiSelector().text("极速清理"));
        cleanSpeed.clickAndWaitForNewWindow();

        UiObject actionButton = new UiObject(new UiSelector().resourceId("com.fastclean:id/action_button"));
        //判断清理按钮是否存在
        if (actionButton.waitForExists(20000)) {
            actionButton.click();
            getUiDevice().pressBack();
        }
            //当弹出添加桌面快捷方式的处理
            UiObject noAgree = new UiObject(new UiSelector().text("不用了"));
            if (noAgree.exists()) {
                noAgree.click();
                getUiDevice().getInstance().pressHome();
                isOK = true;
            }

        getUiDevice().getInstance().pressRecentApps();
        //结束到清理进程
        UiObject killCleanApp = new UiObject(new UiSelector().description("Dismiss 极速清理."));
        if (killCleanApp.waitForExists(5000)){
            killCleanApp.click();
            getUiDevice().getInstance().pressHome();
        }
    }
}
