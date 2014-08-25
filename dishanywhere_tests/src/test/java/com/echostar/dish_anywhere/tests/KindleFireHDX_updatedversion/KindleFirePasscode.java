package com.echostar.dish_anywhere.tests.KindleFireHDX_updatedversion;

import com.echostar.dish_anywhere.screenobjects.kindleTablet.kindleFire.DishAnywhereHome;
import com.prototest.solanum.SolanumRetryAnalyzer;
import com.prototest.solanum.Verifications;
import org.testng.annotations.Test;

/**
 * Created by Brian on 6/4/2014.
 */
public class KindleFirePasscode extends KindleTestBase {
    @Test(retryAnalyzer = SolanumRetryAnalyzer.class)
    public void movieCategory(){

        new DishAnywhereHome()
                .openSettings()
                .openParentalControls("1111")
                .changePasscode("0000")
                .openAuthorizedDevices()
                .openParentalControls("0000")
                .changePasscode("1111");


        Verifications.assertVerifications();


    }
}
