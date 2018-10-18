package com.frame.admin.model;

import java.util.Date;

public class OmResourceT {
    private String resourceId;

    private String resourceName;

    private String resourceUrl;

    private String resourcePid;

    private String resourcePname;

    private Byte resourceType;

    private Byte resourceStatus;

    private String resourceDesc;

    private Byte resourceSeq;

    private Date createDate;

    private String createEmp;

    private Date updateDate;

    private String updateEmp;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourcePid() {
        return resourcePid;
    }

    public void setResourcePid(String resourcePid) {
        this.resourcePid = resourcePid == null ? null : resourcePid.trim();
    }

    public String getResourcePname() {
        return resourcePname;
    }

    public void setResourcePname(String resourcePname) {
        this.resourcePname = resourcePname == null ? null : resourcePname.trim();
    }

    public Byte getResourceType() {
        return resourceType;
    }

    public void setResourceType(Byte resourceType) {
        this.resourceType = resourceType;
    }

    public Byte getResourceStatus() {
        return resourceStatus;
    }

    public void setResourceStatus(Byte resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public Byte getResourceSeq() {
        return resourceSeq;
    }

    public void setResourceSeq(Byte resourceSeq) {
        this.resourceSeq = resourceSeq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateEmp() {
        return createEmp;
    }

    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateEmp() {
        return updateEmp;
    }

    public void setUpdateEmp(String updateEmp) {
        this.updateEmp = updateEmp == null ? null : updateEmp.trim();
    }
}