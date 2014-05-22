package com.prototest;

import com.echostar.dish_anywhere.eggplant_suite.androidphone.LockScreen;
import com.prototest.solanum.EggplantTestBase;
import com.prototest.solanum.Logger;
import com.prototest.solanum.TextOption;
import org.testng.annotations.Test;

/**
 * Created by andar on 5/19/14.
 */
public class Placeholder extends EggplantTestBase {
    @Test
    public void test()
    {
       TextOption option = TextOption.hotSpot(17,30);
        Logger.message(option.getText());
    }
}
