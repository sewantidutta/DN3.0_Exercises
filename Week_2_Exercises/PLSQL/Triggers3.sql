CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    currbal NUMBER;
BEGIN
    IF :NEW.transactionType = 'WITHDRAWAL' THEN 
        SELECT bal INTO currbal FROM Accounts WHERE accID = :NEW.accID FOR UPDATE;

        IF :NEW.amount > currbal THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds current balance.');
        END IF;
    ELSIF :NEW.transactionType = 'DEPOSIT' THEN
        -- Ensure the deposit amount is positive
        IF :NEW.amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END CheckTransactionRules;
/