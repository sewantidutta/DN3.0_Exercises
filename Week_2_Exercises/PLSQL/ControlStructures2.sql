BEGIN
    FOR r IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF r.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 1
            WHERE CustomerID = r.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 0
            WHERE CustomerID = r.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;