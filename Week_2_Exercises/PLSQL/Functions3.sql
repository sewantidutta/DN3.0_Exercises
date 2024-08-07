CREATE OR REPLACE FUNCTION HasSufficientBalance (
    AccountID IN NUMBER,
    amount IN NUMBER
) RETURN BOOLEAN
IS
    currBal NUMBER;
BEGIN
    -- Retrieve the current balance of the account
    SELECT balance INTO currBal FROM Accounts WHERE AccountID = AccountID;
    
    -- Check if the balance is sufficient
    IF currBal >= amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the case where the account ID does not exist
        RETURN FALSE;
    WHEN OTHERS THEN
        -- Handle any other exceptions
        RETURN FALSE;
        
END HasSufficientBalance;