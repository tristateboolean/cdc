package be.bramthielemans.cdc.cdcproducer.loan;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static be.bramthielemans.cdc.cdcproducer.loan.Discount.carInsurance;
import static be.bramthielemans.cdc.cdcproducer.loan.Discount.legalInsurance;
import static be.bramthielemans.cdc.cdcproducer.loan.LoanResponseDTO.accepted;
import static be.bramthielemans.cdc.cdcproducer.loan.LoanResponseDTO.rejected;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @PutMapping
    public LoanResponseDTO check(@RequestBody LoanRequestDTO loanRequestDTO) {
        if(loanRequestDTO.loanAmount > 500000) {
            return rejected("AMOUNT_TOO_HIGH");
        }
        //return accepted(2.0, "LEGAL_INSURANCE", "CAR_INSURANCE");
        return accepted(2.0, legalInsurance(), carInsurance());
    }

}
