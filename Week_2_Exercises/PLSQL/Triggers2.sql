
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID, 
        AccID, 
        TransactionDate, 
        Amount, 
        TransactionType, 
        LogTime
    )
    VALUES (
        :NEW.TransactionID, 
        :NEW.AccID, 
        :NEW.TransactionDate, 
        :NEW.Amount, 
        :NEW.TransactionType, 
        SYSDATE
    );
END;
/