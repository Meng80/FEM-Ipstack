package es.upm.miw.ipstack;

import java.util.Objects;

public class IpHistory {
    private String mUid;
    private String mCity;
    private String mCountry;
    private String mZip;
    private String mRegion;

    public IpHistory() {
        //vacio
    }

    public IpHistory(String mUid, String mCity, String mCountry, String mZip, String mRegion) {
        this.mUid = mUid;
        this.mCity = mCity;
        this.mCountry = mCountry;
        this.mZip = mZip;
        this.mRegion = mRegion;
    }

    public String getmUid() {
        return mUid;
    }

    public void setmUid(String mUid) {
        this.mUid = mUid;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmZip() {
        return mZip;
    }

    public void setmZip(String mZip) {
        this.mZip = mZip;
    }

    public String getmRegion() {
        return mRegion;
    }

    public void setmRegion(String mRegion) {
        this.mRegion = mRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpHistory ipHistory = (IpHistory) o;
        return mUid.equals(ipHistory.mUid) && Objects.equals(mCity, ipHistory.mCity) && Objects.equals(mCountry, ipHistory.mCountry) && Objects.equals(mZip, ipHistory.mZip) && Objects.equals(mRegion, ipHistory.mRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mUid, mCity, mCountry, mZip, mRegion);
    }

    @Override
    public String toString() {
        return "IpHistory{" +
                "mUid='" + mUid + '\'' +
                ",\n\tmCity='" + mCity + '\'' +
                ",\n\tmCountry='" + mCountry + '\'' +
                ",\n\tmZip='" + mZip + '\'' +
                ",\n\tmRegion='" + mRegion + '\'' +
                "}";
    }
}
