import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // your code here

        // 1. Runner begins, welcomes you to the Hospital world, asks User to name it
        Scanner scanner = new Scanner(System.in);
        hospitalMakerInstructions();
        String hospitalNameInput = scanner.nextLine();

        // 1.5. Initialize Arraylists to store Doctor and Patient objects, to be given
        // to Hospital constructor

        // 2. Create instance of Hospital world using the user input
        Hospital hospital = new Hospital(hospitalNameInput);

        // Doctor gives Name + Expertise Info
        // Hospital checks if expertise is listed as a specialty (Checking if key is
        // existent)
        // IF - Specialty NOT listed: Create that specialty distinction, File doctor in
        // it
        // ELSE IF - Specialty IS listed: File doctor in that specialty
        // repeat 2 times

        for (int i = 0; i < 3; i++) {
            // 3. Ask to create 3 doctors, each with a name and specialty
            doctorMakerInstructions();
            String doctorNameInput = scanner.nextLine();
            doctorSpecialtyInstructions();
            String doctorSpecialtyInput = scanner.nextLine();

            // 4. Generate 3 doctors with the properties given by user
            Doctor doctorObject = new Doctor(doctorNameInput, doctorSpecialtyInput);

            // 5. Add the 3 doctors to the Hospital
            hospital.addDoctorToExpertiseMap(doctorSpecialtyInput, doctorObject);

            // doctorList.add(doctorObject);
            // System.out.println(doctorNameInput + " has been added to the hospital with a
            // specialty of " + doctorSpecialtyInput);
            seperatorLine();
        }
        System.out.println("All Doctors have been added to the Hospital");
        seperatorLine();

        for (int k = 0; k < 5; k++) {
            // 6. Ask the user to create 5 Patients, each with a name and specialization
            // need
            patientMakerInstructions();
            String patientNameInput = scanner.nextLine();
            patientMedicalNeedsInstructions();
            String patientMedicalNeedInput = scanner.nextLine();

            // 7. Generate 5 patients with the properties given by the user
            Patient patientObject = new Patient(patientNameInput, patientMedicalNeedInput);

            // 8. Add the patients to the DOCTOR
            if (hospital.getExpertiseMap().containsKey(patientObject.getMedicalNeeds())) {
                List<Doctor> doctorsOfSpecialty = hospital.getDoctorList(patientObject.getMedicalNeeds());
                System.out.println("Available Doctors with required specialization (Please Pick a number associated with a doctor!");
                int indexLocale = 0;
                for (Doctor doctor : doctorsOfSpecialty) {
                    indexLocale += 1;
                    System.out.println(indexLocale + ". " + doctor.getDoctorName());
                }
                System.out.println("Please choose a doctor to assign the patient to: ");
                int chosenDoctorIndex = 0;
                try {
                    chosenDoctorIndex = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Please use a number to pick your doctor");
                }
                scanner.nextLine();

                if (chosenDoctorIndex == 0) {
                    System.out.println("There is no doctor with the specializations needed");
                } else {

                    Doctor doctorChosen = doctorsOfSpecialty.get((chosenDoctorIndex - 1));
                    doctorChosen.addPatientToDoctor(patientObject);
                    System.out.println(patientObject.getPatientName() + " has been give to " + doctorChosen.getDoctorName() + " as a patient!");
                }
            } else {
                System.out.println("The Medical system can't support this individuals needs :( ");
            }

            // ***************************************************** */
            // Check to see if medical need is listed as a expertise
            //
            // K (String) \ V
            // Radiolgoy --> List(Doctors) -> [BillyBob, Johnny]
            // \ \
            // Function => List Doctors with Availability
            // User types name of doctor that they want to assign the patient to
            // (String Comparison vs user input)
            // Add patient to chosen doctors list

            // ***************************************************** */

            // System.out.println(patientNameInput + " has been added to the hospital with a
            // specialty need of " + patientMedicalNeedInput);
            seperatorLine();
        }
        System.out.println("All Patients have been added to the hospital");
        seperatorLine();
        seperatorLine();
        System.out.println((hospital.getHospitalName()).toUpperCase() + " HOSPITAL DETAILS: ");
       for (String key : new HashSet<String>(hospital.getExpertiseMap().keySet())) {
           System.out.println(key.toUpperCase() + ": ");
           for (Doctor doctor : hospital.getExpertiseMap().get(key)) {
               doctor.getPatientList();
           }
       }
    }

    // ******************************************************
    // STATIC RUNNER METHODS

    public static void seperatorLine() {
        System.out.println("****************************************************");
    }

    public static void hospitalMakerInstructions() {
        System.out.println("Welcome to the Hospital Constructor Application");
        System.out.println("Please name your new hospital below: ");

    }

    public static void doctorMakerInstructions() {
        System.out.println("Please create a doctor to add to the hospital");
        System.out.println("Please name the Doctor below: ");

    }

    public static void doctorSpecialtyInstructions() {
        System.out.println("Now give your new doctor addition a specialty");
        System.out.println("Please name the Doctor specialty below: ");

    }

    public static void patientMakerInstructions() {
        System.out.println("Please create a Patient to add to the hospital");
        System.out.println("Please name the Patient below: ");
    }

    public static void patientMedicalNeedsInstructions() {
        System.out.println("Now give your new patient addition a specialty need \n I.E: 'Radiaology'");
        System.out.println("Please name the medical specialty need below: ");
    }
}

// PSUEDOCODE:

// 1. Runner begins, welcomes you to the Hospital world, asks User to name it

// 2. create instance of Hospital world using the user input

// 3. Ask to create 3 doctors, each with a name and specialty

// 4. Generate 3 doctors with the properties given by user

// 5. Add the 3 doctors to the Hosptial

// 6. Ask the user to create 5 Patients, each with a name and specialization
// need

// 7. Generate 5 patients with the properties given by the user

// 8. Add the patients to the Hospital

// 9. After all inputs have been recieved, represent the world in the command
// line

// 10.