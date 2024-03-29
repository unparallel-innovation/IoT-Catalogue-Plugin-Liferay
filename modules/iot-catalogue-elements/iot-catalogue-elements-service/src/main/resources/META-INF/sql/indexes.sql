create index IX_1B3EBB17 on FOO_Category (groupId, iotCatalogueId[$COLUMN_LENGTH:75$]);
create index IX_8A6BF307 on FOO_Category (iotCatalogueId[$COLUMN_LENGTH:75$]);
create index IX_744CCB51 on FOO_Category (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4681F213 on FOO_Category (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BF2828B6 on FOO_Element (categoryId);
create index IX_2F3AB758 on FOO_Element (groupId, categoryId, iotCatalogueId[$COLUMN_LENGTH:75$]);
create index IX_665D730 on FOO_Element (iotCatalogueId[$COLUMN_LENGTH:75$], collectionName[$COLUMN_LENGTH:75$]);
create index IX_922808FD on FOO_Element (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F328AABF on FOO_Element (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9E787ECC on IoTCatalogue_Asdf (groupId);
create index IX_9CF9BCDE on IoTCatalogue_Asdf (originalId[$COLUMN_LENGTH:75$]);
create index IX_1613BE12 on IoTCatalogue_Asdf (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3B38A114 on IoTCatalogue_Asdf (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5FDDC5C2 on IoTCatalogue_Category (groupId);
create index IX_E9CFEBDC on IoTCatalogue_Category (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_72D9B95E on IoTCatalogue_Category (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EF6ABBB6 on IoTCatalogue_ComponentChild (childComponentOriginalId[$COLUMN_LENGTH:75$], subscriptionId);
create index IX_189A48BF on IoTCatalogue_ComponentChild (componentOrignalId[$COLUMN_LENGTH:75$], subscriptionId);
create index IX_EA87E101 on IoTCatalogue_ComponentChild (groupId);
create index IX_B3ABE55 on IoTCatalogue_ComponentChild (subscriptionId);
create index IX_9B67077D on IoTCatalogue_ComponentChild (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C515493F on IoTCatalogue_ComponentChild (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2DF686B9 on IoTCatalogue_Element (groupId, categoryId);
create index IX_3A633085 on IoTCatalogue_Element (iotCatalogueId[$COLUMN_LENGTH:75$], collectionName[$COLUMN_LENGTH:75$]);
create index IX_F0C92B12 on IoTCatalogue_Element (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2E654E14 on IoTCatalogue_Element (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9E69CFDD on IoTCatalogue_ElementCoordinate (elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$]);
create index IX_427E1F34 on IoTCatalogue_ElementCoordinate (groupId);
create index IX_74A11B1C on IoTCatalogue_ElementCoordinate (status);
create index IX_3D6CF8D1 on IoTCatalogue_ElementCoordinate (subscriptionId, elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$]);
create index IX_4C3812AA on IoTCatalogue_ElementCoordinate (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E7193BAC on IoTCatalogue_ElementCoordinate (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B2445D52 on IoTCatalogue_ElementEntity (elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$], label[$COLUMN_LENGTH:75$]);
create index IX_CC0C53E9 on IoTCatalogue_ElementEntity (groupId);
create index IX_70CEFBC7 on IoTCatalogue_ElementEntity (status);
create index IX_A8DD43DE on IoTCatalogue_ElementEntity (subscriptionId, elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$], label[$COLUMN_LENGTH:75$]);
create index IX_45515995 on IoTCatalogue_ElementEntity (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_511D4157 on IoTCatalogue_ElementEntity (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_34BF54F8 on IoTCatalogue_ElementStandard (elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$]);
create index IX_FDD2CACF on IoTCatalogue_ElementStandard (groupId);
create index IX_F68B1021 on IoTCatalogue_ElementStandard (status);
create index IX_4C02E7EC on IoTCatalogue_ElementStandard (subscriptionId, elementOriginalId[$COLUMN_LENGTH:75$], elementClassName[$COLUMN_LENGTH:75$]);
create index IX_66B456F on IoTCatalogue_ElementStandard (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D3945BB1 on IoTCatalogue_ElementStandard (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_54BB3957 on IoTCatalogue_IoTComponent (groupId, status);
create index IX_CCC1E73D on IoTCatalogue_IoTComponent (originalId[$COLUMN_LENGTH:75$], groupId, subscriptionId);
create index IX_3E43DAA5 on IoTCatalogue_IoTComponent (originalId[$COLUMN_LENGTH:75$], subscriptionId);
create index IX_5B1433F on IoTCatalogue_IoTComponent (status);
create index IX_A50205E5 on IoTCatalogue_IoTComponent (subscriptionId);
create index IX_E07AAB0D on IoTCatalogue_IoTComponent (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5EDC90CF on IoTCatalogue_IoTComponent (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_FE43C7 on IoTCatalogue_IoTValidation (groupId, status);
create index IX_360759AD on IoTCatalogue_IoTValidation (originalId[$COLUMN_LENGTH:75$], groupId, subscriptionId);
create index IX_A84EEA35 on IoTCatalogue_IoTValidation (originalId[$COLUMN_LENGTH:75$], subscriptionId);
create index IX_8493BACF on IoTCatalogue_IoTValidation (status);
create index IX_57FBED75 on IoTCatalogue_IoTValidation (subscriptionId);
create index IX_BC98EE9D on IoTCatalogue_IoTValidation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_11D6785F on IoTCatalogue_IoTValidation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_41F96243 on IoTCatalogue_Subscription (groupId);
create index IX_1005D07B on IoTCatalogue_Subscription (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9C2E39BD on IoTCatalogue_Subscription (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7F2A4A38 on IoTCatalogue_ValidationChild (childValidationOriginalId[$COLUMN_LENGTH:75$], subscriptionId);
create index IX_EA5D1E45 on IoTCatalogue_ValidationChild (groupId);
create index IX_C146CC91 on IoTCatalogue_ValidationChild (subscriptionId);
create index IX_FEA876B9 on IoTCatalogue_ValidationChild (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7B21577B on IoTCatalogue_ValidationChild (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_6BF29751 on IoTCatalogue_ValidationChild (validationOrignalId[$COLUMN_LENGTH:75$], subscriptionId);