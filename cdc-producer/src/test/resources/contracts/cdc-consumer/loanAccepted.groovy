package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url '/loan'
        body([
                clientId: $(regex('[0-9]{10}')),
                loanAmount: 99999
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
                result: "ACCEPTED",
                percentage: anyDouble(),
                //discounts: [anyNonBlankString()]
                discounts: [
                        [
                                condition: anyNonBlankString(),
                                discountedPercentage: anyDouble()
                        ]
                ]
        ])
        headers {
            contentType('application/json')
        }
    }
}