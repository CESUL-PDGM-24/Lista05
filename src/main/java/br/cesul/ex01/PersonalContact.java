package br.cesul.ex01;

public class PersonalContact extends Contact {

    private final String nickname;

    public PersonalContact(String name, String phone, String email, String address, String instagram, String nickname) {
        super(name, phone, email, address, instagram);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
