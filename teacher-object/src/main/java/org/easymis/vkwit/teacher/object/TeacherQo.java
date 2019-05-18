package org.easymis.vkwit.teacher.object;
/**
 * Created by lenovo-t on 2019-05-16.
 */
public class TeacherQo extends PageQo implements java.io.Serializable{
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String phone;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Long getId() {
        return id;
    }
}
