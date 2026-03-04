import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvocateCaseService {

	
    public static class Case {
        private int caseId;
        private String title;
        private String status;

        public Case(int caseId, String title) {
            this.caseId = caseId;
            this.title = title;
            this.status = "OPEN";
        }

        public int getCaseId() {
            return caseId;
        }

        public String getTitle() {
            return title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String newStatus) {
            this.status = newStatus;
        }

        @Override
        public String toString() {
            return "#" + caseId + " - " + title + " (" + status + ")";
        }
    }

    
    public static class Advocate {
        private int id;
        private String name;
        private List<Case> cases = new ArrayList<>();

        public Advocate(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public List<Case> getCases() { return cases; }
    }

    // Store advocates
    private Map<Integer, Advocate> advocateMap = new HashMap<>();

    

    public void addAdvocate(int id, String name) {
        if (advocateMap.containsKey(id)) {
            System.out.println("Advocate already exists!");
            return;
        }
        advocateMap.put(id, new Advocate(id, name));
        System.out.println("Advocate added: " + name);
    }

    

    public void assignCase(int advocateId, int caseId, String caseTitle) {
        Advocate adv = advocateMap.get(advocateId);

        if (adv == null) {
            System.out.println("Advocate not found!");
            return;
        }

        
        for (Case c : adv.getCases()) {
            if (c.getCaseId() == caseId) {
                System.out.println("Case with this ID already assigned to the advocate!");
                return;
            }
        }

        adv.getCases().add(new Case(caseId, caseTitle));
        System.out.println("Case assigned to " + adv.getName());
    }

    public void updateCaseStatus(int advocateId, int caseId, String newStatus) {
        Advocate adv = advocateMap.get(advocateId);

        if (adv == null) {
            System.out.println("Advocate not found!");
            return;
        }

        for (Case c : adv.getCases()) {
            if (c.getCaseId() == caseId) {
                c.setStatus(newStatus);
                System.out.println("Case status updated");
                return;
            }
        }

        System.out.println("Case not found!");
    }

    public void displayAdvocate(int advocateId) {
        Advocate adv = advocateMap.get(advocateId);

        if (adv == null) {
            System.out.println("Advocate not found!");
            return;
        }

        System.out.println("\nAdvocate: " + adv.getName());
        System.out.println("Cases:");

        if (adv.getCases().isEmpty()) {
            System.out.println("No cases assigned.");
            return;
        }

        for (Case c : adv.getCases()) {
            System.out.println("- " + c);
        }
    }

    public void displayAll() {
        System.out.println("\n All Advocates & Cases ");

        for (Advocate a : advocateMap.values()) {
            System.out.println("\nID: " + a.getId() + " | Name: " + a.getName());

            if (a.getCases().isEmpty()) {
                System.out.println("  No cases.");
            } else {
                for (Case c : a.getCases()) {
                    System.out.println("  - " + c);
                }
            }
        }
    }
}