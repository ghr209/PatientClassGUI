private class DataValidator {
    public boolean isValidCPR(String cpr) {
        Boolean result = false;
        //Check the length
        if (cpr.length() == 11) {
            result = true;
        } else {
            return false;
        }
        //Check the format (two numbers)
        //First split the cpr number
        String birthday = cpr.substring(0, 6);
        Character hyphen = cpr.charAt(6);
        String lastNumber = cpr.substring(7, 11);
        try {//test if the first part is a number }
            int d = Integer.parseInt(birthday);
        } catch (NumberFormatException nfe) {
            System.out.println("First part is not a number");
            return false;
        }
        if (!hyphen.equals('-')) {
            System.out.println("Missing hyphen");
            return false;
        }
        ;
        try {//test if the last part is a number }
            int running = Integer.parseInt(lastNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Last part is a number");
            return false;
        }
        return result;
    }
    public boolean isValidNumber(String Number) {
        Boolean result = false;
        //Check the length
        if (Number.length() == 9) {
            result = true;
        } else {
            return false;
        }

        String Number = Number.substring(0, 9);
        try {//test if the first part is a number }
            int d = Integer.parseInt(Number);
        } catch (NumberFormatException nfe) {
            System.out.println(" phoneNumber is not a number");
            return false;
        }
        return result;
    }
    public boolean isValidEmail(String Address) {
        Character snabela = Address.charAt();
        if (!snabela.equals('@')) {
            System.out.println("Missing snabel a");
            return false;
        }
        Boolean result = false;
        //Check the length
        if (Address.length() <= 5) {
            result = true;
        } else {
            return false;
        }
        return result;
    }
}

