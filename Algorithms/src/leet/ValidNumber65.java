/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leet;

/**
 * @author akrishnaniyer
 */
public class ValidNumber65 {

    public static void main(String[] args) {
        System.out.println(new ValidNumber65().isNumber("1 "));
    }

    public boolean isNumber(String s) {
        boolean retval = true;

        if (".".equals(s))
            return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!((c >= 48 && c <= 57) || c == 46)) {
                return false;
            }
        }
        return retval && s.trim().length() > 0;
    }
}
