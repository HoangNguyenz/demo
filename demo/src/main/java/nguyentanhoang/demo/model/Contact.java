package nguyentanhoang.demo.model;

public class Contact {
    //Khai báo các thuộc tính
    private String name;
    private String email;
    private String message;
    public Contact() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Contact(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

//Phương thức getters, setters, khởi tạo, tự tạo (SV tự hoàn thiện)
}