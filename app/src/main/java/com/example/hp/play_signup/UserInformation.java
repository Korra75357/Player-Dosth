package com.example.hp.play_signup;

/**
 * Created by HP on 19-12-2017.
 */

public class UserInformation {
    public String AName ;
    public String Branch ;
    public String dMobileNo ;
    public String cProgramme ;
    public String eFbId;
   public  UserInformation (){

    }

    public UserInformation(String Name,String mobileNo,String branch ,String fbId,String programme) {
        this.AName=Name;
        this.dMobileNo=mobileNo;
        this.Branch = branch;
        this.eFbId=fbId;
        this.cProgramme=programme;
    }
}

