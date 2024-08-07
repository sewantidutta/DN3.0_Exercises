DELIMITER //

CREATE PROCEDURE UpdateEmpBonus(IN deptName VARCHAR(100), IN bonusPercent DECIMAL(5,2))
BEGIN
    UPDATE Employees
    SET sal = sal + (sal * bonusPercent / 100)
    WHERE dept = deptName;
    
END //

DELIMITER ;