package models;

// import java.util.Date;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String mobileNumber;
    // private Date dateOfBirth;
    private String bio;
    private String gender;
    // private Date joinedAt;
    private int followers;
    private int followings;

    public User(String fullName, String username, String email, String mobileNumber, String bio,
            String gender, int followers, int followings) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.bio = bio;
        this.gender = gender;
        this.followers = followers;
        this.followings = followings;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // public Date getDateOfBirth() {
    // return dateOfBirth;
    // }

    // public void setDateOfBirth(Date dateOfBirth) {
    // this.dateOfBirth = dateOfBirth;
    // }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // public Date getJoinedAt() {
    // return joinedAt;
    // }

    // public void setJoinedAt(Date joinedAt) {
    // this.joinedAt = joinedAt;
    // }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowings() {
        return followings;
    }

    public void setFollowings(int followings) {
        this.followings = followings;
    }

    public String getObjecString() {
        return "{\n" +
                "full name : " + this.fullName + ",\n" +
                "username : " + this.username + ",\n" +
                "email : " + this.email + ",\n" +
                "mobile number : " + this.mobileNumber + ",\n" +
                // "date of birth : " + this.dateOfBirth + ",\n" +
                "bio : " + this.bio + ",\n" +
                "gender : " + this.gender + ",\n" +
                "followings : " + this.followings + ",\n" +
                "followers : " + this.followers + ",\n" +
                // "joined at : " + this.joinedAt + ",\n" +
                "}";
    }

}
