package core;
//Imports---------------------------
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;


@SessionScoped
@ManagedBean(name = "patientBean")
public class PatientBean implements Serializable{
//Fields-------------------------
    private static final long serialVersionUID = 1L;
    
    private Patient patient = new Patient();
    
    private ListDataModel<Patient> patients = new ListDataModel<Patient>();
    
  
    
    @Inject
    private PatientManager patientManager;
//Methods------------------------------------------------------
   public Patient getPatient(){
       return patient;
   }
   public void setPatient(Patient patient){
       this.patient = patient;
   } 
  
   public ListDataModel<Patient> getAllPatients(){
       return patients;
   }
   public String addExamplePatients(){
       patientManager.addExamplePatients();
       return "homePage.xhtml";
   }
    public String addPatient(){
       patientManager.addPatient(getPatient());
       clearPatient();
       return "search.xhtml";
    }
    public void clearPatient(){
        getPatient().setName("");
        getPatient().setSurname("");
        getPatient().setPesel("");
        getPatient().setBirthDay(null);
        getPatient().setAddress("");
        getPatient().setPhone(null);
        getPatient().setWeight(0);
        getPatient().setHeight(0);
    }
//Getters and Setters------------------------------------------
    public ListDataModel<Patient> getPatients() {
        patients.setWrappedData(patientManager.getAllPatients());
        return patients;
    }
    public void setPatients(ListDataModel<Patient> patients) {
        this.patients = patients;
    }
    public void validatePeselDob(ComponentSystemEvent event) {

        UIForm form = (UIForm) event.getComponent();
        UIInput pesel = (UIInput) form.findComponent("pesel");
        UIInput birthDay = (UIInput) form.findComponent("birthDay");

        if (pesel.getValue() != null && birthDay.getValue() != null && pesel.getValue().toString().length() >= 2) {
                String twoDigitsOfPesel = pesel.getValue().toString().substring(0, 2);
                Calendar cal = Calendar.getInstance();
                cal.setTime(((Date) birthDay.getValue()));

                String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR)).toString().substring(2);

                if (!twoDigitsOfPesel.equals(lastDigitsOfDob)) {
                        FacesContext context = FacesContext.getCurrentInstance();
                        context.addMessage(form.getClientId(), new FacesMessage("Pesel nie pokrywa się z datą urodzenia!"));
                        context.renderResponse();
                }
        }
	}
    public void uniquePesel(FacesContext context, UIComponent component, Object value) {
                String pesel = (String) value;
                for(int i = 0; i < pesel.length()-1; i++)                {
                    if((pesel.charAt(i)!='0')&&(pesel.charAt(i)!='1')&&(pesel.charAt(i)!='2')&&(pesel.charAt(i)!='3')&&(pesel.charAt(i)!='4')&&(pesel.charAt(i)!='5')&&(pesel.charAt(i)!='6')&&(pesel.charAt(i)!='7')&&(pesel.charAt(i)!='8')&&(pesel.charAt(i)!='9'))
                    {
                        FacesMessage message = new FacesMessage("Type values only from 0 to 9.");
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(message);
                    }
                }
                if(pesel.length() != 11){
                    FacesMessage msgToShort = new FacesMessage("Pesel musi składać się z 11 cyfr!");
                    msgToShort.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msgToShort);
                }

		for (Patient patient : patientManager.getAllPatients()) {
			if (patient.getPesel().equalsIgnoreCase(pesel)) {
				FacesMessage message = new FacesMessage("Pacjent o podanym numerze Pesel już istnieje w bazie.");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
    }
    
     public void validatePhone(FacesContext context, UIComponent component, Object value){
         String phone = (String) value;
         for(int i = 0; i < phone.length()-1; i++){
                    if((phone.charAt(i)!='0')&&(phone.charAt(i)!='1')&&(phone.charAt(i)!='2')&&(phone.charAt(i)!='3')&&(phone.charAt(i)!='4')&&(phone.charAt(i)!='5')&&(phone.charAt(i)!='6')&&(phone.charAt(i)!='7')&&(phone.charAt(i)!='8')&&(phone.charAt(i)!='9'))
                    {
                        FacesMessage message = new FacesMessage("Wprowadź cyfry od 0 do 9!");
                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        throw new ValidatorException(message);
                    }
         }
         if(phone.length() != 9){
                    FacesMessage msgToShort = new FacesMessage("Numer telefonu musi składać się z 9 cyfr");
                    msgToShort.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msgToShort);
                }
     }
}
