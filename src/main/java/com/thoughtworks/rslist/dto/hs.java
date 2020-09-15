package com.thoughtworks.rslist.dto;

public class hs {
    private String hs_name;
    private String key;

    public hs() {
    }

    public hs(String hs_name, String key) {
        this.hs_name = hs_name;
        this.key = key;
    }

    public String getHs_name() {
        return hs_name;
    }

    public void setHs_name(String hs_name) {
        this.hs_name = hs_name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
