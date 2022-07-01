import java.util.ArrayList;
import java.util.List;


public class Doctor {
    //Doctor needs a name and a medical specialization
    private String doctorName;
    private String doctorSpecialization;
    private List<Patient> patientList;

    //Constructor
    public Doctor(String doctorNameInput, String doctorSpecializationInput) {
        this.doctorName = doctorNameInput;
        this.doctorSpecialization = doctorSpecializationInput;
        this.patientList = new ArrayList<>();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public void addPatientToDoctor(Patient patientToAdd) {
        patientList.add(patientToAdd);
    }


    public void getPatientList() {
        System.out.println("The doctor is: " + doctorName);
            for (Patient patient : patientList) {
                String gotName = patient.getPatientName();
                String gotSpecialty = patient.getMedicalNeeds();
                String result = ("Patient Name: " + gotName + ", and thier Medical needs are: " + gotSpecialty);
    
                System.out.println(result);
            }
        }
}
