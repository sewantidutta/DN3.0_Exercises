
SET SERVEROUTPUT ON;
DECLARE
    CURSOR c_trans IS
        SELECT DISTINCT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE) 
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
          
    eCustomerID Customers.CustomerID%TYPE;
    Ename Customers.Name%TYPE;
    eTransactionDate Transactions.TransactionDate%TYPE;
    eAmount Transactions.Amount%TYPE;
    eTransactionType Transactions.TransactionType%TYPE;

BEGIN
    OPEN c_trans;
    
    LOOP
        FETCH c_trans INTO eCustomerID, Ename, eTransactionDate, eAmount, eTransactionType;
        EXIT WHEN c_trans%NOTFOUND;
       
        DBMS_OUTPUT.PUT_LINE('CustomerID: ' || eCustomerID);
        DBMS_OUTPUT.PUT_LINE('Name: ' || Ename);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || eTransactionDate);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || eAmount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || eTransactionType);
        DBMS_OUTPUT.PUT_LINE('--------------------------');
    END LOOP;
    
    CLOSE c_trans;
END;
/