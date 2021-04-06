package sample.model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class User implements Serializable {
    private String key = "meow";
    private String login;
    private int password;
    private String name;
    private String lastName;
    private String email;
    private boolean card;
    private byte[] numberCard;

    public User(String login, String password, String name, String lastName, String email,String numberCard) {
        this.login = login;
        this.password=password.hashCode();
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.card = true;
        this.numberCard=encode(numberCard);

    }
    public User(String login, String password, String name, String lastName, String email) {
        this.login = login;
        this.password=password.hashCode();
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.card = false;
        this.numberCard = null;

    }

    public boolean isCard() {
        return card;
    }

    public void setCard(boolean card) {
        this.card = card;
    }

    public String getNumberCard() {
        return decode(this.numberCard);
    }


    public void setNumberCard(String numberCard) {
        this.numberCard = encode(numberCard);;
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private byte[] encode(String password) { //дешифровка пароля
        byte[] bPassword = password.getBytes(StandardCharsets.UTF_8);
        byte[] bKey = this.key.getBytes(StandardCharsets.UTF_8);

        byte[] rezultPassword = new byte[password.length()];
        for (int i = 0; i < bPassword.length; i++) {
            rezultPassword[i]=(byte) (bPassword[i]^bKey[i%bKey.length]);
        }
        return rezultPassword;
    }

    private String decode (byte[] bPassword) { //шифровка пароля
        byte[] rezultPassword = new byte[bPassword.length];
        byte[] bKey = this.key.getBytes(StandardCharsets.UTF_8);

        for (int i = 0; i < bPassword.length; i++) {
            rezultPassword[i] = (byte) (bPassword[i] ^ bKey[i % bKey.length]);
        }
        String password = new String(rezultPassword);
        return password;
    }
}
