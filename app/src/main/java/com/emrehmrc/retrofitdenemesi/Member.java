package com.emrehmrc.retrofitdenemesi;

public class Member {
    private String ID;
    private String NAME;
    private String SURNAME;
    private String EMAIL;

    public String getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getSURNAME() {
        return SURNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getPASSWORDRESETCODE() {
        return PASSWORDRESETCODE;
    }

    private String PASSWORD ;
    private String PASSWORDRESETCODE;
}
