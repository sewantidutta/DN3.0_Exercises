SET SERVEROUTPUT ON;

DECLARE
    CURSOR c IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND  SYSDATE + 30;

BEGIN
    FOR r IN c LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || r.Name || ', your loan (ID: ' || r.LoanID || ') is due on ' || TO_CHAR(r.EndDate, 'YYYY-MM-DD') || '.');
    END LOOP;
END;