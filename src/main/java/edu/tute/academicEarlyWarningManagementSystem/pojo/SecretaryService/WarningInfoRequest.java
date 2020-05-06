package edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService;

public class WarningInfoRequest {
    private String userName;
    private String name;
    private String warningReason;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarningReason() {
        return warningReason;
    }

    public void setWarningReason(String warningReason) {
        this.warningReason = warningReason;
    }
}
