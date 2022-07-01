public class Patient {
    // Patient has a name and a medical specialization need
    private String patientName;
    private String medicalNeeds;

    //Constructor
    public Patient(String nameInput, String medicalNeedsInput) {
        this.patientName = nameInput;
        this.medicalNeeds = medicalNeedsInput;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicalNeeds() {
        return medicalNeeds;
    }

    public void setMedicalNeeds(String medicalNeeds) {
        this.medicalNeeds = medicalNeeds;
    }

}
