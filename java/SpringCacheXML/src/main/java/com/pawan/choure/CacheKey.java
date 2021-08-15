package com.pawan.choure;

public class CacheKey {
    private Integer intValue;
    private String stringValue;

    public CacheKey(Integer intValue, String stringValue) {
        this.intValue=intValue;
        this.stringValue=stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CacheKey cacheKey = (CacheKey) o;

        if (!intValue.equals(cacheKey.intValue)) return false;
        return stringValue.equals(cacheKey.stringValue);
    }

    @Override
    public int hashCode() {
        int result = intValue.hashCode();
        result = 31 * result + stringValue.hashCode();
        return result;
    }
}
