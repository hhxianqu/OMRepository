package cn.edu.nju.omrepository;

import de.felixroske.jfxsupport.SplashScreen;

public class CustomSplash extends SplashScreen {

    /**
     * 加载动画路径
     */
    @Override
    public String getImagePath() {
        return "/image/loader.jpg";
    }

    /**
     * 是否显示加载动画
     */
    @Override
    public boolean visible() {
        return super.visible();
    }
}
