CREATE OR REPLACE PROCEDURE UpdateSal (
    EmployeeID IN NUMBER,
    percent IN NUMBER
)
IS
    EmployeeNotFound EXCEPTION;
    Ecount NUMBER;
    


BEGIN
    SELECT COUNT(*) INTO Ecount FROM Employees WHERE ID = EmployeeID FOR UPDATE;
    
    IF Ecount = 0 THEN
        RAISE EmployeeNotFound;
    ELSE
        UPDATE Employees 
        SET sal = sal + (sal *(percent / 100)) 
        WHERE ID = EmployeeID;
    END IF;
    COMMIT;

EXCEPTION
    WHEN EmployeeNotFound THEN
        INSERT INTO ErrorLogs (message, log_time) VALUES ('Employee ID not found', SYSDATE);
        ROLLBACK;
    WHEN OTHERS THEN
        INSERT INTO ErrorLogs (message, log_time) VALUES (SQLERRM, SYSDATE);
        ROLLBACK;


        

END UpdateSal;