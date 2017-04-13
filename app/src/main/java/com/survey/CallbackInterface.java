package com.survey;

/**
 * Created by Purnendu Mishra on 4/13/2017.
 */

public interface CallbackInterface {
    public void onSuccess(FamilyMemberDetail memberDetail);
    public void onFailure(String Message);

}
