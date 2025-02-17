import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // your code here

        HospitalService hospitalService = new HospitalService();
        // 1. Runner begins, welcomes you to the Hospital world, asks User to name it
        Scanner scanner = new Scanner(System.in);
        hospitalService.hospitalMakerInstructions();
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
            hospitalService.doctorMakerInstructions();
            String doctorNameInput = scanner.nextLine();
            hospitalService.doctorSpecialtyInstructions();
            String doctorSpecialtyInput = scanner.nextLine();

            // 4. Generate 3 doctors with the properties given by user
            Doctor doctorObject = new Doctor(doctorNameInput, doctorSpecialtyInput);

            // 5. Add the 3 doctors to the Hospital
            hospital.addDoctorToExpertiseMap(doctorSpecialtyInput, doctorObject);
            hospitalService.separatorLine();
        }
        System.out.println("All Doctors have been added to the Hospital");
        hospitalService.separatorLine();

        for (int k = 0; k < 5; k++) {
            // 6. Ask the user to create 5 Patients, each with a name and specialization
            // need
            hospitalService.patientMakerInstructions();
            String patientNameInput = scanner.nextLine();
            hospitalService.patientMedicalNeedsInstructions();
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
                System.out.println("Please choose a doctor to assign the patient to: (Use the number associated with that Doctor)");
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
            // User types the number of doctor that they want to assign the patient to
            // (String Comparison vs user input)
            // Add patient to chosen doctors list

            // ***************************************************** */

            // System.out.println(patientNameInput + " has been added to the hospital with a
            // specialty need of " + patientMedicalNeedInput);
            hospitalService.separatorLine();
        }
        System.out.println("All Patients have been added to the hospital");
        hospitalService.separatorLine();
        hospitalService.separatorLine();
        System.out.println((hospital.getHospitalName()).toUpperCase() + " HOSPITAL DETAILS: ");
       for (String key : new HashSet<String>(hospital.getExpertiseMap().keySet())) {
           System.out.println(key.toUpperCase() + " Doctors: ");
           for (Doctor doctor : hospital.getExpertiseMap().get(key)) {
               doctor.getPatientList();
           }
       }
       scanner.close();
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