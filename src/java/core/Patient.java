package core;
//Imports------------------------------------------------------
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.Size;
//Class--------------------------------------------------------
public class Patient {
//Fields-------------------------------------------------------
    private String      name;
    private String      surname;
    private String      address;
    private String      pesel;
    private String      phone;
    private int         weight;
    private int         height;
    private Date        regDate;
    private Date        birthDay;
    private String      regDateToShow;
    private String      birthDayToShow;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//Constructors-------------------------------------------------
    public Patient(){
    }

    public Patient(String name, String surname, String address, String pesel, String phone, int weight, int height, Date regDate, Date birthDay) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.pesel = pesel;
        this.phone = phone;
        this.weight = weight;
        this.height = height;
        this.regDate = regDate;
        this.birthDay = birthDay;
        this.regDateToShow = sdf.format(regDate);
        this.birthDayToShow = sdf.format(birthDay);
        
    }
//Methods------------------------------------------------------
//Getters and Setters------------------------------------------
    @Size(min = 2, max = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Size(min = 3, max = 20)
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    @Size(min = 5)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
  
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
  
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    
    public Date getBirthDay() {
        return birthDay;
    }

   
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return the regDateToShow
     */
    public String getRegDateToShow() {
        return regDateToShow;
    }

    /**
     * @param regDateToShow the regDateToShow to set
     */
    public void setRegDateToShow(String regDateToShow) {
        this.regDateToShow = regDateToShow;
    }

    /**
     * @return the birthDayToShow
     */
    public String getBirthDayToShow() {
        return birthDayToShow;
    }

    /**
     * @param birthDayToShow the birthDayToShow to set
     */
    public void setBirthDayToShow(String birthDayToShow) {
        this.birthDayToShow = birthDayToShow;
    }
}
