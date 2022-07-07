package cn.bj.domain;

public class MyStudent {
    private Integer myId;
    private String myName;
    private String myEmail;
    private Integer myAge;

    @Override
    public String toString() {
        return "MyStudent{" +
                "myId=" + myId +
                ", myName='" + myName + '\'' +
                ", myEmail='" + myEmail + '\'' +
                ", myAge=" + myAge +
                '}';
    }

    public Integer getMyId() {
        return myId;
    }

    public void setMyId(Integer myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public Integer getMyAge() {
        return myAge;
    }

    public void setMyAge(Integer myAge) {
        this.myAge = myAge;
    }
}
