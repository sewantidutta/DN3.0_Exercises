DECLARE
    CURSOR cur_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate 
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60;
BEGIN
    FOR r IN cur_customers LOOP
        UPDATE Loans
        SET InterestRate = r.InterestRate - 1
        WHERE LoanID = r.LoanID;
    END LOOP;
    COMMIT;
END;