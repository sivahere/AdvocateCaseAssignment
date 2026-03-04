public class AdvocateCaseController {

    public static void main(String[] args) {

        AdvocateCaseService service = new AdvocateCaseService();

        // Add advocates
        service.addAdvocate(1, "Siva");
        service.addAdvocate(2, "Kumar");

        // Assign cases 
        service.assignCase(1, 1001, "Property Dispute");
        service.assignCase(1, 1002, "Contract Review");
        service.assignCase(2, 2001, "Criminal Appeal");

        // Duplicate case id test 
        service.assignCase(1, 1001, "Property Dispute - Duplicate");

        // Update 
        service.updateCaseStatus(1, 1001, "IN-PROGRESS");

        // Display individual advocates
        service.displayAdvocate(1);
        service.displayAdvocate(2);

        
        service.displayAll();
    }
}