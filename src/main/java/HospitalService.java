public class HospitalService {

    public void separatorLine() {
        System.out.println("****************************************************");
    }

    public void hospitalMakerInstructions() {
        System.out.println("Welcome to the Hospital Constructor Application");
        System.out.println("Please name your new hospital below: ");

    }

    public void doctorMakerInstructions() {
        System.out.println("Please create a doctor to add to the hospital");
        System.out.println("Please name the Doctor below: ");

    }

    public void doctorSpecialtyInstructions() {
        System.out.println("Now give your new doctor addition a specialty");
        System.out.println("Please name the Doctor specialty below: ");

    }

    public void patientMakerInstructions() {
        System.out.println("Please create a Patient to add to the hospital");
        System.out.println("Please name the Patient below: ");
    }

    public void patientMedicalNeedsInstructions() {
        System.out.println("Now give your new patient addition a specialty need \n I.E: 'Radiaology'");
        System.out.println("Please name the medical specialty need below: ");
    }
}