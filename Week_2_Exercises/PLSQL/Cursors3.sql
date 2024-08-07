DECLARE
    CURSOR c_loan IS
        SELECT LoanID, InterestRate
        FROM Loans;
    
    eLoanID Loans.LoanID%TYPE;
    eCurrentInterestRate Loans.InterestRate%TYPE;
    eNewInterestRate NUMBER;

    FUNCTION calculateNewInterestRate(EcurrRate NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN EcurrRate + 0.01;
    END;

BEGIN
    OPEN c_loan;
    
    LOOP
        FETCH c_loan INTO eLoanID, eCurrentInterestRate;
        EXIT WHEN c_loan%NOTFOUND;
        
        eNewInterestRate := calculateNewInterestRate(eCurrentInterestRate);
        
        UPDATE Loans
        SET InterestRate = eNewInterestRate
        WHERE LoanID = eLoanID;
        
        DBMS_OUTPUT.PUT_LINE('Updated LoanID: ' || eLoanID || ' to new interest rate: ' || eNewInterestRate);
    END LOOP;
    
    CLOSE c_loan;
END;
/