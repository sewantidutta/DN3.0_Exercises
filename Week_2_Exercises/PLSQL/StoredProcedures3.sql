DELIMITER //

CREATE PROCEDURE TransferFunds(IN sourceAccID INT, IN destAccID INT, IN amt DECIMAL(10,2))
BEGIN
    DECLARE currBal DECIMAL(10,2);

    SELECT bal INTO currBal FROM Accounts WHERE AccountID = sourceAccID;

    IF currBal >= amt THEN
        UPDATE Accounts SET bal = bal - amt WHERE AccountID = sourceAccID;

        UPDATE Accounts SET bal = bal + amt WHERE AccountID = destAccID;
    ELSE
        SIGNAL SQLSTATE '5000' SET MESSAGE_TEXT = 'Insufficient funds in the source account';
    END IF;
    
END //

DELIMITER ;