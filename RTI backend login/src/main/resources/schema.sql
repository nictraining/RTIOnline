-- Create NetUser table
CREATE TABLE NetUser (
  UserCode SERIAL PRIMARY KEY,
  UserName VARCHAR(100) UNIQUE NOT NULL,
  mobile VARCHAR(15) NOT NULL,
  UserType VARCHAR(50),
  active_idle CHAR(1) DEFAULT 'N',
  ActivationKey VARCHAR(100),
  ActivationKeyConf VARCHAR(100),
  LoginAttempts INT DEFAULT 0,
  LastSuccessfulLogin TIMESTAMP,
  LastUnSuccessfulLogin TIMESTAMP
);

-- Create LoginHistory table
CREATE TABLE LoginHistory (
  id SERIAL PRIMARY KEY,
  Login_Date_Time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  IP VARCHAR(50),
  Browser VARCHAR(200),
  OS VARCHAR(100),
  PA VARCHAR(200),
  UCode INT REFERENCES NetUser(UserCode),
  UserName VARCHAR(100)
);

