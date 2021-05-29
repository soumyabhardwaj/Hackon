package com.example.praveshaadhaar;

public class FetchData {

    String NoMask;
    String Mask;
    String CamNo;

    public FetchData(String NoMask, String Mask,String CamNo) {

        this.NoMask = NoMask;
        this.Mask = Mask;
        this.CamNo = CamNo;
    }
    public String getNoMask() {
        return NoMask;
    }

    public String getMask() {
        return Mask;
    }

    public String getCamNo(){return CamNo;}


    public void setDate(String date) {
        NoMask = date;
    }

    public void setMask(String mask) {
        Mask = mask;
    }

    public String setCamNo(){return CamNo;}
}