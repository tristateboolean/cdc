package be.bramthielemans.cdc.cdcproducer.loan;

import java.util.List;

import static be.bramthielemans.cdc.cdcproducer.loan.LoanResponseDTO.LoanResult.ACCEPTED;
import static be.bramthielemans.cdc.cdcproducer.loan.LoanResponseDTO.LoanResult.REJECTED;
import static java.util.Arrays.asList;

public class LoanResponseDTO {

    enum LoanResult {
        ACCEPTED, REJECTED
    }

    public LoanResult result;
    public String reason;
    public double percentage;
    //public List<String> discounts;
    public List<Discount> discounts;

    private LoanResponseDTO() {
    }

    private LoanResponseDTO(LoanResult result, double percentage) {
        this.result = result;
        this.percentage = percentage;
    }

    private LoanResponseDTO(LoanResult result, double percentage, String... discounts) {
        this.result = result;
        this.percentage = percentage;
        //this.discounts = asList(discounts);
    }

    private LoanResponseDTO(LoanResult result, double percentage, Discount... discounts) {
        this.result = result;
        this.percentage = percentage;
        this.discounts = asList(discounts);
    }

    private LoanResponseDTO(LoanResult result, String reason) {
        this.result = result;
        this.reason = reason;
    }

    public static LoanResponseDTO accepted(double percentage) {
        return new LoanResponseDTO(ACCEPTED, percentage);
    }

    public static LoanResponseDTO accepted(double percentage, String... discounts) {
        return new LoanResponseDTO(ACCEPTED, percentage, discounts);
    }

    public static LoanResponseDTO accepted(double percentage, Discount... discounts) {
        return new LoanResponseDTO(ACCEPTED, percentage, discounts);
    }

    public static LoanResponseDTO rejected(String reason) {
        return new LoanResponseDTO(REJECTED, reason);
    }

}
