package es.upm.miw.ipstack.model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Ipstack {
    @SerializedName("ip")
    @Expose
    public String ip;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("continent_code")
    @Expose
    public String continent_code;
    @SerializedName("continent_name")
    @Expose
    public String continent_name;
    @SerializedName("country_code")
    @Expose
    public String country_code;
    @SerializedName("country_name")
    @Expose
    public String country_name;
    @SerializedName("region_code")
    @Expose
    public String region_code;
    @SerializedName("region_name")
    @Expose
    public String region_name;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("zip")
    @Expose
    public String zip;
    @SerializedName("latitude")
    @Expose
    public Double latitude;
    @SerializedName("longitude")
    @Expose
    public Double longitude;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("languages")
    @Expose
    public String languages;
    @SerializedName("country_flag")
    @Expose
    public String country_flag;
    @SerializedName("country_flag_emoji")
    @Expose
    public String country_flag_emoji;
    @SerializedName("country_flag_emoji_unicode")
    @Expose
    public String country_flag_emoji_unicode;
    @SerializedName("calling_code")
    @Expose
    public String calling_code;
    @SerializedName("is_eu")
    @Expose
    public Boolean is_eu;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContinent_code() {
        return continent_code;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public void setCountry_flag(String country_flag) {
        this.country_flag = country_flag;
    }

    public String getCountry_flag_emoji() {
        return country_flag_emoji;
    }

    public void setCountry_flag_emoji(String country_flag_emoji) {
        this.country_flag_emoji = country_flag_emoji;
    }

    public String getCountry_flag_emoji_unicode() {
        return country_flag_emoji_unicode;
    }

    public void setCountry_flag_emoji_unicode(String country_flag_emoji_unicode) {
        this.country_flag_emoji_unicode = country_flag_emoji_unicode;
    }

    public String getCalling_code() {
        return calling_code;
    }

    public void setCalling_code(String calling_code) {
        this.calling_code = calling_code;
    }

    public Boolean getIs_eu() {
        return is_eu;
    }

    public void setIs_eu(Boolean is_eu) {
        this.is_eu = is_eu;
    }
}
