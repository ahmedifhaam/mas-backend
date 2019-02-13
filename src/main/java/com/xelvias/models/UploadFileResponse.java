package com.xelvias.models;

import java.io.Serializable;

public class UploadFileResponse implements Serializable {
    private String fileName;
    private boolean dbupdatedsuccessfully;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, boolean dbupdatedsuccessfully, String fileType, long size) {
        this.fileName = fileName;
        this.dbupdatedsuccessfully = dbupdatedsuccessfully;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDbupdatedsuccessfully() {
        return dbupdatedsuccessfully;
    }

    public void setDbupdatedsuccessfully(boolean dbupdatedsuccessfully) {
        this.dbupdatedsuccessfully = dbupdatedsuccessfully;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
