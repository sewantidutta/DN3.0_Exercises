CREATE OR REPLACE PROCEDURE NewCustomer (
    customerID IN NUMBER, 
    customerName IN VARCHAR2, 
    customerEmail IN VARCHAR2
)
IS
    customerExists EXCEPTION;
    Ecount NUMBER;
BEGIN
    SELECT COUNT(*) INTO Ecount FROM Customers WHERE ID = customerID;
    
    IF Ecount > 0 THEN
        RAISE customerExists;
    ELSE
        INSERT INTO Customers (ID, name, email) VALUES (customerID, customerName, customerEmail);
    END IF;

    COMMIT;
EXCEPTION
    WHEN customerExists THEN  
        INSERT INTO ErrorLogs (message, log_time) VALUES ('Customer ID already exists', SYSDATE);
        ROLLBACK;
    WHEN OTHERS THEN
        INSERT INTO ErrorLogs (message, log_time) VALUES (SQLERRM, SYSDATE);
        ROLLBACK;
END NewCustomer;