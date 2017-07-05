public class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            if (validIPV4(IP)) {
                return "IPv4";
            }
        } else if (IP.contains(":")) {
            if (validIPV6(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }
    public boolean validIPV4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] elements = IP.split("\\.");
        if (elements.length != 4) {
            return false;
        }
        for (String s : elements) {
            if (s.length() > 3 || s.length() == 0 || !checkFormatV4(s) || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }
    public boolean checkFormatV4(String s) {
        for (char c : s.toCharArray()) {
            if (!(c <= '9' && c >= '0')) {
                return false;
            }
        }
        return true;
    }
    public boolean checkFormatV6(String s) {
        for (char c : s.toCharArray()) {
            if (!((c <= '9' && c >= '0') || (c <= 'f' && c >= 'a'))) {
            //    System.out.println(s);
                return false;
            }
        }
        return true;
    }
    public boolean validIPV6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        IP = IP.toLowerCase();
        String[] elements = IP.split(":");
       // System.out.println(elements.length);
        if (elements.length != 8) {
            return false;
        }
        for (String s : elements) {
            if (!checkFormatV6(s)) {
              //  System.out.println("1");
                return false;
            }
            if (s.length() > 4) {
              //  System.out.println("2");
                return false;
            }
            if (s.length() == 0) {
            //    System.out.println("3");
                return false;
            }
        }
        return true;
    }
}
