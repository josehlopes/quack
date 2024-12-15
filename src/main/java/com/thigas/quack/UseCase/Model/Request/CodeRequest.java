package com.thigas.quack.UseCase.Model.Request;

public class CodeRequest {
    private String code;

    private String activity;

    public String getActivity(){return activity;}

    public void setActivity(String activity){this.activity=activity;}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
