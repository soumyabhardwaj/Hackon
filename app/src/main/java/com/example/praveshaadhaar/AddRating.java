package com.example.praveshaadhaar;

public class AddRating {
    private String phone;

    private Long sanitation;

    private Long socialDistancing;

    private String name;

    private String address;

    private Long maskUse;

    public AddRating(String phone, Long sanitation, Long socialDistancing, String name, String address, Long maskUse) {
        this.phone = phone;
        this.sanitation = sanitation;
        this.socialDistancing = socialDistancing;
        this.name = name;
        this.address = address;
        this.maskUse = maskUse;
    }

}