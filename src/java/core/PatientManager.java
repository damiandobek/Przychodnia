
package core;
//Imports--------------------------------------------------------------

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

//Class----------------------------------------------------------------

@ApplicationScoped
public class PatientManager {
    
//Fields---------------------------------------------------------------   
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private boolean added = false;                                      //accessory field to check if example patients has been added
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  //date format
    
    private int choice;
//Methods--------------------------------------------------------------
        /*
        Method create patient with accessory patient and add him to base
        */
    public void addPatient(Patient patient){
        Patient newPatient = new Patient();
        newPatient.setName      (patient.getName());
        newPatient.setSurname   (patient.getSurname());
        newPatient.setAddress   (patient.getAddress());
        newPatient.setHeight    (patient.getHeight());
        newPatient.setWeight    (patient.getWeight());
        newPatient.setPesel     (patient.getPesel());
        newPatient.setPhone     (patient.getPhone());
        newPatient.setRegDate   (new Date());
        newPatient.setBirthDay  (patient.getBirthDay());
        
        newPatient.setRegDateToShow(sdf.format(new Date()));                //formating date to string with format dd/MM/yyyy
        newPatient.setBirthDayToShow(sdf.format(patient.getBirthDay()));    //formating date to string with format dd/MM/yyyy
        
        patients.add(newPatient);
    }
        /*
        Method delete Patient from arrayList
        */
    public void deletePatient(Patient patient) {
		Patient patientToRemove = null;
		for (Patient p : patients) {
			if (patient.getPesel().equals(p.getPesel())) {
				patientToRemove = p;
				break;
			}
		}
		if (patientToRemove != null)
			patients.remove(patientToRemove);
    }
        /*
        Method add example Patients
        */
    public void addExamplePatients(){
        
        if(!added){
        patients.add(new Patient("Dawid", "Mudlaff","Poniatowskiego 8",     "91031402437", "660043236", 84, 171,    new Date(88, 3, 21),    new Date(91, 3, 14)));
        patients.add(new Patient("Damian", "Nowak","Krynieckiego 18",       "91052802487", "665897436", 94, 180,    new Date(100, 8, 7),    new Date(91, 5, 28)));
        patients.add(new Patient("Karolina", "Poniatowska", "Obrzeża 12",   "88081802795", "512443236", 68, 175,    new Date(98, 11, 14),   new Date(88, 8, 18)));
        patients.add(new Patient("Marta", "Czerska", "Stanisa 55",          "92080202795", "512427836", 68, 175,    new Date(100, 11, 2),   new Date(92, 8, 2)));
        patients.add(new Patient("Teresa", "Czerska","Obojna 8",            "75051502727", "660043758", 80, 175,    new Date(81, 8, 10),    new Date(75, 5, 15)));
        patients.add(new Patient("Andrzej", "Kowalski","Mickiewicza 8",     "71060657849", "512025558", 89, 182,    new Date(80, 2, 6),     new Date(71, 6, 6)));
        patients.add(new Patient("Bartosz", "Szymanowski","Lekka 13",       "94042602488", "875693236", 72, 170,    new Date(100, 1, 16),   new Date(94, 4, 26)));
        patients.add(new Patient("Bartosz", "Karolak","Piecowa 13",         "91040402448", "875648896", 94, 170,    new Date(100, 1, 16),   new Date(91, 4, 4)));
        patients.add(new Patient("Lucjan", "Freczak","Ukryta 8",            "80020307748", "689954785", 80, 165,    new Date(92, 5, 12),    new Date(80, 2, 3)));
        patients.add(new Patient("Olga", "Poniatowska","Zwycięzców 78",     "95081888897", "587458963", 62, 175,    new Date(101, 8, 9),    new Date(95, 8, 18)));
        added = true;
        }
    }
        
    public List<Patient> getAllPatients(){
        return patients;
    }

    /**
     * @return the choice
     */
    public int getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    
    
    
    
}
