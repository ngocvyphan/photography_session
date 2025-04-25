DROP DATABASE IF EXISTS cis2232_photography_session;
CREATE DATABASE cis2232_photography_session;
use cis2232_photography_session;

CREATE TABLE CodeType (
codeTypeId int(3) COMMENT 'This is the primary key for code types',
englishDescription varchar(100) NOT NULL COMMENT 'English description',
frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
createdDateTime datetime DEFAULT NULL,
createdUserId varchar(20) DEFAULT NULL,
updatedDateTime datetime DEFAULT NULL,
updatedUserId varchar(20) DEFAULT NULL
) COMMENT 'This tables holds the code types that are available for the application';

INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (1, 'User Types', 'User Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');
INSERT INTO CodeType (CodeTypeId, englishDescription, frenchDescription, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 'Photography Types', 'Photography Types FR', sysdate(), '', CURRENT_TIMESTAMP, '');

CREATE TABLE CodeValue (
codeTypeId int(3) NOT NULL COMMENT 'see code_type table',
codeValueSequence int(3) NOT NULL,
englishDescription varchar(100) NOT NULL COMMENT 'English description',
englishDescriptionShort varchar(20) NOT NULL COMMENT 'English abbreviation for description',
frenchDescription varchar(100) DEFAULT NULL COMMENT 'French description',
frenchDescriptionShort varchar(20) DEFAULT NULL COMMENT 'French abbreviation for description',
sortOrder int(3) DEFAULT NULL COMMENT 'Sort order if applicable',
createdDateTime datetime DEFAULT NULL,
createdUserId varchar(20) DEFAULT NULL,
updatedDateTime datetime DEFAULT NULL,
updatedUserId varchar(20) DEFAULT NULL
) COMMENT='This will hold code values for the application.';

# INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
#     (1, 1, 'General', 'General', 'GeneralFR', 'GeneralFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
# INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
#     (1, 2, 'Admin', 'Admin', 'Admin', 'Admin', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');

INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 1, 'Basic', 'Basic', 'BasicFR', 'BasicFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 2, 'Standard', 'Standard', 'StandardFR', 'StandardFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 3, 'Premium', 'Premium', 'PremiumFR', 'PremiumFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 4, 'Event', 'Event', 'EventFR', 'EventFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');
INSERT INTO CodeValue (codeTypeId, codeValueSequence, englishDescription, englishDescriptionShort, frenchDescription, frenchDescriptionShort, createdDateTime, createdUserId, updatedDateTime, updatedUserId) VALUES
    (2, 5, 'Custom', 'Custom', 'CustomFR', 'CustomFR', '2015-10-25 18:44:37', 'admin', '2015-10-25 18:44:37', 'admin');



CREATE TABLE UserAccess (
userAccessId int(3) NOT NULL,
username varchar(100) NOT NULL COMMENT 'Unique user name for app',
password varchar(128) NOT NULL,
name varchar(128),
userAccessStatusCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #2',
userTypeCode int(3) NOT NULL DEFAULT '1' COMMENT 'Code type #1',
createdDateTime datetime DEFAULT NULL COMMENT 'When user was created.'
);

ALTER TABLE CodeType
    ADD PRIMARY KEY (codeTypeId);

ALTER TABLE CodeValue
    ADD PRIMARY KEY (codeValueSequence);
--  ADD KEY codeTypeId (codeTypeId);

ALTER TABLE UserAccess
    ADD PRIMARY KEY (userAccessId),
    ADD KEY userTypeCode (userTypeCode);

ALTER TABLE CodeType
    MODIFY codeTypeId int(3) NOT NULL COMMENT 'This is the primary key for code types';

ALTER TABLE CodeValue
    MODIFY codeValueSequence int(3) NOT NULL;

ALTER TABLE UserAccess
    MODIFY userAccessId int(3) NOT NULL AUTO_INCREMENT;

CREATE TABLE PhotographySession(
                                   id                  int(5),
                                   clientName          varchar(20)   NOT NULL COMMENT 'Client name',
                                   packageNumber       int(3)   NOT NULL COMMENT 'The number of the package 1 (Basic), 2 (Standard), 3(Premium), 4(Event), 5(Custom)',
                                   date                varchar(10)   NOT NULL COMMENT 'Date of booking (yyyy-MM-dd)',
                                   sessionNotes        varchar(20)   NOT NULL COMMENT 'Additional information',
                                   numberOfHoursBooked int(3) NOT NULL default 0 COMMENT 'Number of hours booked for custom package',
                                   hourlyRate          decimal(6, 2) NOT NULL COMMENT 'The hourlyRate is $150/hr for each hour booked in the custom package',
                                   addedPhotoAlbum     boolean NOT NULL COMMENT 'if the client wants to add photo album or not (extra $50)',
                                   addedVideo          boolean NOT NULL COMMENT 'if the client wants to add video or not (extra $500)',
                                   addedExtraEditing   boolean NOT NULL COMMENT 'if the client wants to add extra editing or not (extra $100)',
                                   addedExtraPrints    boolean NOT NULL COMMENT 'if the client wants to add extra prints (extra $3/each)',
                                   numberOfExtraPrints int(3) NOT NULL COMMENT 'The number of extra prints the client wants to add',
                                   cost                decimal(6, 2) NOT NULL COMMENT 'Total cost'
) COMMENT 'This table holds photography session booking data';

ALTER TABLE PhotographySession
    ADD PRIMARY KEY (id);
ALTER TABLE PhotographySession
    MODIFY id int(4) NOT NULL AUTO_INCREMENT COMMENT 'This is the primary key', AUTO_INCREMENT=1;

#insert into PhotographySession values();
INSERT INTO photographysession (id, clientName, packageNumber, date, sessionNotes, numberOfHoursBooked, hourlyRate, addedPhotoAlbum, addedVideo, addedExtraEditing, addedExtraPrints, numberOfExtraPrints, cost) VALUES ('1', 'Emily', '1', '2024-10-11', 'basic', '1', '150', '1', '0', '0', '0', '0', '200');
INSERT INTO photographysession (id, clientName, packageNumber, date, sessionNotes, numberOfHoursBooked, hourlyRate, addedPhotoAlbum, addedVideo, addedExtraEditing, addedExtraPrints, numberOfExtraPrints, cost) VALUES ('2', 'Vy', '2', '2024-10-15', 'standard', '2', '150', '1', '0', '0', '1', '5', '365');