package com.example.rti.dto;

public class LoginResponse {
    private String result;
    private String resulttype;
    private Integer sessionuser;
    private String sessiontype;

    public LoginResponse() { }
    public LoginResponse(String result, String resulttype,
                         Integer sessionuser, String sessiontype) {
        this.result = result;
        this.resulttype = resulttype;
        this.sessionuser = sessionuser;
        this.sessiontype = sessiontype;
    }

    // Getters & Setters
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getResulttype() { return resulttype; }
    public void setResulttype(String resulttype) { this.resulttype = resulttype; }
    public Integer getSessionuser() { return sessionuser; }
    public void setSessionuser(Integer sessionuser) { this.sessionuser = sessionuser; }
    public String getSessiontype() { return sessiontype; }
    public void setSessiontype(String sessiontype) { this.sessiontype = sessiontype; }
}
