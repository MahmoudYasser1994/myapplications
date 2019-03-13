
package com.example.daleel.Models.CompaniesModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("phone_number")
    @Expose
    private Object phoneNumber;
    @SerializedName("res_name")
    @Expose
    private Object resName;
    @SerializedName("mobile_number")
    @Expose
    private Object mobileNumber;
    @SerializedName("whatsapp_number")
    @Expose
    private Object whatsappNumber;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @SerializedName("mohafza_id")
    @Expose
    private String mohafzaId;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("zone_id")
    @Expose
    private String zoneId;
    @SerializedName("section_id")
    @Expose
    private String sectionId;
    @SerializedName("tasnif_id")
    @Expose
    private String tasnifId;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("mohafza")
    @Expose
    private Mohafza mohafza;
    @SerializedName("zone")
    @Expose
    private Zone zone;
    @SerializedName("section")
    @Expose
    private Section section;
    @SerializedName("tasnif")
    @Expose
    private Tasnif tasnif;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Object getResName() {
        return resName;
    }

    public void setResName(Object resName) {
        this.resName = resName;
    }

    public Object getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Object getWhatsappNumber() {
        return whatsappNumber;
    }

    public void setWhatsappNumber(Object whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getMohafzaId() {
        return mohafzaId;
    }

    public void setMohafzaId(String mohafzaId) {
        this.mohafzaId = mohafzaId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getTasnifId() {
        return tasnifId;
    }

    public void setTasnifId(String tasnifId) {
        this.tasnifId = tasnifId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Mohafza getMohafza() {
        return mohafza;
    }

    public void setMohafza(Mohafza mohafza) {
        this.mohafza = mohafza;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Tasnif getTasnif() {
        return tasnif;
    }

    public void setTasnif(Tasnif tasnif) {
        this.tasnif = tasnif;
    }

}
