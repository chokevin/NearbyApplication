package com.google.android.gms.nearby.messages.samples.nearbydevices;

/**
 * Created by kevincho on 2/22/17.
 */

public class NearbyAccount {


    public static void newNearbyAccount(String login, int id) {
        NearbyAccount nearbyAccount = new NearbyAccount(login, id);
    }


    public static NearbyAccount fromNearbyAccount(String login, int id){ return new NearbyAccount(login, id); }


    private NearbyAccount(String login, int id) {
        loginID = login;
        idnumber = id;
    }

    protected String getLoginID() { return loginID; }
    protected int getIdnumber() { return idnumber; }

    private String loginID;
    private int idnumber;
}
