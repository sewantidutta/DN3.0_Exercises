CREATE OR REPLACE FUNCTION CalMonthlyInstallment (
    loanAmt IN NUMBER,
    annualInterest IN NUMBER,
    loanYr IN NUMBER
) RETURN NUMBER
IS
    monthlyInterest NUMBER;
    numberOfPayments NUMBER;
    monthlyInstallment NUMBER;
BEGIN
    monthlyInterest := annualInterest / 12 / 100;
    numberOfPayments := loanYr * 12;
    
    IF monthlyInterest = 0 THEN
        monthlyInstallment := loanAmt / numberOfPayments;
    ELSE
        monthlyInstallment := loanAmt * monthlyInterest / 
            (1 - POWER(1 + monthlyInterest, -numberOfPayments));
    END IF;
    
    RETURN monthlyInstallment;
    
END CalMonthlyInstallment;
