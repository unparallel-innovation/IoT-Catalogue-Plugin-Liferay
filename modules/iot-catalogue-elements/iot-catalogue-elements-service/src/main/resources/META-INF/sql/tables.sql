create table FOO_Category (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	iotCatalogueId VARCHAR(75) null
);

create table FOO_Element (
	uuid_ VARCHAR(75) null,
	elementId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	iotCatalogueId VARCHAR(75) null,
	collectionName VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(1000) null,
	categoryId LONG
);

create table IoTCatalogue_Asdf (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	originalId VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table IoTCatalogue_Category (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	iotCatalogueId VARCHAR(75) null
);

create table IoTCatalogue_ComponentChild (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	componentOrignalId VARCHAR(75) null,
	childComponentOriginalId VARCHAR(75) null,
	subscriptionId LONG
);

create table IoTCatalogue_Element (
	uuid_ VARCHAR(75) null,
	elementId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	iotCatalogueId VARCHAR(75) null,
	collectionName VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(1000) null,
	categoryId LONG
);

create table IoTCatalogue_ElementCoordinate (
	uuid_ VARCHAR(75) null,
	elementCoordinateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	elementOriginalId VARCHAR(75) null,
	elementClassName VARCHAR(75) null,
	latitude DOUBLE,
	longitude DOUBLE,
	subscriptionId LONG
);

create table IoTCatalogue_ElementEntity (
	uuid_ VARCHAR(75) null,
	elementEntityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	elementOriginalId VARCHAR(75) null,
	elementClassName VARCHAR(75) null,
	name VARCHAR(75) null,
	website VARCHAR(75) null,
	label VARCHAR(75) null,
	subscriptionId LONG
);

create table IoTCatalogue_ElementStandard (
	uuid_ VARCHAR(75) null,
	elementStandardId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	elementOriginalId VARCHAR(75) null,
	elementClassName VARCHAR(75) null,
	name VARCHAR(75) null,
	subscriptionId LONG
);

create table IoTCatalogue_IoTComponent (
	uuid_ VARCHAR(75) null,
	iotComponentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	originalId VARCHAR(75) null,
	name VARCHAR(1000) null,
	description TEXT null,
	embeddedUrl VARCHAR(2000) null,
	imageUrl VARCHAR(500) null,
	license VARCHAR(75) null,
	trl VARCHAR(75) null,
	elementStatus VARCHAR(75) null,
	subscriptionId LONG
);

create table IoTCatalogue_IoTValidation (
	uuid_ VARCHAR(75) null,
	iotValidationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	originalId VARCHAR(75) null,
	name VARCHAR(1000) null,
	description TEXT null,
	embeddedUrl VARCHAR(2000) null,
	imageUrl VARCHAR(500) null,
	elementStatus VARCHAR(75) null,
	subscriptionId LONG
);

create table IoTCatalogue_Subscription (
	uuid_ VARCHAR(75) null,
	subscriptionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	connectionId VARCHAR(75) null,
	connectionState VARCHAR(75) null,
	token VARCHAR(75) null,
	host VARCHAR(75) null,
	componentPagePath VARCHAR(75) null,
	validationPagePath VARCHAR(75) null,
	port INTEGER,
	useSSL BOOLEAN
);

create table IoTCatalogue_ValidationChild (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	validationOrignalId VARCHAR(75) null,
	childValidationOriginalId VARCHAR(75) null,
	subscriptionId LONG
);