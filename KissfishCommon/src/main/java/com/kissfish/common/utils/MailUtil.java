package com.kissfish.common.utils;

/**
 * Created by todd on 2016/12/21.
 * @author todd
 */
public class MailUtil {
    /**
     * Check-up the validity of the email address.
     *
     * @param email email address
     * @return true if the email address is valid; false otherwise.
     */
    public static boolean isValidMail(String email) {
        boolean checkedStatus = true;
        boolean atLet = false;
        boolean pointLet = false;
        int atPs = -1;
        int strLength = email.length() - 1;
        email = email.toUpperCase();

        for (int i = 0; i <= strLength; i++) {

            char ch = email.charAt(i);
            if ((ch < 'A' || ch > 'Z') && (ch < '0' || ch > '9')) {

                switch (ch) {

                    case '@': {
                        if (i == 0 || i == strLength || atLet) {
                            checkedStatus = false;
                        }
                        atLet = true;
                        atPs = i;
                        break;
                    }

                    case '.': {
                        if (i == 0 || i == strLength || i == atPs + 1
                                || i == atPs - 1) {
                            checkedStatus = false;
                        }
                        pointLet = true;
                        break;
                    }

                    case '_':

                    case '-': {
                        if (i == 0 || i == strLength) {
                            checkedStatus = false;
                        }
                        break;
                    }

                    default:
                        checkedStatus = false;
                        break;
                }
            }

            if (!checkedStatus) {
                break;
            }
        }

        checkedStatus = checkedStatus & pointLet & atLet;
        return checkedStatus;
    }
}
