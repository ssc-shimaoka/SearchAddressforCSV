package com.example.searchaddress;

public class AddressItem {
    //private int _id;
    private String NationalLocalGovernmentCode;
    private String PostalCode_Old;
    private String PostalCode;
    private String NameOfPrefectures_Kana;
    private String CityName_Kana;
    private String TownName_Kana;
    private String NameOfPrefectures;
    private String CityName;
    private String TownName;
    private String otther1;
    private String otther2;
    private String otther3;
    private String otther4;
    private String ViewUpdates;
    private String ReasonForChange;

    //public void set_id(int _id) {this._id = _id;}
    //public int get_id(){return this._id;}

    public void setNationalLocalGovernmentCode(String NationalLocalGovernmentCode) {this.NationalLocalGovernmentCode = NationalLocalGovernmentCode; }
    public String getNationalLocalGovernmentCode(){
        return this.NationalLocalGovernmentCode;
    }

    public void setPostalCode_Old(String PostalCode_Old) {
        this.PostalCode_Old = PostalCode_Old;
    }
    public String getPostalCode_Old(){
        return this.PostalCode_Old;
    }

    public void setPostalCode(String PostalCode) { this.PostalCode = PostalCode; }
    public String getPostalCode(){
        return this.PostalCode;
    }

    public void setNameOfPrefectures_Kana(String NameOfPrefectures_Kana) { this.NameOfPrefectures_Kana = NameOfPrefectures_Kana; }
    public String getNameOfPrefectures_Kana(){
        return this.NameOfPrefectures_Kana;
    }

    public void setCityName_Kana(String CityName_Kana) { this.CityName_Kana = CityName_Kana; }
    public String getCityName_Kana(){ return this.CityName_Kana; }

    public void setTownName_Kana(String TownName_Kana) { this.TownName_Kana = TownName_Kana; }
    public String getTownName_Kana(){ return this.TownName_Kana; }

    public void setNameOfPrefectures(String NameOfPrefectures) { this.NameOfPrefectures = NameOfPrefectures; }
    public String getNameOfPrefectures(){ return this.NameOfPrefectures; }

    public void setCityName(String CityName) { this.CityName = CityName; }
    public String getCityName(){ return this.CityName; }

    public void setTownName(String TownName) { this.TownName = TownName; }
    public String getTownName(){ return this.TownName; }

    public void setotther1(String otther1) { this.otther1 = otther1; }
    public String getotther1(){ return this.otther1; }

    public void setotther2(String otther2) { this.otther2 = otther2; }
    public String getotther2(){ return this.otther2; }

    public void setotther3(String otther3) { this.otther3 = otther3; }
    public String getotther3(){ return this.otther3; }

    public void setotther4(String otther4) { this.otther4 = otther4; }
    public String getotther4(){ return this.otther4; }

    public void setViewUpdates(String ViewUpdates) { this.ViewUpdates = ViewUpdates; }
    public String getViewUpdates(){ return this.ViewUpdates; }

    public void setReasonForChange(String ReasonForChange) { this.ReasonForChange = ReasonForChange; }
    public String getReasonForChange(){ return this.ReasonForChange; }

}
