package pl.dn.user.validation;

public class ValidationPatterns {

    private String name = "^[^{null}|\\s]*[\\p{L}]+[-]*[\\p{L}]+$";
    private String nameStartGreat = "^[^{null}|\\s]+[\\p{L}]+([-|\\s]+[A-Z]+)*[\\p{L}]+$";
    private String zipCode = "^[0-9]{2}-[0-9]{3}$";
    private String number = "^[0-9]{1,3}[a-zA-Z]{0,2}$";
    private String phoneNumber = "^[0-9]+$";
    private String pesel = "^[0-9]{11}$";
    private String email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

}