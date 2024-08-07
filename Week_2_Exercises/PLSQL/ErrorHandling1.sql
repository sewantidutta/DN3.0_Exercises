CREATE OR REPLACE PROCEDURE TransferFunds (
    from_AccountID IN NUMBER,
    to_AccountID IN NUMBER,
    amt IN NUMBER
)
IS
    insufficientFunds EXCEPTION;
    fundsBal NUMBER;
BEGIN
    SELECT bal INTO fundsBal FROM Accounts WHERE Account_ID = from_AccountID FOR UPDATE;
    
    IF fundsBal < amt THEN
        RAISE insufficientFunds;
    ELSE
        UPDATE Accounts SET bal = bal - amt WHERE Account_ID = from_AccountID;
        
        UPDATE Accounts SET bal = bal + amt WHERE Account_ID = to_AccountID;
    END IF;

    COMMIT;
EXCEPTION
    WHEN insufficientFunds THEN
        INSERT INTO ErrorLogs (message, log_time) VALUES ('Insufficient funds for transfer', SYSDATE);
        ROLLBACK;
    WHEN OTHERS THEN
        INSERT INTO ErrorLogs (message, log_time) VALUES (SQLERRM, SYSDATE);
        ROLLBACK;
END TransferFunds;