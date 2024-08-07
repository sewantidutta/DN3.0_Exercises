DECLARE
    CURSOR c_acc IS
        SELECT AccountID, Balance
        FROM Accounts;
    
    EaccountID Accounts.AccountID%TYPE;
    Ebalance Accounts.Balance%TYPE;
    E_annualfee NUMBER := 50; 

BEGIN
    OPEN c_acc;
    
    LOOP
        FETCH c_acc INTO EaccountID, Ebalance;
        EXIT WHEN c_acc%NOTFOUND;
     
        UPDATE Accounts
        SET Balance = Ebalance - E_annualfee
        WHERE AccountID = EaccountID;
    
        DBMS_OUTPUT.PUT_LINE('Applied fee to AccountID: ' || EaccountID);
    END LOOP;
    
    CLOSE c_acc;
END;
/