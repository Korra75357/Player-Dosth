package com.example.hp.play_signup;

/**
 * Created by HP on 19-12-2017.
 */

public class UserInformation {
    public String Name ;
    public String Branch ;
    public String MobileNo ;
    public String Programme ;
    public String FbId;
   public  UserInformation (){

    }

    public UserInformation(String Name,String mobileNo,String branch ,String fbId,String programme) {
        this.Name=Name;
        this.MobileNo=mobileNo;
        this.Branch = branch;
        this.FbId=fbId;
        this.Programme=programme;
    }

}

