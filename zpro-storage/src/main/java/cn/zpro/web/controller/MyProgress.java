package cn.zpro.web.controller;

import org.apache.commons.fileupload.ProgressListener;

/**
 * 上传进度监听
 * @author dell
 */
public class MyProgress implements ProgressListener {

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        System.out.println("We are currently reading item " + pItems);
        if (pContentLength == -1) {
            System.out.println("So far, " + pBytesRead + " bytes have been read.");
        } else {
            System.out.println("So far, " + pBytesRead + " of " + pContentLength
                    + " bytes have been read.");
        }
    }
}
