package es.upm.miw.ipstack.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.intellij.lang.annotations.Language;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Location {

    @SerializedName("geoname_id")
    @Expose
    public Double geoname_id;

    @SerializedName("capital")
    @Expose
    public String capital;

    @SerializedName("languages")
    @Expose
    public Language languages;

    public Double getGeoname_id() {
        return geoname_id;
    }

    public void setGeoname_id(Double geoname_id) {
        this.geoname_id = geoname_id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }
}
