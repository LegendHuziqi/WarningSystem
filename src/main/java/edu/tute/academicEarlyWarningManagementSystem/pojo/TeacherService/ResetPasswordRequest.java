package edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService;

public class ResetPasswordRequest {
    private String teacherUserName;
    private String userName;
    private String option;

    public String getTeacherUserName() {
        return teacherUserName;
    }

    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
