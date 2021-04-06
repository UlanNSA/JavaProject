package task4;

import java.util.ArrayList;


public class Teacher extends User {
    private String nickName;
    private String status;
    private ArrayList<String> subjects = new ArrayList<>();

    public Teacher() {
    }


    public Teacher(int id, String login, String password, String nickName, String status, ArrayList<String> subjects) {
        super(id, login, password);
        this.nickName = nickName;
        this.status = status;
        this.subjects = subjects;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public void addSubject (String subject){
        subjects.add(subject);
    }
    @Override
    public String getUserData() {
        return "Id: "+getId()+"\n"+
                "Login: "+getLogin()+"\n"+
                "Password: "+getPassword()+"\n"+
                "Nick Name: "+getNickName()+"\n"+
                "Status: "+getStatus()+"\n"+
                "Subject: "+getSubjects()+"\n";

    }
}