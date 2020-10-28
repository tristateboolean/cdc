package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url '/loan'
        body([
                clientId: $(regex('[0-9]{10}')),
                loanAmount: 999999999
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
                result: "REJECTED",
                reason: anyOf("AMOUNT_TOO_HIGH", "FRAUD_ATTEMPT_DETECTED")
        ])
        headers {
            contentType('application/json')
        }
    }
}