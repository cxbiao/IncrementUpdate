package com.bryan.incrementupdate;

/**
 * Author：Cxb on 2016/10/13 15:18
 */

public class BsPatch  {

    static {
        System.loadLibrary("bspatch");
    }

    /**
     * 合并增量文件
     * @param oldFilePath 当前APK路径
     * @param newFilePath 合成后的新的APK路径
     * @param patchFilePath 增量文件路径
     */
    public static native void bspatch(String oldFilePath,String newFilePath,String patchFilePath) ;
}
