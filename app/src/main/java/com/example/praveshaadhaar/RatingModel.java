package com.example.praveshaadhaar;

public class RatingModel {

    private String shopName;
    private String shopAddress;
    private String shopSanitation;
    private String maskUse;
    private String socialDistancing;
    private String recommended;
    private boolean expanded;

    public RatingModel(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopSanitation() {
        return shopSanitation;
    }

    public void setShopSanitation(String shopSanitation) {
        this.shopSanitation = shopSanitation;
    }

    public String getMaskUse() {
        return maskUse;
    }

    public void setMaskUse(String maskUse) {
        this.maskUse = maskUse;
    }

    public String getSocialDistancing() {
        return socialDistancing;
    }

    public void setSocialDistancing(String socialDistancing) {
        this.socialDistancing = socialDistancing;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }
}
