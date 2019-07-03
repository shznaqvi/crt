package edu.aku.hassannaqvi.cbtfollowup.validation;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Created by irfansyed on 3/28/2017.
 * Modified by SAJID LATIF on 21/06/2019.
 */

public class ClearAllcontrol {


    public static void ClearAll(LinearLayout lv) {

        /// Checkbox Celar*************************************

        try {

            for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                View view = lv.getChildAt(i);
                if (view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);

                } else if (view instanceof RadioGroup) {
                    ((RadioGroup) view).clearCheck();
                } else if (view instanceof EditText) {
                    ((EditText) view).setText("");

                } else if (view instanceof CardView) {
                    for (int j = 0; j < ((CardView) view).getChildCount(); j++) {
                        View view1 = ((CardView) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            ClearAll((LinearLayout) view1);
                        }
                    }
                } else if (view instanceof LinearLayout) {
                    ClearAll((LinearLayout) view);
                }

            }
        } catch (Exception e) {

        }


    }


    public static void ClearAllC(CardView cv) {

        /// Checkbox Clear*************************************

        try {

            for (int i = 0, count = cv.getChildCount(); i < count; ++i) {
                View view = cv.getChildAt(i);
                if (view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);

                } else if (view instanceof RadioGroup) {
                    ((RadioGroup) view).clearCheck();
                } else if (view instanceof EditText) {
                    ((EditText) view).setText("");

                } else if (view instanceof CardView) {
                    for (int j = 0; j < ((CardView) view).getChildCount(); j++) {
                        View view1 = ((CardView) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            ClearAll((LinearLayout) view1);
                        }
                    }
                } else if (view instanceof CardView) {
                    ClearAllC((CardView) view);
                }

            }
        } catch (Exception e) {

        }


    }
}
