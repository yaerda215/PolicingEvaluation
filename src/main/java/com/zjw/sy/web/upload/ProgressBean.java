package com.zjw.sy.web.upload;

/**
 * Description 文件上传进度Bean
 *
 * @author ZhengJiawei
 * @date 2019-03-19 09:36:04
 */
public class ProgressBean {

    private long bytesRead;

    private long contentLength;

    private long items;

    public ProgressBean(long bytesRead, long contentLength, long items) {
        super();
        this.bytesRead = bytesRead;
        this.contentLength = contentLength;
        this.items = items;
    }

    public long getBytesRead() {
        return bytesRead;
    }

    public void setBytesRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }

    public long getItems() {
        return items;
    }

    public void setItems(long items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ProgressBean [bytesRead=" + bytesRead + ", contentLength="
                + contentLength + ", items=" + items + "]";
    }

}