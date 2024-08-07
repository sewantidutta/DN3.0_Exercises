DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    DECLARE d INT DEFAULT 0;
    DECLARE AccountID INT;
    DECLARE bal DECIMAL(10,2);
    DECLARE c CURSOR FOR SELECT AccountID, bal FROM SaveAcc;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET d = 1;
    
    OPEN c;

    readLoop: LOOP
        FETCH c INTO AccountID, bal;
        IF d THEN
            LEAVE readLoop;
        END IF;

        SET bal = bal + (bal * 0.01);

        UPDATE SaveAcc SET bal = bal WHERE AccountID = AccountID;
    END LOOP;

    CLOSE c;
END //

DELIMITER ;