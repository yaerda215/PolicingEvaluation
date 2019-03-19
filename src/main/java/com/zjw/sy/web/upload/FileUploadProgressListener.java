package com.zjw.sy.web.upload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

/**
 * Description 文件上传进度监听
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:35:24
 */
@Component
public class FileUploadProgressListener implements ProgressListener {

    private HttpSession session;

    @Override
    public void update(long bytesRead, long contentLength, int items) {
        //设置上传进度
        ProgressBean progress = new ProgressBean(bytesRead, contentLength, items);
        //将上传进度保存到session中
        session.setAttribute("progress", progress);
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

}