package cn.luischen.model;

public class House {
    private String uid;

    private String price;

    private String housetype;

    private String blocktype;

    private String blockage;

    private String far;

    private String fee;

    private String pmanage;

    private String company;

    private String imgurl;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype == null ? null : housetype.trim();
    }

    public String getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(String blocktype) {
        this.blocktype = blocktype == null ? null : blocktype.trim();
    }

    public String getBlockage() {
        return blockage;
    }

    public void setBlockage(String blockage) {
        this.blockage = blockage == null ? null : blockage.trim();
    }

    public String getFar() {
        return far;
    }

    public void setFar(String far) {
        this.far = far == null ? null : far.trim();
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
    }

    public String getPmanage() {
        return pmanage;
    }

    public void setPmanage(String pmanage) {
        this.pmanage = pmanage == null ? null : pmanage.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }
}